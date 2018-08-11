package food.admin.Controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food.admin.dao.boardDAO;
import food.admin.dto.MemberVO;

public class adminCompanyWriteViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MemberVO vo = new MemberVO();
		vo.setName(request.getParameter("name"));
		vo.setId(request.getParameter("id"));
		vo.setPass(request.getParameter("pass"));
		vo.setNickname(request.getParameter("nickname"));
		vo.setEmail(request.getParameter("email"));
		vo.setAddress(request.getParameter("address"));
		vo.setCompanyName(request.getParameter("companyName"));
		vo.setCompanyPhone(request.getParameter("companyPhone"));
		
		boardDAO.getInstance().companyInsertUpdate(vo);
		
		new adminCompanyAction().execute(request, response);
		
	}

}
