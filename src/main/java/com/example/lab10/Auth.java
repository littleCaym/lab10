package com.example.lab10;

import java.util.List;

/**
 * todo Document type Auth
 */
public class Auth {
	private User currentUser;

	public Auth(){
	}

	public static ResultValidation userValidation(User user){
		List<User> users = UserList.getUserArrayList();
		for (int i = 0; i < users.size(); i++) {
			if(users.get(i).getLogin().equals(user.getLogin())){
				if(users.get(i).getPassword().equals(user.getPassword())){
					return new ResultValidation(users.get(i), 1);
				}
			}
		}
		return new ResultValidation(UserList.userEmpty, -1);
	}

}
