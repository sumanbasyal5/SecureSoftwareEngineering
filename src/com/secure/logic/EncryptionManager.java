package com.secure.logic;

import java.util.ArrayList;
import java.util.List;

import com.secure.helper.FileLineParser;
import com.secure.model.CustomFile;

public class EncryptionManager {
	
	String compare = "\"DES\"";

	public String CheckForUnsecureAlgorithm(String fileName){
		String errors=null;
		try{
			List<CustomFile> fileList= new ArrayList<CustomFile>();
			fileList=FileLineParser.GetLinesFromFiles(fileName);
			for(int i=0;i<fileList.size();i++){
				CustomFile fileLineObj=fileList.get(i);
				if(fileLineObj.line.contains(compare)){
					errors = "as weak cryptographic algorithm DES is used this " 
							+ "is a security uncompliant code ";
				}
				
				
			}
		}
		catch(Exception ex){
			return null;
		}
		return errors;
	}

}
