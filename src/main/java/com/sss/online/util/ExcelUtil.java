package com.sss.online.util;

import com.sss.online.pojo.XZBB;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @author
 * @create 2019-08-19-10:35
 */
public class ExcelUtil {
    public static Workbook downloadExcle(List<XZBB> list, String[] headers, String sheetName) {
        Workbook workbook;//工作薄
        workbook = new XSSFWorkbook();
        //1.创建sheet表格
        Sheet sheet = workbook.createSheet(sheetName);
        //2、创建sheet表格标题行 ,通过sheet来生成row
        Row row = sheet.createRow(0);
        Cell cellHeader;
        int cellNumber = headers.length;
        for (int i = 0; i < cellNumber; i++) {
            cellHeader = row.createCell(i);
            cellHeader.setCellValue(headers[i]);
        }
        //3遍历集合数据，并给每一个单元格cell赋值
        for (int j = 0; j < list.size(); j++) {
            //根据数据集合的大小，创建对应的row，
            row = sheet.createRow(j + 1);
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
                        dataCell.setCellValue(DateUtil.timestampToString(list.get(j).getCreateDate(),"yyyy-MM-dd HH:mm:ss"));
                        break;
                    case 6:
                        //dataCell.setCellValue(list.get(j).getStart());
                        dataCell.setCellValue(DateUtil.timestampToString(list.get(j).getStart(),"yyyy-MM-dd HH:mm:ss"));
                        break;
                    case 7:
                        dataCell.setCellValue(DateUtil.timestampToString(list.get(j).getEnd(),"yyyy-MM-dd HH:mm:ss"));
                        break;
                    case 8:
                        dataCell.setCellValue(list.get(j).getTime());
                        break;
                }
                //list中数据是对象而不是数组，如何来遍历取值？？ 通过switch case可以实现遍历
            }
        }
        return workbook;
    }

    public static Workbook networkDownload() {
        // 创建新的Excel工作簿
        XSSFWorkbook workbook = new XSSFWorkbook();
        // 在Excel工作簿中建一工作表，其名为缺省值, 也可以指定Sheet名称
        XSSFSheet sheet = workbook.createSheet();
        XSSFRow row = sheet.createRow(0);
        XSSFCell cell = row.createCell(0);
        cell.setCellValue("商户号");
        cell = row.createCell(1);
        cell.setCellValue("用户名");
        cell = row.createCell(2);
        cell.setCellValue("用户类型");
        cell = row.createCell(3);
        cell.setCellValue("上级用户");
        cell = row.createCell(4);
        cell.setCellValue("状态");
        cell = row.createCell(5);
        cell.setCellValue("认证");
        cell = row.createCell(6);
        cell.setCellValue("可用余额");
        cell = row.createCell(7);
        cell.setCellValue("冻结金额");
        cell = row.createCell(8);
        cell.setCellValue("注册时间");
        return workbook;
    }
}
