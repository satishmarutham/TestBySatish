package com.centris.campus.delegate;

import com.centris.campus.serviceImpl.LoginServiceImpl;
import com.centris.campus.vo.LoginVo;
import com.centris.campus.vo.UserDetailVO;

public class LoginBD {

	public LoginVo validateUserBD(String UserName, String Password) {

		return new LoginServiceImpl().validateUserServiceImpl(UserName,
				Password);
	}

	public UserDetailVO loadUserBD(LoginVo loginvo) {

		return new LoginServiceImpl().loadUserServiceImpl(loginvo);
	}


	public int checkCurrentPassword(String user, String currentPassword,
			String currentuserId) {

		return new LoginServiceImpl().checkCurrentPassword(user,
				currentPassword, currentuserId);
	}

	public int changePassword(String user, String newPassword,
			String currentuserId) {

		return new LoginServiceImpl().changePassword(user, newPassword,
				currentuserId);
	}

	

}
