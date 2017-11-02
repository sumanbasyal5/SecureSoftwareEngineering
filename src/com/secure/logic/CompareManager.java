package com.secure.logic;
import java.util.List;


import com.secure.helper.FileParser;
import com.secure.helper.SecureConstant;

public class CompareManager {
	/*
	 * Author: Suman Basyal
	 * 
	 */
	public String IsComparePresent(String filename)
	{
		String mainResult="";
		List<String> list= FileParser.GetStringsFromFiles(filename);
		boolean found=false;
		for(int i=0;i<list.size();i++){
			String val=list.get(i);	
			boolean result=val.contains(SecureConstant.SECURE_EQUAL);
			if(result)
			{
				mainResult="Equals function being used with key";
				break;
			}
		}
		return mainResult;
	}
}
