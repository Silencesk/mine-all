package com.mine.learn.jdbc;
/**
 * @desc 了解jdbc常用的几种方式
 * @author gekeo
 *
 */
public class JDBCMeasures {
	//jbbc 原始方式
	public void onlyJDBCForQuery(){
		//数据库参数
		String jdbcDriverClassName = "com.mysql.jdbc.Driver";
		String jdbcUrl = "jdbc:mysql://localhost:3306/user_integration?useUnicode=true&amp;characterEncoding=utf-8";
		String jdbcUserName = "root";
		String jdbcPassword = "root";
		//加载驱动
		try {
			Class.forName(jdbcDriverClassName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
}
