package food.loginController.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import food.logindao.logindao;
import food.logindto.loginVO;

public class loginPassFindAction implements loginAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("passfind 들어옴");
		
		String name = request.getParameter("name");
		String id  = request.getParameter("id");
		int result = logindao.getInstance().PassFind(name, id);
		System.out.println(result+"resultresultresult");
		if(result==0){
			request.setAttribute("message", "입력하신 정보가 없습니다.");
		}else{
			loginVO vo = logindao.getInstance().getlogin(id);
			request.setAttribute("id", vo.getId());
		}
		
		request.getRequestDispatcher("view/login/find/passFind.jsp").forward(request, response);
		
	}

}
