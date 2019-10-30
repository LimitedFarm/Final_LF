package LF.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LF.board.model.service.BoardService;
import LF.board.model.vo.Attachment;
import LF.board.model.vo.Board;
import LF.board.model.vo.Reply;

/**
 * Servlet implementation class BoardDetail
 */
@WebServlet("/Board.do")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pId = 11;
		
		/* int pId = Integer.parseInt(request.getParameter("pId")); */
		
		
		BoardService bService = new BoardService();
		Board board = bService.selectBoard(pId);
		ArrayList<Reply> reply = bService.selectReply(pId);
		ArrayList<Attachment> fileList = bService.selectThumbnail(pId);
		
		if(fileList != null) {
			request.setAttribute("board", board);
			request.setAttribute("reply", reply);
			request.setAttribute("fileList", fileList);
			request.getRequestDispatcher("views/Board/PListView.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "상세보기 실패!");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
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
