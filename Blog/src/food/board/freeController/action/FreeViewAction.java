package food.board.freeController.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import food.board.dto.foodVO;
import food.board.freedao.FreeDAO;

public class FreeViewAction implements freeAction {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	String num = request.getParameter("num");	

	
	FreeDAO dao = FreeDAO.getInstance();
	dao.updateReadCount(num);
	
	foodVO vo = FreeDAO.getInstance().selectOneBoard(num);
	vo.setBoardkind(1);
	
	request.setAttribute("free", vo);
	request.getRequestDispatcher("viewPage/freeView/freeView.jsp").forward(request,response);
	}

}
