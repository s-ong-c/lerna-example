package food.loginController.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import food.board.freeController.action.FreeViewAction;
import food.board.shareController.action.ShareViewAction;

public class mainReserch implements loginAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("들어왔나?33");
		int num = Integer.parseInt(request.getParameter("num"));
		int kind = Integer.parseInt(request.getParameter("kind"));
		request.setAttribute("num",num);
		if(kind==1){
			new FreeViewAction().execute(request, response);;
		}
		if(kind==2){
			new ShareViewAction().execute(request, response);;
		}
		if(kind==3){
			new ShareViewAction().execute(request, response);;
		}
	}

}
