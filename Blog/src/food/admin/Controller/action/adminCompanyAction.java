package food.admin.Controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import food.admin.dao.boardDAO;
import food.admin.dto.BoardVO;
import food.admin.dto.MemberVO;
import food.logindao.logindao;
import food.logindto.loginVO;

public class adminCompanyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("1");
		HttpSession session = request.getSession();

		loginVO vo = (loginVO) session.getAttribute("loginUser");
		System.out.println("2");
		if(vo.getAdmin()!=3&&vo.getAdmin()!=6){
			request.setAttribute("message", "관리자등급 3만가능합니다.");
			
			request.getRequestDispatcher("/view/adminView/adminmain.jsp").forward(request, response);
		}
		
		
		String url = "/view/adminView/adminCompanyMember.jsp";
		System.out.println("컴파니이이잉url들어갔나여");
	List<MemberVO> list = boardDAO.getInstance().selectCompanyAllBoards();
	System.out.println("콤파니니이이이잉list넣었나여오오오오옹");
	
	//여기 잘 모르겠음
	//jsp로 가는 페이지의 속성값?
	request.setAttribute("adminCompanyMember",list);
	System.out.println("콤파니니이이잉셋어트리뷰트으으오오아앙옹");
	
	request.getRequestDispatcher(url).forward(request, response);
	System.out.println("컴파니이이이잉디스패쳐어어어어어어어");
	}

}
