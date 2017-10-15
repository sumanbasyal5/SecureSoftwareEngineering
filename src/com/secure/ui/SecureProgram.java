package com.secure.ui;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.secure.factory.SecureFactory;
import com.secure.helper.SecureConstant;
import com.secure.logic.CompareManager;
import com.secure.logic.ScopeManager;;
public class SecureProgram {
	
	public static CompareManager _compareManager;
	public static ScopeManager _scopeManager;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("secure software engineering");
		List<String> listResult= new ArrayList<String>();
		//checking for compare manager
		_compareManager=(CompareManager)SecureFactory.GetObject(SecureConstant.SECURE_COMPARE_MANAGER);
	    listResult.add(_compareManager.IsComparePresent("inputFiles/code.txt"));
	    
	    //checking for scope manager
	    _scopeManager=(ScopeManager)SecureFactory.GetObject(SecureConstant.SECURE_SCOPE_MANAGER);
	   
	    listResult.add(_scopeManager.CheckForScopeOfI("inputFiles/scope.txt"));
	    
	    
	    
	    
	    
	    ShowResult(listResult);
	}
	
	
	public static void ShowResult(List<String> list){
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}

}
