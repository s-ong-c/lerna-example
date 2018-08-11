package food.loginController.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food.logindao.logindao;

public class loginIdOverCheckAction implements loginAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		System.out.println(id+"rrrrrrrrrrr");
		//confirm작업
		logindao dao=logindao.getInstance();

		int result = dao.confirmID(id);

		
		request.setAttribute("result", result);
		request.setAttribute("id", id);

		request.getRequestDispatcher("view/login/loginIdCheck.jsp").forward(request, response);
		
	}

}
