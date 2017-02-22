package com.mine.core.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mine.core.constan.SysConstans;

public class SignUtils {
	private static Logger logger = LoggerFactory.getLogger(SignUtils.class);

	/**
	 * 签名的KEY
	 * 
	 * @return
	 */
	public static String getSign_key() {
		String sign_key = SysConstans.SIGN_KEY;
		return sign_key;
	}

	public static String getSign(String req_time, String sign_key) {
		return md5(req_time + sign_key);
	}

	/**
	 * 对字符串进行MD5加密
	 * 
	 * @param plainText
	 *            String
	 * @return String
	 */
	public static String md5(String plainText) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0) {
					i += 256;
				}
				if (i < 16) {
					buf.append("0");
				}
				buf.append(Integer.toHexString(i));
			}
			return buf.toString();
		} catch (NoSuchAlgorithmException e) {
			// e.printStackTrace();
			logger.error("", e);
			return "";
		}
	}
}
