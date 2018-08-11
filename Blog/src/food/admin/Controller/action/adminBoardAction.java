package food.admin.Controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import food.admin.dao.boardDAO;
import food.admin.dto.BoardVO;
import food.logindto.loginVO;



public class adminBoardAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		loginVO vo = (loginVO) session.getAttribute("loginUser");
		System.out.println("2");
		if(vo.getAdmin()!=4&&vo.getAdmin()!=6){
			request.setAttribute("message", "관리자등급 4만가능합니다.");
			
			request.getRequestDispatcher("/view/adminView/adminmain.jsp").forward(request, response);
		}
		
		
		String url = "/view/adminView/adminBoard.jsp";
		
		List<BoardVO> list = boardDAO.getInstance().selectAll();
		
		request.setAttribute("adminBoard", list);
		
		request.getRequestDispatcher(url).forward(request, response);
		}
		}

	
