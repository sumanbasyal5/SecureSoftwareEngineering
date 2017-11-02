package com.secure.logic;

import java.util.ArrayList;
import java.util.List;

import com.secure.helper.FileLineParser;
import com.secure.model.CustomFile;

public class OrdinalManager {
	
	public String FindOrdinal(String fileName){
		String errors=null;
		try{
			List<CustomFile> fileList= new ArrayList<CustomFile>();
			fileList=FileLineParser.GetLinesFromFiles(fileName);
			for(int i=0;i<fileList.size();i++){
				CustomFile fileLineObj=fileList.get(i);
				
					if(!fileLineObj.line.contains("ordinal")){
						errors="Security Non complaint because it uses its ordinal() method";
					}
			}
		}
		catch(Exception ex){
			return null;
		}
		return errors;
		
		
	}

}
