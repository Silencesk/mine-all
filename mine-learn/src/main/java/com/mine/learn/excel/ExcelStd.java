package com.mine.learn.excel;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.Region;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * excel操作
 *
 * @author liutao
 * @create 2017-02-17 上午11:10
 */

public class ExcelStd {
    /**
     * @param args
     */
    public static void main(String[] args) throws IOException {

        try {
            HSSFWorkbook wb = new HSSFWorkbook();
            HSSFSheet sheet = wb.createSheet("new   sheet");
            HSSFCellStyle style = wb.createCellStyle(); // 样式对象

            style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
            style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平
            HSSFRow row = sheet.createRow((short) 0);
            HSSFRow row2 = sheet.createRow((short) 1);

            sheet.addMergedRegion(new Region(0, (short) 0, 2, (short) 0));
            HSSFCell ce = row.createCell((short) 0);
//            ce.setEncoding(HSSFCell.ENCODING_UTF_16);// 中文处理
            ce.setCellValue("项目\\日期"); // 表格的第一行第一列显示的数据
            ce.setCellStyle(style); // 样式，居中

            int num = 0;
            for (int i = 0; i < 9; i++) { // 循环9次，每一次都要跨单元格显示
                // 计算从那个单元格跨到那一格
                int celln = 0;
                int celle = 0;
                if (i == 0) {
                    celln = 0;
                    celle = 1;
                } else {
                    celln = (i * 2);
                    celle = (i * 2 + 1);
                }
                // 单元格合并
                // 四个参数分别是：起始行，起始列，结束行，结束列
                sheet.addMergedRegion(new Region(0, (short) (celln + 1), 0,
                        (short) (celle + 1)));
                HSSFCell cell = row.createCell((short) (celln + 1));
                cell.setCellValue("merging" + i); // 跨单元格显示的数据
                cell.setCellStyle(style); // 样式
                // 不跨单元格显示的数据，如：分两行，上一行分别两格为一格，下一行就为两格，“数量”，“金额”
                HSSFCell cell1 = row2.createCell((short) celle);
                HSSFCell cell2 = row2.createCell((short) (celle + 1));
//                cell1.setEncoding(HSSFCell.ENCODING_UTF_16);
                cell1.setCellValue("数量");
                cell1.setCellStyle(style);
//                cell2.setEncoding(HSSFCell.ENCODING_UTF_16);
                cell2.setCellValue("金额");
                cell2.setCellStyle(style);
                num++;
            }

            // 在后面加上合计百分比

            // 合计 在最后加上，还要跨一个单元格
            sheet.addMergedRegion(new Region(0, (short) (2 * num + 1), 0,
                    (short) (2 * num + 2)));
            HSSFCell cell = row.createCell((short) (2 * num + 1));
//            cell.setEncoding(HSSFCell.ENCODING_UTF_16);
            cell.setCellValue("合计");
            cell.setCellStyle(style);
            HSSFCell cell1 = row2.createCell((short) (2 * num + 1));
            HSSFCell cell2 = row2.createCell((short) (2 * num + 2));
//            cell1.setEncoding(HSSFCell.ENCODING_UTF_16);
            cell1.setCellValue("数量");
            cell1.setCellStyle(style);
//            cell2.setEncoding(HSSFCell.ENCODING_UTF_16);
            cell2.setCellValue("金额");
            cell2.setCellStyle(style);

            // 百分比 同上
            sheet.addMergedRegion(new Region(0, (short) (2 * num + 3), 0,
                    (short) (2 * num + 4)));
            HSSFCell cellb = row.createCell((short) (2 * num + 3));
//            cellb.setEncoding(HSSFCell.ENCODING_UTF_16);

            cellb.setCellValue("百分比");
            cellb.setCellStyle(style);

            HSSFCell cellb1 = row2.createCell((short) (2 * num + 3));
            HSSFCell cellb2 = row2.createCell((short) (2 * num + 4));
//            cellb1.setEncoding(HSSFCell.ENCODING_UTF_16);
            cellb1.setCellValue("数量");
            cellb1.setCellStyle(style);
//            cellb2.setEncoding(HSSFCell.ENCODING_UTF_16);
            cellb2.setCellValue("金额");
            cellb2.setCellStyle(style);

            sheet.addMergedRegion(new Region(0, (short) 23, 2, (short) 23));
            HSSFCell ce1 = row.createCell((short) 23);
//            ce.setEncoding(HSSFCell.ENCODING_UTF_16);// 中文处理
            ce1.setCellValue("项目\\日期1"); // 表格的第一行第一列显示的数据
            ce1.setCellStyle(style); // 样式，居中

            FileOutputStream fileOut = new FileOutputStream("/Users/mokeo/Documents/workbook.xls");
            wb.write(fileOut);
            fileOut.close();

            System.out.println("OK");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
