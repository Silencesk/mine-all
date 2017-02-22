package com.mine.core.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * 
 * Description: 类操作工具
 * All rights Reserved, Designed By BeLLE
 * Copyright:   Copyright(C) 2014-2015
 * Company:     Wonhigh.
 * author:      liutao
 * Createdate:  2015-10-3下午6:17:11
 *
 *
 * Modification  History:
 * Date         Author             What
 * ------------------------------------------
 * 2015-10-3     	liutao
 */
@SuppressWarnings("rawtypes")
public class ClassUtil {
	//返回接口的所有实现类
	@SuppressWarnings("unchecked") 
	public static List<Class> getAllClassesByInterface(Class c){
		List<Class> retClasses = new ArrayList<Class>();	//返回结果
		String packageName = c.getPackage().getName();	//获取类的包名
		//判断输入的类是否为接口
		if(!c.isInterface()){
			return null;
		}
		try {
			List<Class> allClasses = getClasses(packageName);
			for(Class clazz : allClasses){
				//	判断c是否是clazz的子类或接口
				if(c.isAssignableFrom(clazz)){	//Class.isAssignableFrom()是用来判断一个类Class1和另一个类Class2是否相同或是另一个类的子类或接口。   
					if(!c.equals(clazz)){
						retClasses.add(clazz);
					}
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	//获取已加载类的当前包名下的所有类
		
		return retClasses;
	}
	
	public static List<Class> getClasses(String packageName) throws IOException, ClassNotFoundException{
		List<Class> retClasses = new ArrayList<Class>();
		String rpath = packageName.replace(".", "/");	//包相对路径
		//当前类加载器
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Enumeration<URL> resources = loader.getResources(rpath);	//获取包相对路劲下所有资源
		//遍历所有资源，并将其加入至需查找的目录列表
		List<File> dirs = new ArrayList<File>();
		while(resources.hasMoreElements()){
			URL resource = resources.nextElement();
			dirs.add(new File(resource.getFile()));
		}
		//在包所在的路径下面进行搜索 一个个寻找符合条件的类
		for(File dir : dirs){
			retClasses.addAll(findClasses(dir, packageName));
		}
		return retClasses;
	}
	
	public static List<Class> findClasses(File dir, String packageName) throws ClassNotFoundException{
		List<Class> classes = new ArrayList<Class>();
		if(!dir.exists()){
			return classes;
		}
		File[] files = dir.listFiles();
		for(File file : files){
			if(file.isDirectory()){
				classes.addAll(findClasses(file, packageName + "." + file.getName()));
			}else{
				classes.add(Class.forName(packageName + "." + file.getName().replace(".class", "")));	//getPath为绝对路径
			}
		}
		
		return classes;
	}
}
