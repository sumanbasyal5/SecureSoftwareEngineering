package com.secure.logic.finder;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kaushik on 10/23/17.
 */
public abstract class PrivateObjectFinder {
    public static List<String> findPrivateObject(List<String> list){
        int i;
        String token = "", sample = "";
        boolean classFound = false;
        ArrayList<String> privateObjectList = new ArrayList<String>();

        String variablePattern = "(^[a-zA-Z_$][a-zA-Z_$0-9]*)";
        Pattern pattern = Pattern.compile(variablePattern);

        for(i = 0; i < list.size() - 2; i++){
//             We need to have a class with private array object variable
            sample = list.get(i);
            if(sample.equals("class"))
                classFound = true;

//            Check to see if it is a private type array object variable declaration
            if(classFound && sample.contains("[]") && (list.get(i-1).equals("private") || list.get(i-2).equals("private")) && !list.get(i+1).contains("(") && !list.get(i+2).contains("(")){

                token = list.get(i+1);

                Matcher matcher = pattern.matcher(token);
                if(matcher.find()){
//                    We found the array variable
                    privateObjectList.add(matcher.group());
                }
            }
        }
        return privateObjectList;
    }
}
