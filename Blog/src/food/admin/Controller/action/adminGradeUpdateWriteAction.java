package food.admin.Controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food.admin.dao.boardDAO;
import food.admin.dto.MemberVO;

public class adminGradeUpdateWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		boardDAO dao = boardDAO.getInstance();

		MemberVO vo = dao.SelectOneMember(id);
		
		request.setAttribute("adminMember", vo);
		request.getRequestDispatcher("view/adminView/adminGradeUpdate.jsp").forward(request,response);
	}

}
