package com.secure.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.secure.model.CustomFile;

public class FileLineParser {
	public static List<CustomFile> GetLinesFromFiles(String filename){
		List<CustomFile> list= new ArrayList<CustomFile>();
		try {
			File file = new File(filename);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				CustomFile cFile= new CustomFile();
				cFile.line=line;
				list.add(cFile);
			}
			fileReader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
			
		}
		return list;
		
	}
}
