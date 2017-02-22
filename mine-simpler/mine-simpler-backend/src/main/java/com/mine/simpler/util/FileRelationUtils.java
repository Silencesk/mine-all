package com.mine.simpler.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.lang3.StringUtils;

public class FileRelationUtils {
	
	public static String getFileStrFromPath(String filePath){
		String fileStr = "";
		String fileStrProcessed = "";
		File file = new File(filePath);
		String fileName = file.getName();
		
		try {
			InputStream inStream = new FileInputStream(file);
			InputStreamReader inReader = new InputStreamReader(inStream);
			BufferedReader bufferedReader = new BufferedReader(inReader);
			StringBuffer sb = new StringBuffer();
			String line;
			try {
				while((line = bufferedReader.readLine()) != null){
					sb.append(line);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("======" + fileName + "======");
			System.out.println(sb.toString());
			
			//file字符串  
			fileStr = sb.toString();
			System.out.println("======fileStr======");
			System.out.println(fileStr);
			
			//file字符串java文本
			fileStrProcessed = "\"" + fileStr.replace("\"", "\\\"") + "\"";
			System.out.println("======fileStrProcessed======");
			System.out.println(fileStrProcessed);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return fileStr;
	}
	
	/**
	 * 获取文件扩展名
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public static String getFileExtensionName(String fileName) throws Exception{
		String extName = "";
		if(StringUtils.isNotEmpty(fileName)){
			int index = fileName.indexOf(".");
			if(index == 0){
				throw new Exception("can't get extension name, becase of error fileName");
			}
			extName  = fileName.substring(index+1);
		}else{
			throw new Exception("fileName is empty");
		}
		return extName;
	}
}
