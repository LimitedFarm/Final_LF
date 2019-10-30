package LF.seller.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

import LF.common.MyFileRenamePolicy;
import LF.member.model.vo.Seller;
import LF.seller.model.service.SellerService;
import LF.seller.model.vo.pAttachment;

/**
 * Servlet implementation class SellerRegistServlet
 */
@WebServlet("/sellerRegist.selr")
public class SellerRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellerRegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		

		// 폼 전송을 multipart/form-data로 전송하는 경우
		// 기존처럼 request.getParameter로 값을 받을 수 없다.
		// ex) String title = request.getParameter("title"); (x)

		// cos.jar가 파일도 받고 폼태그의 다른 값들도 받아주는 역할을 한다.
		// com.orellilly.servlet의 약자이다.

		// cos.jar 파일이 없다면 다운받아서 lib폴더에 복사하자(ojdbc6있는 폴더)

		// enctype이 multipart/form-data로 전송되었는지 확인!
		if (ServletFileUpload.isMultipartContent(request)) {

			// 1_1. 전송 파일 용량 제한 : 10Mbyte로 제한하는 경우
			int maxSize = 1024 * 1024 * 10; // 바이트 단위(바이트 > 키로바이트 > 메가바이트)

			// 1_2. 웹 서버 컨테이너 경로 추출함
			String root = request.getSession().getServletContext().getRealPath("/"); // 넘어오는 파일 경로(web폴더 경로)
//			System.out.println("파일 경로 : " + root);

			// 1_3. 파일들 저장 경로(web/thrumbnail_uploadFiles/)
			String savePath = root + "sellerImg/";

			// 2. 파일 명 변환 및 저장작업
			/*
			 * 객체 생성시 파일을 저장하고 그에 대한 정보를 가져오는 형태인데 저장한 다음 검사후 삭제를 해야 한다.
			 * 
			 * 사용자가 올린 파일명을 그대로 저장하지 않는 것이 일반적이다. - 같은 파일명이 있는 경우 이전 파일을 덮어쓸 수 있다. - 한글로 된
			 * 파일명, 특수 기호나 띄어쓰기 등은 서버에 따라 문제가 생길 수 있다.
			 * 
			 * DefaultFileRenamePolicy는 cos.jar 안에 존재하는 클래스이고 같은 파일명이 존재하는지를 검사하고 있을 경우에는
			 * 파일명 뒤에 숫자를 붙여준다. ex:aaa.zip, aaa1.zip, aaa2.zip
			 * 
			 * DefaultFileRenamePolicy 사용시 MultipartRequest multiRequest = new
			 * MultipartRequest(request, savePath, maxSize, "UTF-8", new
			 * DefaultFileRenamePolicy());
			 * 
			 * 하지만 우리는 DefaultFileRenamePolicy를 사용하지 않고 직접 우리 방식대로 rename작업을 하기 위한 클래스를 만들
			 * 것이다. common 패키지 안에 MyFileRenamePolicy 클래스를 FileRenamePolicy를 상속받아 만들어 주자!
			 * 
			 */
			
			// 2_1. 1번 작업에서 나온 결과(저장경로, 용량제한), 인코딩, 파일명 변환 기능이 있는 클래스들을 지정하여
			// MultipartRequest의 참조변수 multiReqeust 선언
			// --> 선언하는 순간에 MyFileRenamePolicy의 rename메소드가 실행되면서 rename된 파일이 폴더에 저장
			MultipartRequest multiRequest = new MultipartRequest(request,savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			// 2_2. DB에 저장하기 위해 change_name과 origin_name 각각의 리스트들을 만들어 주는 작업

			// 다중 파일을 묶어서 업로드(다중파일업로드) 하기 때문에 컬렉션을 사용
			// 저장한 파일의 이름을 저장할 ArrayList를 생성하자
			ArrayList<String> saveFiles = new ArrayList<String>();

			// 원본 파일의 이름을 저장할 ArrayList를 생성하자
			ArrayList<String> originFiles = new ArrayList<String>();

			// getFileNames() - 폼에서 전송된 파일 리스트들의 name들을 반환한다.
			Enumeration<String> files = multiRequest.getFileNames();

			while(files.hasMoreElements()) {
				// 전송 순서 역순으로 파일을 가져온다.
				String name = files.nextElement();
				
				if(multiRequest.getFilesystemName(name) != null) {
					// getFilesystemName() - MyRenamePolicy의 rename 메소드에서 작성한대로 rename된 파일명
					saveFiles.add(multiRequest.getFilesystemName(name));
					//getOriginalFileName() - 실제 사용자가 업로드 할 때의 파일 명
					originFiles.add(multiRequest.getOriginalFileName(name));
				}
			}

			// 3_1. 파일 외에 seller 정보 받아오기
			String bName = multiRequest.getParameter("bName");
			String bNum = multiRequest.getParameter("bNum");
			String cpNum = multiRequest.getParameter("cpNum");
			String bankName = multiRequest.getParameter("bankName");
			String acNum = multiRequest.getParameter("acNum");
			String acName = multiRequest.getParameter("acName");
			int cId = Integer.valueOf(multiRequest.getParameter("cid"));
			
			/*
			 * int cId = ((Seller)request.getSession().getAttribute("loginUser")).getCid();
			 */
			
			//menubar의 상단에서 현재 세션 유저의 로그인 상태 확인하는 그거 부분임
			
			// 3_2. DB에 보낼 seller 객체와 Attachment 리스트 생성
			Seller seller = new Seller(bName, bNum, cpNum, acNum, acName, bankName, cId);
			
			ArrayList<pAttachment> fileList = new ArrayList<pAttachment>();
			// 전송 순서 역순으로 파일이 list에 저장되어 있기 때문에 반복문을 역으로 수행함
			
			
			for(int i=originFiles.size()-1 ; i>=0 ; i--) {
				pAttachment at = new pAttachment();
				at.setFilePath(savePath);
				at.setFileName(originFiles.get(i));
				at.setChangeName(String.valueOf(cId) + saveFiles.get(i));
				
				// 타이틀 이미지가 originFiles에서의 마지막 인덱스이기 때문에 다음과 같이 조건을 준 다음에 level을 0으로 지정
//				if(i == originFiles.size()-1) {
//					at.setFileLevel(0); 	// 대표 이미지의 fileLevel 값은 0
//				}else {
//					at.setFileLevel(1); 	// 대표 이미지를 제외한 이미지의 fileLevel 값은 1
//				}
				
				fileList.add(at);
			}
			// 이렇게 하면 DB를 다녀올 준비가 끝남
			
			int result = new SellerService().registSeller(seller, fileList);	

			String page="";
			if (result > 0) {	//성공했을 때
				new SellerService().renameFile(saveFiles.get(0),fileList.get(0).getChangeName(), savePath);
				
				request.setAttribute("msg", "등록 완료");
				request.getRequestDispatcher("views/seller/successPage.jsp").forward(request, response);
//				response.sendRedirect("list.th");
			} else {	//실패 시
				// 실패시 저장된 사진 삭제
				for (int i = 0; i < saveFiles.size(); i++) {
					// 파일 시스템에 저장된 이름으로 파일 객체 생성함
					File failedFile = new File(savePath + saveFiles.get(i));
					failedFile.delete();
				}
				
				request.setAttribute("msg", "등록 실패");
				request.getRequestDispatcher("views/seller/errorPage.jsp").forward(request, response);

//				request.setAttribute("msg", "사진 게시판 등록 실패!!");
//				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			}
			// 여기까지 테스트 해보고 잘 되면 이제 사진 게시판 상세보기를 하자!! thumbnailListView.jsp로 돌아가장!
			
		}
	
						
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
