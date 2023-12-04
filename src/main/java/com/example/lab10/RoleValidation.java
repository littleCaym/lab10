package com.example.lab10;

/**
 * todo Document type RoleValdiation
 */
public class RoleValidation {
	public static Role validateRoleFromString(String roleString){
		if(Role.ADMINISTRATOR.toString().equals(roleString)){
			return Role.ADMINISTRATOR;
		}
		else if(Role.ACCOUNTANT.toString().equals(roleString)){
			return Role.ACCOUNTANT;
		}
		else if(Role.PERSONNEL_MANAGER.toString().equals(roleString)){
			return Role.PERSONNEL_MANAGER;
		}
		else if(Role.WAREHOUSE_MANAGER.toString().equals(roleString)){
			return Role.WAREHOUSE_MANAGER;
		}
		else if(Role.CASHIER.toString().equals(roleString)){
			return Role.CASHIER;
		}
		else{
			return Role.NO_ROLE;
		}
	}
}
