package food.loginController.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import food.logindao.logindao;
import food.logindto.loginVO;

public class loginRepairAction implements loginAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		loginVO vo = new loginVO();
		
		vo.setId(request.getParameter("id"));
		vo.setPass(request.getParameter("pass1"));
		vo.setEmail(request.getParameter("email"));
		vo.setNickname(request.getParameter("nickname"));
		vo.setAdmin(Integer.parseInt(request.getParameter("adminNum"))); //dao도 수정
		vo.setAddress(request.getParameter("address"));
		
		if(vo.getAdmin()==1){
			vo.setCompanyName(request.getParameter("companyName"));
			vo.setCompanyPhone(request.getParameter("companyPhone"));
		}else{
			vo.setCompanyName("");
			vo.setCompanyPhone("");
		}

		
		
		logindao.getInstance().updateMember(vo);
		HttpSession session = request.getSession();
		session.removeAttribute("loginUser");
		request.setAttribute("message", "수정되었습니다. 다시 한번 로그인해주세요.");
		request.getRequestDispatcher("view/login/loginView.jsp").forward(request, response);
	}

}
