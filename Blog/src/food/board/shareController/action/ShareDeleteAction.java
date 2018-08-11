package food.board.shareController.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food.board.freedao.FreeDAO;


public class ShareDeleteAction implements shareAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String num = request.getParameter("num");
			
			
			FreeDAO.getInstance().deleteFree(num);
			
		
			
			new ShareListAction().execute(request, response);
	}

}
