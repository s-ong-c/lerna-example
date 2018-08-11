package food.loginController.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food.admin.dao.boardDAO;
import food.admin.dto.BoardVO;

public class mainSerchAction implements loginAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/viewPage/main/serchResult.jsp";
		String option = request.getParameter("option");
		String optionnum = "";
		if (option.equals("0")) {
			optionnum = "title";

		} else {
			optionnum = "content";

		}
		System.out.println("optionnum :" + optionnum);
		String boardsearchtext = request.getParameter("mainsearchtext");
		System.out.println(request.getParameter("mainsearchtext") + "mainsearchtext");
		List<BoardVO> list = boardDAO.getInstance().selectOneBoardBoards(boardsearchtext, optionnum);

		request.setAttribute("adminMain", list);

		request.getRequestDispatcher(url).forward(request, response);
	}

}
