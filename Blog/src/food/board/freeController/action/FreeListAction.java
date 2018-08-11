package food.board.freeController.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import food.board.dto.foodVO;
import food.board.freedao.FreeDAO;

public class FreeListAction implements freeAction {
	
	//#7] 목록 보기 ㅣ
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="viewPage/freeView/freeList.jsp";
	
		
		List<foodVO> list = FreeDAO.getInstance().selectAllBoards(1);
		//#11] dao에서 list에 글을 담아서 왔다. 
		request.setAttribute("freeList", list);
		
		System.out.println("123");
		//#12] boardList.jsp 로 이동하자 
		request.getRequestDispatcher(url).forward(request,response);
		 
	}

}
