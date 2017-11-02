package com.secure.factory;

import com.secure.helper.SecureConstant;
import com.secure.logic.CompareManager;
import com.secure.logic.EncryptionManager;
import com.secure.logic.OrdinalManager;
import com.secure.logic.ScopeManager;
import com.secure.logic.AccessManager;
import com.secure.logic.MutateManager;

/*
 * Author: Suman Basyal
 */
public  class SecureFactory {
	public static Object GetObject(String type)
	{

		if(type == SecureConstant.SECURE_COMPARE_MANAGER) {
			return new CompareManager();
		}if(type == SecureConstant.SECURE_ACCESS_MANAGER){
			return new AccessManager();
		}if(type == SecureConstant.SECURE_MUTATE_MANAGER){
			return new MutateManager();
		}if(type==SecureConstant.SECURE_COMPARE_MANAGER)
			return new CompareManager();
		if(type==SecureConstant.SECURE_SCOPE_MANAGER)
			return new ScopeManager();
		if(type==SecureConstant.SECURE_ORDINAL_MANAGER)
			return new OrdinalManager();
		if(type==SecureConstant.SECURE_ENCRYPTION_MANAGER)
			return new EncryptionManager();

		return new Object();
	}
}
