package factory;

import helper.SecureConstant;
import logic.CompareManager;

/*
 * Author: Suman Basyal
 */
public  class SecureFactory {
	public static Object GetObject(String type)
	{
		if(type==SecureConstant.SECURE_COMPARE_MANAGER)
			return new CompareManager();
		
		return new Object();
	}
}
