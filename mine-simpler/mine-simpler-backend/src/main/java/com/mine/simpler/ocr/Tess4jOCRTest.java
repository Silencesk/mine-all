package com.mine.simpler.ocr;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mine.simpler.enums.ImageType;
import com.mine.simpler.utils.FileRelationUtil;

import net.sourceforge.tess4j.Tesseract;

/**
 * liutao
 */
public class Tess4jOCRTest {
	private static final Logger logger = LoggerFactory.getLogger(Tess4jOCRTest.class);
	
	public static void main(String[] args) {
		String srcPath = "E:\\temp\\t1.png";
		try {
			//读取源图片与处理
			String srcFormate = FileRelationUtil.getFileExtensionName(srcPath);
			File imageFile = null;
			if(srcFormate.equalsIgnoreCase(ImageType.PNG.getType())){
				imageFile = createImageOfNewFormat(srcPath, ImageType.JPG.getType());
			}else{
				imageFile = new File(srcPath);
			}
			//识别图片文字
			//loadDll("liblept171.dll");
			loadDll("libtesseract304.dll");
			Tesseract instance = new Tesseract();
			instance.doOCR(imageFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static File createImageOfNewFormat(String srcPath, String formatName) throws Exception{
		String srcFormate = FileRelationUtil.getFileExtensionName(srcPath);
		File imageFile = new File(srcPath);
		String destPath = imageFile.getParent() + "\\tmp\\" + imageFile.getName().replace(srcFormate, formatName);
		if(imageFile != null){
			BufferedImage bImage = ImageIO.read(imageFile);
			ImageIO.write(bImage, formatName, new FileOutputStream(destPath));
		}
		File newFile = new File(destPath);
		return newFile;
	}
	
	public static void loadDll(String libFullName){
		try{
			String nativeTmpDir = System.getProperty("java.io.tmpdir");
			InputStream in = null;
			FileOutputStream writer = null;
			String nativeLibFilePath = nativeTmpDir + File.separator + libFullName;
			File nativeLibFile = new File(nativeLibFilePath);
			if(!nativeLibFile.exists()){
				try{
					in = Tesseract.class.getResourceAsStream("/win32-x86-64/" + libFullName);	//path 不以’/'开头时默认是从此类所在的包下取资源，以’/'开头则是从
					if(in == null){
						logger.error("当前目录下无" + libFullName);
						throw new IOException("当前目录下无" + libFullName);
					}
					BufferedInputStream reader = new BufferedInputStream(in);	//带缓冲，能提高字节流读取效率
					writer = new FileOutputStream(nativeLibFile);
					byte[] bits = new byte[1024];
					while(reader.read(bits) != -1){
						writer.write(bits);
						bits = new byte[1024];
					}
					in.close();
					writer.close();
					System.load(nativeLibFile.toString());
				} catch (IOException e) {
					e.printStackTrace();
				}finally{
					if(in != null) in.close();
					if(writer != null) writer.close();
				}
			}else{
				System.load(nativeLibFile.toString());
			}
		}catch (IOException e) {
			logger.error("初始化 " + libFullName + " DLL错误", e);
		}
	}
}
