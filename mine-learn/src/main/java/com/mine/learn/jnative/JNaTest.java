/*package com.mine.learn.jnative;

import org.apache.commons.lang3.StringUtils;

import com.sun.jna.Library;
import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;

public class JNaTest {
	public static final String CLASSPATH = System.getProperty("user.dir") + "\\src\\main\\resources\\";

	public interface TestDll1 extends Library {
		public static final String dllName = "Fnthex32.dll";	//32位dll 
		TestDll1 INSTANCE = (TestDll1) Native.loadLibrary(CLASSPATH + dllName, TestDll1.class);

		public int GETFONTHEX(String chnstr, String fontname, int orient, int height, int width, int bold, int italic,
				Pointer pHexbuf) throws Exception;
	}

	public int GETFONTHEX(String chnstr, String fontname, int orient, int height, int width, int bold, int italic,
			StringBuffer hexbuf) throws Exception {
		Pointer p = new Memory(1024 * 100);
		int count = TestDll1.INSTANCE.GETFONTHEX(chnstr, fontname, orient, height, width, bold, italic, p);
		hexbuf.append(p.getString(0));
		return count;
	}

	*//**
	 * 
	 * @param X
	 *            横坐标
	 * @param Y
	 *            纵坐标
	 * @param outStr
	 *            打印内容
	 * @param fontName
	 *            字体
	 * @param FHEIGHT
	 *            高度
	 * @param fBold
	 *            加粗
	 * @param WFID
	 *            序号
	 * @param fReload
	 *            是否重装
	 * @throws Exception
	 *//*
	public void PrintFontZpl(int X, int Y, String outStr, String fontName, int FHEIGHT, int fBold, int WFID,
			boolean fReload) throws Exception {
		int Count;
		String zplCmd = "", imagename = "";
		String cBuf_part1, cBuf_part2, cBuf_part3;
		StringBuffer cBuf = new StringBuffer();

		imagename = "WINFNT" + StringUtils.leftPad(String.valueOf(WFID), 2, "0");

		if (fReload) {

			Count = GETFONTHEX(outStr, fontName, 0, FHEIGHT, 0, fBold, 0, cBuf);
			if (Count > 0) {
				cBuf_part1 = cBuf.toString().substring(0, 3);
				cBuf_part2 = imagename;
				cBuf_part3 = cBuf.toString().substring(11);
				cBuf = new StringBuffer(cBuf_part1 + cBuf_part2 + cBuf_part3);
				zplCmd = cBuf.toString().trim();
			}
			System.out.println(zplCmd);
		} else
			Count = 1; // for case of not reload

		if (Count > 0) {
			zplCmd = "^FO" + X + "," + Y;
			zplCmd = zplCmd + "^XG" + imagename + "^FS";
		}
		System.out.println(zplCmd);
	}

	public static void main1(String[] args) throws Exception {
		System.setProperty("jna.encoding", "GBK");
		new JNaTest().PrintFontZpl(630, 585, "于建辉", "黑体", 30, 1, 12, true);
	}
}
*/