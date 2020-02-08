package com.seoho.tiffany.action.user;

import com.seoho.tiffany.action.Action;

public class UserFactory {

	public static Action route(String cmd) {
		System.out.println("2. 유저팩토리 : " + cmd);
		if (cmd.equals("login")) {
			return new UserLoginAction();
		} else if (cmd.equals("loginProc")) {
			return new UserLoginProcAction();
		} else if (cmd.equals("join")) {
			return new UserJoinAction();
		} else if (cmd.equals("joinProc")) {
			return new UserJoinProcAction();
		} else if (cmd.equals("modify")) {
			return new UserModifyAction();
		} else if (cmd.equals("modifyProc")) {
			return new UserModifyProcAction();
		} else if (cmd.equals("logout")) {
			return new UserLogoutAction();
		}else if (cmd.equals("useridCheck")) {
			return new UseridCheckAction();
		}
		return null;
	}
}
