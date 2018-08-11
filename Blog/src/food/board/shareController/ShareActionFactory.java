package food.board.shareController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food.board.freeController.action.FreeCheckPassAction;
import food.board.shareController.action.ShareCheckPassAction;
import food.board.shareController.action.ShareCheckPassFormAction;
import food.board.shareController.action.ShareDeleteAction;
import food.board.shareController.action.ShareListAction;
import food.board.shareController.action.ShareUpdateAction;
import food.board.shareController.action.ShareUpdateFormAction;
import food.board.shareController.action.ShareViewAction;
import food.board.shareController.action.ShareWriteAction;
import food.board.shareController.action.ShareWriteFormAction;
import food.board.shareController.action.shareAction;

public class ShareActionFactory {

	private ShareActionFactory() {
	}

	private static ShareActionFactory factory = new ShareActionFactory();

	public static ShareActionFactory getInstance() {
		return factory;
	}

	public shareAction getShareAction(String shareCommand) {

		shareAction shareAction = null;
		//인덱스에서 시작 -- 리스트 보기
		if(shareCommand.equals("share_list")){
			//#5] 목록보기
			shareAction = new ShareListAction();
		}else if(shareCommand.equals("share_write_form")){

			//#18] 글쓰기.jsp로 가자
			shareAction = new ShareWriteFormAction();

		}else if(shareCommand.equals("share_write")){
			//#29] 글쓰기 db 하러 가자
			shareAction = new ShareWriteAction();

		}else if(shareCommand.equals("share_view")){
			//#41] 글 한건 보기 
			shareAction = new ShareViewAction();

		}else if(shareCommand.equals("share_check_pass_form")){
			//#55] 글 수정 - 비번넣는 디자인 호출 -  클래스 
			shareAction = new ShareCheckPassFormAction();

		}else if(shareCommand.equals("share_check_pass")){
			//#64] 글 수정 - 비번체크==>execute로 바로 가자! 
			shareAction = new ShareCheckPassAction();

		}else if(shareCommand.equals("share_update_form")){
			//#74] 글 수정 - 원글 보기==>execute로 바로 가자! 
			shareAction = new ShareUpdateFormAction();

		}else if(shareCommand.equals("share_update")){
			//#85] 글 수정 db에 update하러 가기==>execute로 바로 가자! 
			shareAction = new ShareUpdateAction();
		}
		else if(shareCommand.equals("share_delete")){
			//#85] 글 수정 db에 update하러 가기==>execute로 바로 가자! 
			shareAction = new ShareDeleteAction();
			
		}
	
		return shareAction;
	}
	
}
