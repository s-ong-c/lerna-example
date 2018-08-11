package food.board.freeController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food.board.freeController.action.FreeCheckPassAction;
import food.board.freeController.action.FreeCheckPassFormAction;
import food.board.freeController.action.FreeDeleteAction;
import food.board.freeController.action.FreeListAction;
import food.board.freeController.action.FreeUpdateAction;
import food.board.freeController.action.FreeUpdateFormAction;
import food.board.freeController.action.FreeViewAction;
import food.board.freeController.action.FreeWriteAction;
import food.board.freeController.action.FreeWriteFormAction;
import food.board.freeController.action.freeAction;



public class ActionFactory {
	private ActionFactory(){}
	
	private static ActionFactory factory = new ActionFactory();
	
	public static ActionFactory getInstance(){
		return factory;
	
	}
	public freeAction getAction(String freeCommand){
		
		System.out.println("ActionFactory : "+freeCommand);
		
		freeAction freeAction=null;
		if(freeCommand.equals("free_list")){
			//#5] 목록보기
			freeAction = new FreeListAction();
		}else if(freeCommand.equals("free_write_form")){

			//#18] 글쓰기.jsp로 가자
			freeAction = new FreeWriteFormAction();

		}else if(freeCommand.equals("free_write")){
			//#29] 글쓰기 db 하러 가자
			freeAction = new FreeWriteAction();

		}else if(freeCommand.equals("free_view")){
			//#41] 글 한건 보기 
			freeAction = new FreeViewAction();

		}else if(freeCommand.equals("free_check_pass_form")){
			//#55] 글 수정 - 비번넣는 디자인 호출 -  클래스 
			freeAction = new FreeCheckPassFormAction();

		}else if(freeCommand.equals("free_check_pass")){
			//#64] 글 수정 - 비번체크==>execute로 바로 가자! 
			freeAction = new FreeCheckPassAction();

		}else if(freeCommand.equals("free_update_form")){
			//#74] 글 수정 - 원글 보기==>execute로 바로 가자! 
			freeAction = new FreeUpdateFormAction();

		}else if(freeCommand.equals("free_update")){
			//#85] 글 수정 db에 update하러 가기==>execute로 바로 가자! 
			freeAction = new FreeUpdateAction();
		}
		else if(freeCommand.equals("free_delete")){
			//#85] 글 수정 db에 update하러 가기==>execute로 바로 가자! 
			freeAction = new FreeDeleteAction();
			
		}
		//BoardServlet 으로 가자
		return freeAction;
	}
	

}