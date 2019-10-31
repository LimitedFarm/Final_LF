package LF.board.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

import LF.board.model.service.BoardService;
import LF.board.model.vo.Attachment;
import LF.board.model.vo.Board;
import LF.common.MyFileRenamePolicy;

/**
 * Servlet implementation class InsertBoardServlet
 */
@WebServlet("/insert.bo")
public class InsertBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		if(ServletFileUpload.isMultipartContent(request)) {
			int maxSize = 1024 * 1024 * 10;
			
			String root = request.getSession().getServletContext().getRealPath("/"); // 넘어오는 파일 경로(web폴더 경로)
			String savePath = root+"uploadFiles/";
			
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			ArrayList<String> saveFiles = new ArrayList<String>();
			ArrayList<String> originFiles = new ArrayList<String>();
			
			Enumeration<String> files = multiRequest.getFileNames();
			while(files.hasMoreElements()) {
				
				String name = files.nextElement();
				if(multiRequest.getFilesystemName(name) != null) {
					saveFiles.add(multiRequest.getFilesystemName(name));
					originFiles.add(multiRequest.getOriginalFileName(name));
				}
			}
			
			String pName = multiRequest.getParameter("pName");
			int pPrice = Integer.valueOf(multiRequest.getParameter("pPrice"));
			int pCount = Integer.valueOf(multiRequest.getParameter("pCount"));
			String pAddress = multiRequest.getParameter("add1") + multiRequest.getParameter("add2") + multiRequest.getParameter("add3");
			String pDay = multiRequest.getParameter("pDay");
			String pPeriod = multiRequest.getParameter("pPeriod");
			String pText1 = multiRequest.getParameter("pText1");
			String pText2 = multiRequest.getParameter("pText2");
			String pText3 = multiRequest.getParameter("pText3");
			String pText4 = multiRequest.getParameter("pText4");
			String pText5 = multiRequest.getParameter("pText5");
			String pNotice = multiRequest.getParameter("pNotice");
			String pDelivery = multiRequest.getParameter("pDelivery");
			int cate = Integer.valueOf(multiRequest.getParameter("cates"));
			int sid = Integer.valueOf(multiRequest.getParameter("sid"));
			System.out.println(sid);
			Board b = new Board();
			b.setpName(pName);
			b.setpPrice(pPrice);
			b.setpCount(pCount);
			b.setpAddress(pAddress);
			b.setpDay(pDay);
			b.setpPeriod(pPeriod);
			b.setpText1(pText1);
			b.setpText2(pText2);
			b.setpText3(pText3);
			b.setpText4(pText4);
			b.setpText5(pText5);
			b.setpNotice(pNotice);
			b.setpDelivery(pDelivery);
			b.setcAteid(cate);
			b.setsId(sid);
			
			
			ArrayList<Attachment> fileList = new ArrayList<Attachment>();
			
			for(int i=originFiles.size()-1; i>=0; i--) {
				Attachment at = new Attachment();
				at.setFilePath(savePath);
				at.setOriginName(originFiles.get(i));
				at.setChangeName(saveFiles.get(i));
				
				// 타이틀 이미지가 originFiles에서의 마지막 인덱스이기 때문에 다음과 같이 조건을 준 다음에 level을 0으로 지정
				if(i == originFiles.size()-1) {
					at.setFileLevel(0);	// 대표 이미지의 fileLevel값은 0
				}else {
					at.setFileLevel(1);	// 대표 이미지를 제외한 이미지의 fileLevel값은  1
				}
				fileList.add(at);
			}
			
			int result = new BoardService().insertThumbnail(b, fileList);
			
			if(result > 0) {
				request.getRequestDispatcher("/myOrder.bo").forward(request, response);;
			}else {
				//실패시 저장된 사진 삭제
				for(int i =0; i<saveFiles.size(); i++) {
					//파일 시스템에 저장된 이름으로 파일 객체 생성함
					File failedFile = new File(savePath+saveFiles.get(i));
					failedFile.delete();
				}
				
				request.setAttribute("msg", "사진 게시판 등록 실패!!");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			}
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
