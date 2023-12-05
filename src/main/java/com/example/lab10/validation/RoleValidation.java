package com.example.lab10.validation;

import com.example.lab10.entity.Role;

/**
 * todo Document type RoleValdiation
 */
public class RoleValidation {
	public static Role validateFromString(String roleString){
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
