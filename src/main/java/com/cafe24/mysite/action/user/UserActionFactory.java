package com.cafe24.mysite.action.user;

import com.cafe24.mysite.action.main.MainAction;
import com.cafe24.web.mvc.Action;
import com.cafe24.web.mvc.ActionFactory;

public class UserActionFactory extends ActionFactory{
	String s="JoinAction";
	// String으로 class 만들기 해보기
	@Override
	public Action getAction(String actionName) {
		Action action =null;
		if("joinForm".equals(actionName)) {
			action=new JoinFormAction();
		}else if("join".equals(actionName)) {
			action=new JoinAction();
		}else if("joinsuccess".equals(actionName)) {
			action=new JoinSuccessAction();
		}else if("loginForm".equals(actionName)) {
			action=new LoginFormAction();
		}else if("login".equals(actionName)) {
			action=new LoginAction();
		}else if("logout".equals(actionName)) {
			action=new LogoutAction();
		}else if("updateForm".equals(actionName)) {
			action=new UpdateFormAction();
		}else {
			action=new MainAction();
		}
		return action;
	}

}
