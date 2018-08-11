package food.admin.Controller.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import food.admin.dao.boardDAO;
import food.admin.dto.MemberVO;
import food.logindto.loginVO;
import util.DBManager;

public class adminMemberActon implements Action {

	//리스트 보기
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("1");
		HttpSession session = request.getSession();

		loginVO vo = (loginVO) session.getAttribute("loginUser");
		System.out.println("2");
		if(vo.getAdmin()!=2&&vo.getAdmin()!=6){
			request.setAttribute("message", "관리자등급 2만가능합니다.");
			
			request.getRequestDispatcher("/view/adminView/adminmain.jsp").forward(request, response);
		}
		
		
		String url = "/view/adminView/adminMember.jsp";
		System.out.println("url들어갔나여");
	List<MemberVO> list = boardDAO.getInstance().selectAllBoards();
	System.out.println("list넣었나여");
	
	//여기 잘 모르겠음
	//jsp로 가는 페이지의 속성값?
	request.setAttribute("adminMember", list);
	System.out.println("셋어트리뷰트으");
	
	request.getRequestDispatcher(url).forward(request, response);
	System.out.println("디스패쳐");
	
	}
}