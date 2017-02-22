package com.mine.simpler.test;

import com.mine.simpler.util.FileRelationUtils;

public class MenuListLoadErrorFind {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//读取文件内容
		String filePath = "E:\\02-mine\\src\\main\\resources\\files\\menulist.json";
		FileRelationUtils.getFileStrFromPath(filePath);
	}
}
