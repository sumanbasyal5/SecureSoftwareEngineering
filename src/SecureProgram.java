import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import logic.CompareManager;
import factory.SecureFactory;
import helper.SecureConstant;;
public class SecureProgram {
	
	public static CompareManager _compareManager;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("secure software engineering");
		_compareManager=(CompareManager)SecureFactory.GetObject(SecureConstant.SECURE_COMPARE_MANAGER);
	    boolean result=_compareManager.IsComparePresent("C:/Users/basya/Desktop/test/code.txt");
	    if(result==true)
	    	System.out.println("The code is not security complaint");
	    else
	    	System.out.println("The code is security complaint");
	}

}
