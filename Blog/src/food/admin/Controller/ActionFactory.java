package food.admin.Controller;


import food.admin.Controller.action.Action;
import food.admin.Controller.action.adminBoardAction;
import food.admin.Controller.action.adminBoardSearchAction;
import food.admin.Controller.action.adminCompanyAction;
import food.admin.Controller.action.adminCompanyDeleteAction;
import food.admin.Controller.action.adminCompanySearchAction;
import food.admin.Controller.action.adminCompanyUpdateWriteViewAction;
import food.admin.Controller.action.adminCompanyWriteViewAction;
import food.admin.Controller.action.adminDeleteAction;
import food.admin.Controller.action.adminGradeAction;
import food.admin.Controller.action.adminGradeSearchAction;
import food.admin.Controller.action.adminGradeUpdateAction;
import food.admin.Controller.action.adminGradeUpdateWriteAction;
import food.admin.Controller.action.adminMemberActon;
import food.admin.Controller.action.adminOutMemberDeleteAction;
import food.admin.Controller.action.adminOutmemberAction;
import food.admin.Controller.action.adminSearchAction;
import food.admin.Controller.action.adminUpdateMemberWriteAction;
import food.admin.Controller.action.adminUpdateMemberWriteViewAction;
import food.admin.Controller.action.adminboardDeleteAction;

public class ActionFactory {

	private ActionFactory(){}
	
	private static ActionFactory factory = new ActionFactory();

		public static ActionFactory getInstance(){
			return factory;
		}
		
	
	public Action getAction(String command){
		Action action = null;
		
		if(command.equals("member")){
			action = new adminMemberActon();
	
		}
		else if(command.equals("delete")){
			action = new adminDeleteAction();
		
		}else if(command.equals("UpdateMemberView")){
			action = new adminUpdateMemberWriteViewAction();
		
		}else if(command.equals("WriteUpdateMember")){
			action = new adminUpdateMemberWriteAction();
		}
		else if(command.equals("searchresult")){
			action = new adminSearchAction();
		}
		else if(command.equals("deleteBoard")){
			action = new adminboardDeleteAction();
		}
		else if(command.equals("boardsearchtext")){
			action = new adminBoardSearchAction();
		}
		else if(command.equals("board")){
			action = new adminBoardAction();
		}
		else if(command.equals("company")){
			action = new adminCompanyAction();
		}
		else if(command.equals("deleteCompay")){
			action = new adminCompanyDeleteAction();
		}
		else if(command.equals("updateCompanyView")){
			action = new adminCompanyUpdateWriteViewAction();
		}
		else if(command.equals("WriteUpdateCompany")){
			action = new adminCompanyWriteViewAction();
		}
		else if(command.equals("searchresultCompany")){
			action = new adminCompanySearchAction();
		}
		else if(command.equals("outMember")){
			action = new adminOutmemberAction();
		}
		else if(command.equals("deleteOutMember")){
			action = new adminOutMemberDeleteAction();
		}
		else if(command.equals("grade")){
			action = new adminGradeAction();
		}
		
		else if(command.equals("WriteUpdateGradeView")){
			action = new adminGradeUpdateAction();
		}
		else if(command.equals("WriteUpdateGrade")){
			action = new adminGradeUpdateWriteAction();
		}
		else if(command.equals("searchresultGrade")){
			action = new adminGradeSearchAction();
		}

		
		return action;
	}
}
