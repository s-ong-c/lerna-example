package food.board.shareController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import food.board.shareController.action.shareAction;

/**
 * Servlet implementation class ShareServlet
 */
@WebServlet("/ShareServlet")
public class ShareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShareServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("EE");
		
		String shareCommand = request.getParameter("shareCommand");
		System.out.println("shareCommand : " + shareCommand);
		ShareActionFactory af = ShareActionFactory.getInstance();
		shareAction  shareAction = af.getShareAction(shareCommand);
		
		if(shareAction != null){
			//#6] BoardListAction의 execute하러 가자!
			//#19] BoardWriteFormAction 의 execute하러 가자
			//#30] write ,  db 하러 가자
			//#42] view,  페이지에 보러 가자
			//#56] 스크립트 창에 뷰페이지 넣어주러 가자
			shareAction.execute(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
