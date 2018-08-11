package food.admin.Controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food.admin.dao.boardDAO;
import food.admin.dto.MemberVO;

public class adminUpdateMemberWriteViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		boardDAO dao = boardDAO.getInstance();
		System.out.println("aaaaaaaaaaaaaaaaaaaaa" +id);
		MemberVO vo = dao.SelectOneMember(id);
		System.out.println("bbbbbbbbbbbbbbbbb");
		
		request.setAttribute("adminMember", vo);
		System.out.println("ccccccccccccccccccccccc");
		request.getRequestDispatcher("view/adminView/adminUpdateMember.jsp").forward(request,response);
	}

}
