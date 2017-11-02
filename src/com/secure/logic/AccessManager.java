package com.secure.logic;

import com.secure.logic.finder.PrivateObjectFinder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaushik on 10/14/17.
 */
public class AccessManager {
    public boolean isAccessible(List<String> list){
//        Get private object lists
        ArrayList<String> privateObjectList = (ArrayList<String>) PrivateObjectFinder.findPrivateObject(list);

        ArrayList<String> foundList = new ArrayList<String>();
        String sample = "";

//        Check if private object is being returned
        if(!privateObjectList.isEmpty()){
            for(int i = 0; i < list.size() - 2; i++){
                sample = list.get(i);
                for(String tempPrivateObject : privateObjectList){
                    if(sample.contains(tempPrivateObject) && (!sample.contains("clone")) && list.get(i-1).equals("return")){
                        foundList.add(tempPrivateObject);
                    }
                }
            }
        }

        if(!foundList.isEmpty()){
            System.out.println("\n**Access Manager**");
            System.out.println("Warning: Private internal state may be modified.");
            System.out.println("Following array objects are accessible: ");
            int j = 1;
            for(String tempPrivateObject : foundList){
                System.out.println(j+". " + tempPrivateObject);
                j++;
            }
            return true;
        }else
            return false;
    }
}
