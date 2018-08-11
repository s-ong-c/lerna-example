package food.admin.Controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food.admin.dao.boardDAO;
import food.admin.dto.MemberVO;

public class adminUpdateMemberWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	
	
	MemberVO vo = new MemberVO();
		vo.setName(request.getParameter("name"));
		vo.setId(request.getParameter("id"));
		vo.setPass(request.getParameter("pass"));
		vo.setNickname(request.getParameter("nickname"));
		
		vo.setEmail(request.getParameter("email"));
		
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("pass"));
		System.out.println(request.getParameter("nickname"));
		System.out.println(request.getParameter("email"));
		

		
		boardDAO.getInstance().memberInsertUpdate(vo);
		
		new adminMemberActon().execute(request,response);
		
	
		
		
		
	}

}
