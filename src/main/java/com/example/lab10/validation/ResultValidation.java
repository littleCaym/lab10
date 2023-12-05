package com.example.lab10.validation;

import com.example.lab10.entity.User;

/**
 * todo Document type ResultValidation
 */
public class ResultValidation {
		private User user;
		private int responseCode;

		public ResultValidation(User user, int responseCode) {
			this.user = user;
			this.responseCode = responseCode;
		}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

}
