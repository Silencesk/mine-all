package com.mine.learn;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringStd {
	/**
	 * 正则-匹配整数
	 */
	public static final String REGEX_INTEGER = "^-?\\d+$";
	/**
	 * 正则-匹配浮点
	 */
	public static final String REGEX_DECIMAL = "^(-?\\d+)(\\.\\d+)?$";
	
	// replaceAll
	public static void main(String[] args){
		String s = "com.belle.eyd.uc.domain.project";
		String packageName = s.replace(".domain", ".vo");
		String[] packageNames = new String[3];
		packageNames[0] = packageName;
		packageNames[1] = packageName.replaceAll("\\.vo.*", ".vo");		// \\转义特殊字符
		packageNames[2] = packageName.replaceAll("\\.vo.*", ".dto");
		System.out.println(Arrays.toString(packageNames));
		
	}
	
	// regex @see http://blog.csdn.net/kiss_vicente/article/details/8050816
//	@Test
	public void testRegex() {
		String s = "1212124444.0232dd3";
		// 正则初始化
//		Pattern p = Pattern.compile(REGEX_INTEGER);
		Pattern p = Pattern.compile(REGEX_DECIMAL);
		// 匹配器初始化
		Matcher m = p.matcher(s);
		// 匹配查询
		if(m.find()){
			System.out.println("is integer");
		}else{
			System.out.println("not integer");
		}
	}
	
	public static void main1(String[] args){
		String str = new String("hello");
		System.out.println(str.toString());
		str += "world";
		System.out.println(str);
		
		int i = testFinally();
		System.out.println(i);
	}
	
	@SuppressWarnings("finally")
	public static int testFinally(){
		try {
			return 1;
		} finally{
			return 2;
		}
	}
}
