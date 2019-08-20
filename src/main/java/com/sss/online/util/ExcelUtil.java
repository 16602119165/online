package com.sss.online.util;

import com.sss.online.pojo.XZBB;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @author
 * @create 2019-08-19-10:35
 */
public class ExcelUtil {
    public static void  exportExcle(File file,List<XZBB> list,OutputStream os,String sheetName,String[] headers) {
        Workbook workbook;//工作薄
        if(file.getName().equals("xlsx")) {
            workbook = new XSSFWorkbook();
            exportExcle(workbook, file, list, "yyyy-MM-dd HH:mm:ss", os, sheetName,headers);
        }
        if(file.getName().equals("xls")){
            workbook = new HSSFWorkbook();
            exportExcle(workbook,file,list,"yyyy-MM-dd HH:mm:ss",os,sheetName,headers);
        }
    }

    public static void exportExcle(Workbook workbook, File file, List<XZBB> list, String formatter, OutputStream outputStream, String sheetName,String[] headers){
        //1.创建sheet表格
        Sheet sheet = workbook.createSheet(sheetName);
        //2、创建sheet表格标题行 ,通过sheet来生成row
        Row row = sheet.createRow(0);
        Cell cellHeader;
        int cellNumber = headers.length;
        for (int i = 0;i<cellNumber;i++){
            cellHeader = row.createCell(i);
            cellHeader.setCellValue(headers[i]);
        }
        //3遍历集合数据，并给每一个单元格cell赋值
        for(int j = 0;j<list.size();j++){
            //根据数据集合的大小，创建对应的row，
            Row dataRow = sheet.createRow(j+1);
            Cell dataCell;
                for (int c = 0; c < cellNumber; c++) {
                    dataCell = row.createCell(c);
                    switch (c) {
                        case 0:
                            dataCell.setCellValue(list.get(j).getEmpName());
                            break;
                        case 1:
                            dataCell.setCellValue(list.get(j).getDeptName());
                            break;
                        case 2:
                            dataCell.setCellValue(list.get(j).getPost());
                            break;
                        case 3:
                            dataCell.setCellValue(list.get(j).getTypeName());
                            break;
                        case 4:
                            dataCell.setCellValue(list.get(j).getFormTypeDetail());
                            break;
                        case 5:
                            dataCell.setCellValue(list.get(j).getCreateDate());
                            break;
                        case 6:
                            dataCell.setCellValue(list.get(j).getStart());
                            break;
                        case 7:
                            dataCell.setCellValue(list.get(j).getEnd());
                            break;
                        case 8:
                            dataCell.setCellValue(list.get(j).getTime());
                            break;
                    }
                    //list中数据是对象而不是数组，如何来遍历取值？？ 通过switch case可以实现遍历
                }
        }
        try {
            workbook.write(outputStream);
        }catch (IOException io){
            io.printStackTrace();
        }finally {
            try {
                workbook.close();
            }catch (IOException io){
                io.printStackTrace();
            }
        }




    }
}
