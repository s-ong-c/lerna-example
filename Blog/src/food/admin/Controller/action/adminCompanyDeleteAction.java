package food.admin.Controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food.admin.dao.boardDAO;

public class adminCompanyDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String[] a = request.getParameterValues("chek");
		
		for(int i =0 ; i<a.length;i++){
			String str = String.valueOf(a[i]);
			
			System.out.println(a[i]+request.getParameter(str)+"testtest");
			
			boardDAO.getInstance().selectDelete(request.getParameter(str));
		}
		
		
		
		
		new adminCompanyAction().execute(request, response);

	}

}
