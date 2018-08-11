package food.loginController.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import food.logindao.OutStaticsdao;
import food.logindao.logindao;
import food.logindto.OutStaticsVo;
import food.logindto.loginVO;

public class loginDeleteSeasonAction implements loginAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		OutStaticsVo vo = new OutStaticsVo();

		System.out.println("season 정상작동");

		
		
		//statics 테이블에 insert
		if(!(request.getParameter("outReason")).equals("")){
			vo.setOutNum(Integer.parseInt(request.getParameter("outReason")));
		}
		if(!(request.getParameter("texttext")).equals("")){
			vo.setContent(request.getParameter("texttext"));
		}
		vo.setAdmin(Integer.parseInt(request.getParameter("admin")));
		OutStaticsdao.getInstance().insertOutStatics(vo);
		
		
		//iddata의 delete
		String id= request.getParameter("id");
		logindao.getInstance().deleteMember(id);
		
		
		HttpSession session = request.getSession();
		session.removeAttribute("loginUser");
		
		request.getRequestDispatcher("viewPage/main/main.jsp").forward(request, response);
		
	}

}
