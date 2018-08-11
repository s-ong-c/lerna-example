package food.board.freeController.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food.board.freedao.FreeDAO;


public class FreeDeleteAction implements freeAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String num = request.getParameter("num");
			
			
			FreeDAO.getInstance().deleteFree(num);
			
		
			
			new FreeListAction().execute(request, response);
	}

}
