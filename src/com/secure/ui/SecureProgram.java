package com.secure.ui;

import java.util.List;

import com.secure.helper.FileParser;
import com.secure.logic.AccessManager;
import com.secure.logic.CompareManager;
import com.secure.factory.SecureFactory;
import com.secure.helper.SecureConstant;
import com.secure.logic.MutateManager;

public class SecureProgram {
	
	public static CompareManager _compareManager;
	public static AccessManager _accesManager;
	public static MutateManager _mutateManager;
	private static List<String> finalList;
	private static boolean[] result = new boolean[10];
	public static void main(String[] args) {

		System.out.println("Secure Software Engineering");

//		Create instance for managers
//		_compareManager = (CompareManager)SecureFactory.GetObject(SecureConstant.SECURE_COMPARE_MANAGER);
		_accesManager = (AccessManager)SecureFactory.GetObject(SecureConstant.SECURE_ACCESS_MANAGER);
		_mutateManager = (MutateManager)SecureFactory.GetObject(SecureConstant.SECURE_MUTATE_MANAGER);


//		Parse the input file
		finalList = getListOfParsedString();

//		result[0] = _compareManager.IsComparePresent(finalList);
		result[1] = _accesManager.isAccessible(finalList);
		result[2] = _mutateManager.isMutable(finalList);

//	    if(result==true)
//	    	System.out.println("The code is not security complaint");
//	    else
//	    	System.out.println("The code is security complaint");
	}

	public static List<String> getListOfParsedString(){
		List<String> list= FileParser.GetStringsFromFiles("/Users/kaushik/sseTest.txt");
		return list;
	}

}
