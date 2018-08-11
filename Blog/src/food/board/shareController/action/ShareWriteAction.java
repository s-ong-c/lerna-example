package food.board.shareController.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import food.board.dto.foodVO;
import food.board.freedao.FreeDAO;

public class ShareWriteAction implements shareAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		foodVO vo = new  foodVO();
		vo.setId(request.getParameter("id"));
		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content"));
		vo.setBoardkind(2);
		FreeDAO.getInstance().insertBoard(vo);
		
		new ShareListAction().execute(request, response);
	}

}
