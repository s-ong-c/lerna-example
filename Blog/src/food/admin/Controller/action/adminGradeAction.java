package food.admin.Controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import food.admin.dao.boardDAO;
import food.admin.dto.MemberVO;
import food.logindto.loginVO;

public class adminGradeAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		loginVO vo = (loginVO) session.getAttribute("loginUser");
		System.out.println("2");
		if(vo.getAdmin()!=6){
			request.setAttribute("message", "최상위 관리자만가능합니다.");
			
			request.getRequestDispatcher("/view/adminView/adminmain.jsp").forward(request, response);
		}
		
		
		String url = "/view/adminView/adminGrade.jsp";
		System.out.println("urlurlurlurlurlurl");
		
		List<MemberVO> list = boardDAO.getInstance().selectGradeBoard();
		request.setAttribute("adminMember",list);
		System.out.println("adminMemberadminMemberadminMemberadminMember");
	
		request.getRequestDispatcher(url).forward(request, response);
	
	
	}

}
