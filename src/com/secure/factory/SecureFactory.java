package com.secure.factory;

import com.secure.helper.SecureConstant;
import com.secure.logic.CompareManager;
import com.secure.logic.ScopeManager;

/*
 * Author: Suman Basyal
 */
public  class SecureFactory {
	public static Object GetObject(String type)
	{
		if(type==SecureConstant.SECURE_COMPARE_MANAGER)
			return new CompareManager();
		if(type==SecureConstant.SECURE_SCOPE_MANAGER)
			return new ScopeManager();
		
		return new Object();
	}
}
