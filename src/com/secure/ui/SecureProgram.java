package com.secure.ui;

import java.util.ArrayList;
import java.util.List;

import com.secure.helper.FileParser;
import com.secure.logic.AccessManager;
import com.secure.logic.CompareManager;
import com.secure.factory.SecureFactory;
import com.secure.helper.SecureConstant;
import com.secure.logic.MutateManager;
import com.secure.logic.OrdinalManager;
import com.secure.logic.ScopeManager;
import com.secure.logic.EncryptionManager;

public class SecureProgram {

	public static CompareManager _compareManager;
	public static AccessManager _accesManager;
	public static MutateManager _mutateManager;
	public static ScopeManager _scopeManager;
	public static OrdinalManager _ordinalManager;
	public static EncryptionManager _encryptionManager;
	private static List<String> finalList;
	private static boolean[] result = new boolean[10];

	public static void main(String[] args) {

		System.out.println("Secure Software Engineering");

//		Create instance for managers
//		_compareManager = (CompareManager)SecureFactory.GetObject(SecureConstant.SECURE_COMPARE_MANAGER);
		_accesManager = (AccessManager) SecureFactory.GetObject(SecureConstant.SECURE_ACCESS_MANAGER);
		_mutateManager = (MutateManager) SecureFactory.GetObject(SecureConstant.SECURE_MUTATE_MANAGER);

		List<String> listResult = new ArrayList<String>();
		/*
		//checking for compare manager
		_compareManager=(CompareManager)SecureFactory.GetObject(SecureConstant.SECURE_COMPARE_MANAGER);
	    listResult.add(_compareManager.IsComparePresent("inputFiles/code.txt"));

	    //checking for scope manager
	    _scopeManager=(ScopeManager)SecureFactory.GetObject(SecureConstant.SECURE_SCOPE_MANAGER);
	    listResult.add(_scopeManager.CheckForScopeOfI("inputFiles/scope.txt"));

	    //checking for ordinal manager
	    _ordinalManager=(OrdinalManager)SecureFactory.GetObject(SecureConstant.SECURE_ORDINAL_MANAGER);
	    listResult.add(_ordinalManager.FindOrdinal("inputFiles/ordinal.txt"));

		//checking for ordinal manager
		_encryptionManager = (EncryptionManager) SecureFactory.GetObject(SecureConstant.SECURE_ENCRYPTION_MANAGER);
		listResult.add(_encryptionManager.CheckForUnsecureAlgorithm("inputFiles/unsecure.txt"));
		*/

		//checking for access manager
		_accesManager=(AccessManager) SecureFactory.GetObject(SecureConstant.SECURE_ACCESS_MANAGER);
		listResult.add(_accesManager.isAccessible("inputFiles/sseTest.txt"));

		//checking for mutate manager
		_mutateManager=(MutateManager) SecureFactory.GetObject(SecureConstant.SECURE_MUTATE_MANAGER);
		listResult.add(_mutateManager.isMutable("inputFiles/sseTest.txt"));

		ShowResult(listResult);


	}

	public static void ShowResult(List<String> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}


