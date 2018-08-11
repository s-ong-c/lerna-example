package food.admin.Controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food.admin.dao.boardDAO;
import food.admin.dto.MemberVO;

public class adminCompanySearchAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "/view/adminView/adminCompanyMember.jsp";

		String searchtext = request.getParameter("searchtext");
		System.out.println(request.getParameter("searchtext")+"searchtext");
		List<MemberVO>  list = boardDAO.getInstance().selectOneCompanys(searchtext);

			request.setAttribute("adminCompanyMember", list);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
