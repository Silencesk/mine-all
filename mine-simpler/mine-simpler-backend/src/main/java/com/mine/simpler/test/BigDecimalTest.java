package com.mine.simpler.test;

import java.math.BigDecimal;

import com.mine.core.util.CommonUtil;

public class BigDecimalTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//test动态设置值
		//setNumberTest();
		//test取值
		testPareInt();
	}
	
	private static void testPareInt(){
		double i = 2.15;
		double j = 2.75;
		BigDecimal dbi = new BigDecimal(i);
		BigDecimal dbj = new BigDecimal(j);
		System.out.println("====dbi ROUND_HALF_UP is ====" + dbi.setScale(0, BigDecimal.ROUND_HALF_UP));
		System.out.println("====dbi ROUND_DOWN is ====" + dbi.setScale(0, BigDecimal.ROUND_DOWN));
		System.out.println("====dbi ROUND_UP is ====" + dbi.setScale(0, BigDecimal.ROUND_UP));
		System.out.println("====dbj ROUND_HALF_UP is ====" + dbj.setScale(0, BigDecimal.ROUND_HALF_UP));
		System.out.println("====dbj ROUND_DOWN is ====" + dbj.setScale(0, BigDecimal.ROUND_DOWN));
		System.out.println("====dbj ROUND_UP is ====" + dbj.setScale(0, BigDecimal.ROUND_UP));
	}
	
	private static void setNumberTest(){
		BigDecimalTest test =  new BigDecimalTest();
		MyNumber mn = test.new MyNumber();
		//BigDecimal number = new BigDecimal(1.0);
		double number = 1;
		String numberStr = "";
		try {
			CommonUtil.invokeMethod(mn, "setNumber", new Object[]{new BigDecimal(""+number)});
			numberStr = CommonUtil.invokeMethod(mn, "getNumber", new Object[]{}).toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("====numberStr====" + numberStr);
	}
	
	public class MyNumber{
		private BigDecimal number;

		public BigDecimal getNumber() {
			return number;
		}

		public void setNumber(BigDecimal number) {
			this.number = number;
		}
		
		
	}
}
