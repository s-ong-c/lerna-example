package food.admin.Controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food.admin.dao.boardDAO;
import food.admin.dto.MemberVO;

public class adminCompanyUpdateWriteViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		boardDAO dao = boardDAO.getInstance();
		System.out.println("aaaaaaaaaaaaaaaaaaaaa" +id);

		MemberVO vo = dao.SelectOneCompany(id);
		System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbb" +id);
		
		request.setAttribute("adminCompanyMember", vo);
		request.getRequestDispatcher("view/adminView/adminCompanyUpdate.jsp").forward(request,response );
	}

}
