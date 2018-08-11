package food.admin.Controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food.admin.dao.boardDAO;
import food.admin.dto.MemberVO;

public class adminGradeUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("id"));
		vo.setAdmin(Integer.parseInt(request.getParameter("admin")));
		
		System.out.println("들어오니?????????????????????");
		System.out.println(request.getParameter("id"));
		System.out.println(Integer.parseInt(request.getParameter("admin")));;
		

		boardDAO.getInstance().gradeInsertUpdate(vo);
		new adminGradeAction().execute(request,response);
		
	
		
	}

}
