package food.board.freeController.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import food.board.dto.foodVO;
import food.board.freedao.FreeDAO;

public class FreeCheckPassAction implements freeAction {
	//#65] 수정- 비번 체크   num, pass
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "";
		String num = request.getParameter("num");
		String pass = request.getParameter("pass");
		
		foodVO vo = FreeDAO.getInstance().checkPassword(num, pass);
		
		if(vo!=null){
			url="viewPage/freeView/checkSuccess.jsp";
		}else{
			url="viewPage/freeView/freeCheckPass.jsp";
			request.setAttribute("message", "비밀번호가 틀렸습니다");
			
		}
		request.getRequestDispatcher(url).forward(request, response);
		
		
		
		
		
		
		

	}

}
