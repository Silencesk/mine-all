package com.mine.simpler.test;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

/**
 * 测试验证码解析
 * @author hanmanyi
 *
 */
public class TestOCR {
    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String path = "F:\\developer\\chrome\\mine\\jimubox\\images\\CaptchaImage.png";
         
//        for (int i = 0; i < 100; i++) {
            try {
                 
                filter(path);
//                String valCode = new OCR().recognizeText("C:\\Program Files\\Tesseract-OCR\\",new File(path), "jpg");
//                String valCode = new OCR().recognizeText("C:\\Program Files\\Tesseract-OCR\\",new File(path), "bmp");
//                valCode = valCode.replace("\r\n\r\n", "");
//                System.out.println(i+"|"+valCode);
//            } catch (IOException e) {
//                e.printStackTrace();
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
//        }
    }
    /**
     * 过滤掉图片中的直线和孤立点
     * 用被使用最多的颜色（即背景色）代替
     * 
     */
    public static void filter(String path) {
        InputStream instream;
        OutputStream out;
        String newpath = path;
        try {
            BufferedImage imgOrg = ImageIO.read(new File(path));
             
            instream = convert(imgOrg);
//            instream = new FileInputStream(new File(path));
            out = new FileOutputStream(new File(newpath));
            int byteread = 0;
            byte[] tmp = new byte[1];
            while ((byteread = instream.read(tmp)) != -1) {
                out.write(tmp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 用被使用最多的颜色（即背景色）代替
     * @param imgOrg
     */
    private static InputStream convert(BufferedImage img) {
        InputStream is = null;
        int width = img.getWidth();
        int height = img.getHeight();
        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                Long RGB = Long.parseLong(""+img.getRGB(i, j));
                Map<Long, Integer> map = getMaxColor(img,i,j);
                Integer c = map.get(RGB);
                 
                System.out.println(RGB);
                System.out.println(map);
                if (c != null && c >1) {
                    img.setRGB(i, j, 0xFF0000);
                }
            }
        }
        img.flush();
        ImageOutputStream imOut;
        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        try {
            imOut = ImageIO.createImageOutputStream(bs);
            ImageIO.write(img, "jpg",imOut);
            is= new ByteArrayInputStream(bs.toByteArray());
            } catch (IOException e) {
                e.printStackTrace();
            }
             
             
             
        return is;
    }
     
    /**
     * 周围使用最多的颜色
     * @param imgOrg
     */
    private static Map<Long, Integer> getMaxColor(BufferedImage img,int x,int y){
        int width = img.getWidth();
        int height = img.getHeight();
        int range = 2;
         
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        for (int j = y-range < 0?0:y-range; j < height && j<=y+range ; j++) {
            for (int i = x-range < 0?0:x-range; i < width && i<=x+range; i++) {
                long RGB = img.getRGB(i, j);
                Integer c = map.get(RGB);
                if (c == null) {
                    map.put(RGB, 1);
                } else {
                    map.put(RGB, c + 1);
                }
            }
        }
        return map;
    }
}