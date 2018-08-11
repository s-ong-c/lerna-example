package food.loginController;

import food.loginController.action.loginIdOverCheckAction;
import food.loginController.action.loginInsertAction;
import food.loginController.action.loginLogoutAction;
import food.loginController.action.loginPassFindAction;
import food.loginController.action.loginRepairAction;
import food.loginController.action.loginRepairPassAction;
import food.loginController.action.mainReserch;
import food.loginController.action.mainSerchAction;
import food.loginController.action.mainStartAction;
import food.loginController.action.loginAction;
import food.loginController.action.loginCheckAction;
import food.loginController.action.loginDeleteSeasonAction;
import food.loginController.action.loginIdFindAction;

public class loginActionFactory {
	private loginActionFactory(){}
	
	private static loginActionFactory factory = new loginActionFactory();
	
	public static loginActionFactory getInstance(){
		return factory;
	}
	
	public loginAction getAction(String command){
		
		System.out.println("loginActionFactory : "+command);
		
		loginAction action=null;
		
		if(command.equals("loginCheck")){
			//#5] 목록보기
			action = new loginCheckAction();
		}else if(command.equals("loginIdOverCheck")){
			action = new loginIdOverCheckAction();
		
		}else if(command.equals("mainStart")){
			
			action = new mainStartAction();
		
		}else if(command.equals("loginInsert")){
		
			action = new loginInsertAction();
		}
		else if(command.equals("repairCheck")){
		
		action = new loginRepairAction();
		}
		else if(command.equals("loginLogout")){
			
			action = new loginLogoutAction();
		}
		else if(command.equals("loginDeleteReason")){
			
			action = new loginDeleteSeasonAction();
		}
		else if(command.equals("loginIdFind")){
			
			action = new loginIdFindAction();
		}
		else if(command.equals("loginPassFind")){
			
			action = new loginPassFindAction();
		}
		else if(command.equals("loginRepairPass")){
			
			action = new loginRepairPassAction();
		}
		else if(command.equals("mainsearchtext")){
			
			action = new mainSerchAction();
		}
		else if(command.equals("mainReserch")){
			action = new mainReserch();
		}

	return action;
	}
	
	
	
	
}
