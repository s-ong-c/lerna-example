package food.board.shareController.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food.board.dto.foodVO;
import food.board.freedao.FreeDAO;


public class ShareUpdateFormAction implements shareAction {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String num = request.getParameter("num");
		
		FreeDAO dao = FreeDAO.getInstance();
		
		foodVO vo =dao.selectOneBoard(num);
		request.setAttribute("free", vo);
		request.getRequestDispatcher("viewPage/shareView/shareUpdate.jsp").forward(request, response);
	}

}
