package food.admin.Controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food.admin.dto.MemberVO;
import food.admin.dao.boardDAO;

public class adminSearchAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/view/adminView/adminMember.jsp";

	String searchtext = request.getParameter("searchtext");
	System.out.println(request.getParameter("searchtext")+"searchtext");
	List<MemberVO>  list = boardDAO.getInstance().selectOneBoards(searchtext);

		request.setAttribute("adminMember", list);
	
	request.getRequestDispatcher(url).forward(request, response);
	}
	
	
	
	}

