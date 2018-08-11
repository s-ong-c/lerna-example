package food.loginController.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food.logindao.logindao;
import food.logindto.loginVO;

public class loginIdFindAction implements loginAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("idfind 들어옴");
		loginVO vo = new loginVO();
		vo.setName(request.getParameter("name"));
		vo.setNickname(request.getParameter("nickname"));
		vo.setEmail(request.getParameter("email"));
		
		String id = logindao.getInstance().IDFind(vo);
		
		if(id.equals("")){
			request.setAttribute("message", "입력하신 정보가 없습니다.");
		}else{
			request.setAttribute("id",id);
		}
		
		request.getRequestDispatcher("view/login/find/idFind.jsp").forward(request, response);
		
	}

}
