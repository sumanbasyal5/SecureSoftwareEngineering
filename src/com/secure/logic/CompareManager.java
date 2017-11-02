package com.secure.logic;
import java.util.List;

import com.secure.helper.SecureConstant;

public class CompareManager {
	/*
	 * Author: Suman Basyal
	 * 
	 */
	public boolean IsComparePresent(List<String> list)
	{
		boolean found=false;
		for(int i=0;i<list.size();i++){
			String val=list.get(i);	
			boolean result=val.contains(SecureConstant.SECURE_EQUAL);
			if(result)
			{
				found=true;
				break;
			}
		}
		return found;
	}
}
