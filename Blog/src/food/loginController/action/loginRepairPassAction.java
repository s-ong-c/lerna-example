package food.loginController.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food.logindao.logindao;

public class loginRepairPassAction implements loginAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id= request.getParameter("id");
		String pass = request.getParameter("pass1");
		System.out.println(request.getParameter("id")+"id");
		System.out.println(request.getParameter("pass1")+"pass1");
		logindao.getInstance().updatePass(id, pass);
	}

}
