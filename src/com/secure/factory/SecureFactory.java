package com.secure.factory;

import com.secure.helper.SecureConstant;
import com.secure.logic.AccessManager;
import com.secure.logic.CompareManager;
import com.secure.logic.MutateManager;

/*
 * Author: Suman Basyal
 */
public  class SecureFactory {
	public static Object GetObject(String type)
	{
		if(type == SecureConstant.SECURE_COMPARE_MANAGER) {
			return new CompareManager();
		}else if(type == SecureConstant.SECURE_ACCESS_MANAGER){
			return new AccessManager();
		}else if(type == SecureConstant.SECURE_MUTATE_MANAGER){
			return new MutateManager();
		}
		return new Object();
	}
}
