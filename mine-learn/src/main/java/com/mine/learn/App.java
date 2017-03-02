package com.mine.learn;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	String intput = "i am a student";
        System.out.println(printWithNoSort(intput));
    }

    static String printWithNoSort(String inStr){
    	if(null!=inStr && inStr.equals("")){
    		return "";
    	}
    	String[] inArray = inStr.split(" ");
    	StringBuilder sb = new StringBuilder();
    	Random r = new Random();
    	int length = inArray.length;
    	Set intSet = new HashSet();
    	for(int i=0; i<length;){
    		int var = r.nextInt(length);
    		if(intSet.contains(var)){
    			continue;
    		}
    		intSet.add(var);
    		sb.append(" ").append(inArray[var]);
    		i++;
    	}

    	return sb.substring(1);
    }
}
