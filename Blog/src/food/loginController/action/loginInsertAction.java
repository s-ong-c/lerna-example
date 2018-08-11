package food.loginController.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import food.logindao.logindao;
import food.logindto.loginVO;

public class loginInsertAction implements loginAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");;
		loginVO vo = new loginVO();
		System.out.println(request.getParameter("adminNum"));
		vo.setId(request.getParameter("id"));
		vo.setPass(request.getParameter("pass1"));
		vo.setName(request.getParameter("name"));
		vo.setNickname(request.getParameter("nickname"));
		vo.setAdmin(Integer.parseInt(request.getParameter("adminNum"))); 
		vo.setEmail(request.getParameter("email"));
		vo.setAddress(request.getParameter("address"));
		
		if(vo.getAdmin()==1){
			vo.setCompanyName(request.getParameter("companyName"));
			vo.setCompanyPhone(request.getParameter("companyPhone"));
		}

		logindao dao = logindao.getInstance();

		int result = dao.insertMember(vo);
		
		
		if(result == 1){
			request.setAttribute("message", "회원가입에 성공했습니다");
		}else{
			request.setAttribute("message", "회원가입에 실패했습니다.");
		}
		

		request.getRequestDispatcher("view/login/loginView.jsp").forward(request, response);
		
		
		
	}

}
