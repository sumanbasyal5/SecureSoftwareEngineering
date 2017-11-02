package com.secure.logic;

import java.util.ArrayList;
import java.util.List;

import com.secure.helper.FileLineParser;
import com.secure.model.CustomFile;


/*
 Author: Suman Basyal
 */
public class ScopeManager {
	
	public String CheckForScopeOfI(String fileName){
		String errors=null;
		try{
			List<CustomFile> fileList= new ArrayList<CustomFile>();
			fileList=FileLineParser.GetLinesFromFiles(fileName);
			for(int i=0;i<fileList.size();i++){
				CustomFile fileLineObj=fileList.get(i);
				if(fileLineObj.line.contains("for")){
					if(!fileLineObj.line.contains("int")){
						errors="int not decleared inside the for loop";
					}
				}
				
				
			}
		}
		catch(Exception ex){
			return null;
		}
		return errors;
	}
}
