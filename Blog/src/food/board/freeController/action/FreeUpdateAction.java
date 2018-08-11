package food.board.freeController.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food.board.dto.foodVO;
import food.board.freedao.FreeDAO;

//#86] 수정글 db에 쓰기
public class FreeUpdateAction implements freeAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		System.out.println("111515");
		FreeDAO dao = FreeDAO.getInstance();
		foodVO vo = new foodVO();
		vo.setNum(Integer.parseInt(request.getParameter("num")));
		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content"));
		System.out.println("들어옴?");
		System.out.println(vo.getNum());
		FreeDAO.getInstance().updateFree(vo);
		
		
		new FreeListAction().execute(request, response);
		

	}

}
