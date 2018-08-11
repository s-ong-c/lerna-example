package food.loginController.action;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import food.logindao.acountdao;

public class mainStartAction implements loginAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cookresult=0;
		Cookie[] cook =  request.getCookies();
		if(cook!=null){
			for(int i = 0 ; i<cook.length ; i++)
				if(cook[i].getName().equals("foodid")){
					String foodid = cook[i].getValue();
					request.setAttribute("id", foodid);
					cookresult=1;
				}
		}
		if(cookresult==0)
			request.setAttribute("id", "");
		System.out.println(cookresult+"cookresultcookresult");
		
		
		
		Calendar Cal = Calendar.getInstance( );

		String today =  String.valueOf(Cal.get(Calendar.YEAR))+String.valueOf((Cal.get(Calendar.MONTH) + 1))+String.valueOf(Cal.get(Calendar.DAY_OF_MONTH));
		System.out.println(today);
		
		int result = acountdao.getInstance().confirmtoday(today);
		System.out.println(result+"today result");
		if(result==-1){
			
			acountdao.getInstance().insertacount(today);
			
		}
		
				
		acountdao.getInstance().updateacount(today);
		acountdao.getInstance().updatetotalacount();
	
		
		int todayCount = acountdao.getInstance().acountview(today);
		int totalacount = acountdao.getInstance().totalview();
		
		
		
		HttpSession session = request.getSession();
		session.setAttribute("todayCount", todayCount);
		session.setAttribute("totalacount", totalacount);
		
		
		System.out.println(todayCount+"todayCount");
		System.out.println(totalacount+"totalacount");
		
		request.getRequestDispatcher("/viewPage/main/main.jsp").forward(request, response);
	}

}
