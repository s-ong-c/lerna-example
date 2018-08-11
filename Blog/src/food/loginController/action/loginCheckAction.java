package food.loginController.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import food.logindao.logindao;
import food.logindto.loginVO;

public class loginCheckAction implements loginAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("loginCheckAction");
		String url = "view/login/loginView.jsp";
		int check=0;
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		System.out.println(request.getParameter("check")+"checkcheckcheckcheck");
		if(request.getParameter("check")!=null){
		check = Integer.parseInt(request.getParameter("check"));
		}
		String message ="폭식길걷자에 등록되지 않은 아이디이거나,<br> 아이디 또는 비밀번호를 잘못 입력하셨습니다.";
		int result= logindao.getInstance().userCheck(id, pass);
		if(result == 1){
			//로그인 성공
			HttpSession session = request.getSession();
			
			loginVO vo =  logindao.getInstance().getlogin(id);
			session.setAttribute("loginUser", vo);
			if(check==1){
				System.out.println("쿠키생성");
				Cookie idCook = new Cookie("foodid", vo.getId());
				idCook.setMaxAge(60*60*24*7);
				response.addCookie(idCook);				
			}else{
				Cookie[] cook =  request.getCookies();
				System.out.println("쿠키제거1");
				if(cook!=null){
					System.out.println("쿠키제거2");
					for(int i = 0 ; i<cook.length ; i++){
						System.out.println(cook[i].getName()+"cook");
						if(cook[i].getName().equals("foodid")){
							cook[i].setMaxAge(0);
							response.addCookie(cook[i]);
							System.out.println("쿠키제거3");
							request.removeAttribute("id");
							
						}
					}
				}
			}
			url="viewPage/main/main.jsp";
			
		}else if(result == 0){
			request.setAttribute("message", message);
			
		}else if(result == -1){
			request.setAttribute("message", message);
			
		}
		System.out.println("url : "+ url);

		request.getRequestDispatcher(url).forward(request, response);
	}
	

}


