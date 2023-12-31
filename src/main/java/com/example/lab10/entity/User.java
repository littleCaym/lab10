package com.example.lab10.entity;

import java.util.Objects;

/**
 * todo Document type User
 */
public class User {
	public static final String ID = "ID";
	public static final String LOGIN = "LOGIN";
	public static final String PASSWORD = "PASSWORD";
	public static final String ROLE = "ROLE";
	private long id;
	private String login;
	private String password;
	private Role role;

	public User() {
	}

	public User(long id, String login, String password, Role role) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.role = role;
	}

	public User(String login, String password, Role role) {
		this.login = login;
		this.password = password;
		this.role = role;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		User user = (User) o;
		return Objects.equals(login, user.login) && Objects.equals(password, user.password)
				&& role == user.role;
	}

	@Override
	public int hashCode() {
		return Objects.hash(login, password, role);
	}

}
