/*package com.mine.learn.jnative;

import org.xvolks.jnative.JNative;
import org.xvolks.jnative.exceptions.NativeException;
import org.xvolks.jnative.pointers.Pointer;
import org.xvolks.jnative.pointers.memory.MemoryBlockFactory;
import org.xvolks.jnative.Type;

public class JNativeT {
	static JNative TestDll = null;

	private int GETFONTHEX(String chnstr, String fontname, int orient, int height, int width, int bold, int italic,
			StringBuffer hexbuf) throws NativeException, Exception {
		try {
			Pointer pHexbuf = new Pointer(MemoryBlockFactory.createMemoryBlock(1024 * 1000));
			if (TestDll == null) {
				// 1. 利用org.xvolks.jnative.JNative来加载DLL：参数1.TestDll为类名
				System.setProperty("jnative.debug", "true");
//				System.out.println(System.getProperty("user.dir"));
				String dllName = "Fnthex32.dll";

				// 2.HCTInitEx方法名
				TestDll = new JNative(dllName, "GETFONTHEX");

				// 2.设置要调用方法中的参数：0 表示第一个以此类推
				TestDll.setParameter(0, Type.STRING, chnstr);
				TestDll.setParameter(1, Type.STRING, fontname);
				TestDll.setParameter(2, Type.INT, String.valueOf(orient));
				TestDll.setParameter(3, Type.INT, String.valueOf(height));
				TestDll.setParameter(4, Type.INT, String.valueOf(width));
				TestDll.setParameter(5, Type.INT, String.valueOf(bold));
				TestDll.setParameter(6, Type.INT, String.valueOf(italic));
				TestDll.setParameter(7, pHexbuf);

				// 3.设置返回参数的类型
				TestDll.setRetVal(Type.INT);

				// 4.执行方法
				TestDll.invoke();// 调用方法
			}
//			System.out.println("调用的DLL文件名为：" + TestDll.getDLLName());
//			System.out.println("调用的方法名为：" + TestDll.getFunctionName());
			
			// 5.返回值
			int count = Integer.parseInt(TestDll.getRetVal());
			hexbuf.append(pHexbuf.getAsString());
			System.out.println(hexbuf);
			return count;
		} finally {
			if (TestDll != null) {
				try {
					finalize();
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
		}
	};
	
	private String GetCharset(int x, int y, String fontname, int height, int width, int xmf, int ymf, String chnstr, int orient) throws Exception
    {
		StringBuffer test = new StringBuffer();
        String bytestr;

        int count;
        count = GETFONTHEX(chnstr, fontname, orient, height, width, 0, 0, test);
        if (count > 0)
        {
            bytestr = test.toString().substring(0, count);
            bytestr = bytestr + "^FO" + String.valueOf(x) + "," + String.valueOf(y) + "^XGOUTSTR01," + String.valueOf(xmf) + ',' + String.valueOf(ymf) + "^FS";
            return bytestr;
        }
        return "";
    }

	public static void main1(String[] args) throws Exception {
		String retStr = new JNativeT().GetCharset(318, 75, "宋体", 16, 0, 2, 2, "产品名称: 天下无双" , 0);
		System.out.println(retStr);
		StringBuffer hexbuf = new StringBuffer();
		new JNativeT().GETFONTHEX("jnatest", "黑体", 0, 30, 0, 1, 0, hexbuf);
	}
}
*/