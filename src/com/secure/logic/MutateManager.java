package com.secure.logic;

import com.secure.logic.finder.PrivateObjectFinder;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kaushik on 10/23/17.
 */
public class MutateManager {
    public boolean isMutable(List<String> list){
        //        Get private object lists
        ArrayList<String> privateObjectList = (ArrayList<String>) PrivateObjectFinder.findPrivateObject(list);

//        Now we need to find list of objects as argument in a method
//        Variable Declarations
        ArrayList<String> foundList = new ArrayList<String>();
        ArrayList<String> objectArgumentList = new ArrayList<String>();
        ArrayList<String> mutatedObjectList = new ArrayList<String>();
        String sample = "", token = "";
        boolean classFound = false;
        int i = 0, j = 0;

        String variablePattern = "(^[a-zA-Z_$][a-zA-Z_$0-9]*)";
        Pattern pattern = Pattern.compile(variablePattern);

//        Check if object type is present as argument in a method
        for(i = 0; i < list.size() - 2; i++){
//            First Lets see if we have a class with private array object variable
            sample = list.get(i);
            if(sample.equals("class"))
                classFound = true;

            if(classFound && sample.contains("[]")){
//                We found array initializer
                token = list.get(i+1);
//                Make sure that this array object is not a method name or a variable declaration
                if(!token.contains("(") && !list.get(i+2).contains("(") && !list.get(i-1).contains("private") && !list.get(i-1).contains("public") && !list.get(i-1).contains("protected")) {
                    Matcher matcher = pattern.matcher(token);
                    if (matcher.find()) {
//                        We found the argument array variables now check for assignments
                        objectArgumentList.add(matcher.group());
                    }
                }
            }
        }


//        Now we have two list: private objects and argument objects. So check if we have an assignment statement.
        for(i = 0; i < list.size(); i++){
            sample = list.get(i);
            for(String tempPrivate: privateObjectList){
//                Check if LHS is private array from List
                if(sample.contains(tempPrivate) && (sample.contains("=") || (list.get(i+1).contains("=")))){
                    for(String tempArgument: objectArgumentList){
                        if(sample.contains(tempArgument) || list.get(i+1).contains(tempArgument) || list.get(i+2).contains(tempArgument)){
                            mutatedObjectList.add(tempPrivate);
                        }
                    }
                }
            }
        }

        if(!mutatedObjectList.isEmpty()){
            System.out.println("\n**Mutate Manager**");
            System.out.println("Warning: Private internal state may be mutated.");
            System.out.println("Following array objects are vulnerable: ");
            j = 1;
            for(String tempPrivateObject : mutatedObjectList){
                System.out.println(j+". " + tempPrivateObject);
                j++;
            }
            return true;
        }else
            return false;
    }
}
