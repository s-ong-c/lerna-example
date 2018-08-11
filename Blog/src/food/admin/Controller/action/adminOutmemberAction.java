package food.admin.Controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import food.admin.dao.boardDAO;
import food.admin.dto.BoardVO;
import food.admin.dto.OutMemberVO;
import food.logindto.loginVO;

public class adminOutmemberAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		loginVO vo = (loginVO) session.getAttribute("loginUser");
		System.out.println("2");
		if(vo.getAdmin()!=5&&vo.getAdmin()!=6){
			request.setAttribute("message", "관리자등급 5만가능합니다.");
			
			request.getRequestDispatcher("/view/adminView/adminmain.jsp").forward(request, response);
		}
		
		
		
		
		String url = "/view/adminView/adminOutMember.jsp";
		
		List<OutMemberVO> list = boardDAO.getInstance().selectAllOutMember();
		
		request.setAttribute("adminOutMember", list);
		
		request.getRequestDispatcher(url).forward(request, response);
	
	
	
	
	}

}
