package food.board.freeController.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import food.board.dto.foodVO;
import food.board.freedao.FreeDAO;

public class FreeWriteAction implements freeAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		foodVO vo = new  foodVO();
		vo.setId(request.getParameter("id"));
		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content"));
		vo.setBoardkind(1);
		FreeDAO.getInstance().insertBoard(vo);
		
		new FreeListAction().execute(request, response);
	}

}
