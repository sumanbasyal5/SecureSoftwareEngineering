package com.secure.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * Author: Suman Basyal
 */
public class FileParser {
	public static List<String> GetStringsFromFiles(String filename){
		List<String> list= new ArrayList<String>();
		try {
			File file = new File(filename);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				//stringBuffer.append(line);
				//stringBuffer.append("\n");
				String [] array=line.split(" ");					//What if we have variable=value without space?
				for(int i=0;i<array.length;i++){
					list.add(array[i]);
				}
			}
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
			
		}
		return list;
		
	}
}
