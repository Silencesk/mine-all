package com.mine.simpler.test;
/**
 * 
 * Description: 读取文件内容 并使用正则表达式进行替换
 * All rights Reserved, Designed By BeLLE
 * Copyright:   Copyright(C) 2014-2015
 * Company:     Wonhigh.
 * author:      liutao
 * Createdate:  2015-4-9下午7:27:17
 *
 *
 * Modification  History:
 * Date         Author             What
 * ------------------------------------------
 * 2015-4-9     	liutao
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyFileReaderTest {
	public static void main(String[] args) {
		//读取文件内容
		String path = "E:\\02-mine\\src\\main\\resources\\mdm-abc.js";
		File file = new File(path);
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
			System.out.println("目标串是：" + sb.toString());
			//正则替换
			String regex = "requires\\:\\[(.*?)\\]\\,";//*?表示匹配最少字符
			Pattern p =  Pattern.compile(regex);
			Matcher matcher = p.matcher(sb);
			while(matcher.find()){
				System.out.println(matcher.group() + "子串的start" + matcher.start() + "，end为" + matcher.end());
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
