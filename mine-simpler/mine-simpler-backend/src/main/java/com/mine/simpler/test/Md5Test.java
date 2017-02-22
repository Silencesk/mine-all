package com.mine.simpler.test;

import com.mine.core.util.CommonUtil;

public class Md5Test {
	public static void main(String[] args){
		String plaintext = "123456";
		String ciphertext = CommonUtil.md5(plaintext);
		System.out.println(ciphertext);
		/**
		admin123-0192023a7bbd73250516f069df18b500    test-admin
		admin1234-c93ccd78b2076528346216b3b2f701e6		st-admin
		1-c4ca4238a0b923820dcc509a6f75849b
		123456-e10adc3949ba59abbe56e057f20f883e
		**/
	}
}
