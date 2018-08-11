package food.board.freeController;

import food.board.freeController.action.freeAction;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class PhotoServlet
 */
@WebServlet("/FreeServlet")
public class FreeServlet extends HttpServlet implements freeAction {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
     * @see PhotoAction#execute(HttpServletRequest, HttpServletResponse)
     */
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
         // TODO Auto-generated method stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String freeCommand = request.getParameter("freeCommand");
		
		System.out.println("freeCommand : " + freeCommand);
		
		ActionFactory af = ActionFactory.getInstance();
		
		
		freeAction  freeAction = af.getAction(freeCommand);
				

		if(freeAction != null){
			
			
			
			freeAction.execute(request, response);
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
