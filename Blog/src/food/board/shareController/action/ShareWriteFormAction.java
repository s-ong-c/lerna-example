package food.board.shareController.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import food.logindto.loginVO;

public class ShareWriteFormAction implements shareAction {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		
		
		
		request.getRequestDispatcher("viewPage/shareView/shareWrite.jsp").forward(request, response);
		
	}

}
