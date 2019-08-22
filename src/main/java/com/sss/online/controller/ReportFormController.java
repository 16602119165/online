package com.sss.online.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.sss.online.basic.Result;
import com.sss.online.dto.XZBBQueryDTO;
import com.sss.online.pojo.UIComboTree;
import com.sss.online.pojo.UIDatagrid;
import com.sss.online.pojo.XZBB;
import com.sss.online.service.ReportFormService;
import com.sss.online.serviceimpl.ReportFormServiceImpl;
import com.sss.online.util.DateUtil;
import com.sss.online.util.ExcelUtil;
import com.sss.online.vo.XZBBQueryVO;
import com.sss.online.vo.XZBBVO;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author
 * @create 2019-07-12-15:10
 */
@RestController
@RequestMapping("/page/bbgl/xzbb")

public class ReportFormController {

    @Autowired
    ReportFormServiceImpl reportFormServiceImp;

    @RequestMapping("/queryName")
    //@ResponseBody
    public List<UIComboTree> queryName(){
        System.out.println("名字查询请求");
        Result result = new Result();
        List<UIComboTree> uiComboTreeList = reportFormServiceImp.queryName();
        if (uiComboTreeList != null){
            return uiComboTreeList;
        }
        return null;
    }
    @RequestMapping("/query")
    //@ResponseBody
    public UIDatagrid<XZBBVO> query(XZBBQueryVO queryVO){
        Result result = new Result();
        //System.out.println("报表请求");
        XZBBQueryDTO queryDTO = new XZBBQueryDTO(queryVO.getEmpName(),queryVO.getFormTypeDetail(),
                DateUtil.stringToTimestamp(queryVO.getStartTime(),"yyyy-MM-dd HH:mm:ss"),DateUtil.stringToTimestamp(queryVO.getEndTime(),"yyyy-MM-dd HH:mm:ss"));
        List<XZBB> xzbbList = reportFormServiceImp.queryXZBB(queryDTO);
        /*easyui datagrid要求返回格式有total，和rows两个数据*/
        long count = reportFormServiceImp.getCount(queryDTO);
        UIDatagrid<XZBBVO> datagrid = new UIDatagrid();
        List<XZBBVO> xzbbvoList = new ArrayList<>();
        UIDatagrid<XZBB> xzbbuiDatagrid = new UIDatagrid();
        /*将查询结果遍历赋值给VO，保证日期格式为string类型，保证前端显示正常。*/
        if (xzbbList != null && count >0){
            for(XZBB xzbb : xzbbList){
                XZBBVO xzbbvo = new XZBBVO(String.valueOf(xzbb.getId()),xzbb.getEmpName(),xzbb.getDeptName(),
                        xzbb.getPost(),xzbb.getTypeName(),xzbb.getFormTypeDetail(),DateUtil.timestampToString(xzbb.getCreateDate(),"yyyy-MM-dd HH:mm:ss"),
                        DateUtil.timestampToString(xzbb.getStart(),"yyyy-MM-dd HH:mm:ss"),DateUtil.timestampToString(xzbb.getEnd(),"yyyy-MM-dd HH:mm:ss"),xzbb.getTime());
                xzbbvoList.add(xzbbvo);
            }
            datagrid.setRows(xzbbvoList);
           datagrid.setTotal(count);
            System.out.println(datagrid);
           return datagrid;
            /*xzbbuiDatagrid.setTotal(count);
            xzbbuiDatagrid.setRows(xzbbList);
            System.out.println(xzbbuiDatagrid);
           return xzbbuiDatagrid;*/
        }
        return null;
    }

    @RequestMapping("/reportExport")
    public void reportExport(XZBBQueryVO queryVO, HttpServletResponse response){
        System.out.println("报表导出");
        XZBBQueryDTO queryDTO = new XZBBQueryDTO(queryVO.getEmpName(),queryVO.getFormTypeDetail(),
                DateUtil.stringToTimestamp(queryVO.getStartTime(),"yyyy-MM-dd HH:mm:ss"),DateUtil.stringToTimestamp(queryVO.getEndTime(),"yyyy-MM-dd HH:mm:ss"));
        List<XZBB> xzbbList = reportFormServiceImp.queryXZBB(queryDTO);
        String[] headers = {"姓名","部门","职位","类型","类型详细","创建时间","开始时间","结束时间","小计时长"};
        String sheetName = queryVO.getEmpName();
        OutputStream outputStream;
        OutputStream out =null;
        FileOutputStream fos = null;
        Workbook workbook =null;
        try {
            //ExcelUtil.exportExcle(file,xzbbList,outputStream,sheetName,headers,response);
             workbook = ExcelUtil.downloadExcle(xzbbList, headers, sheetName);
            response.reset();
            response.setCharacterEncoding("UTF-8");
            //response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            //response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(fileName,"UTF-8"));
            String filename = "net" + ".xlsx";
            response.setContentType("application/ms-excel;charset=UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename="
                    .concat(String.valueOf(URLEncoder.encode(filename, "UTF-8"))));
            out = response.getOutputStream();
            workbook.write(out);
            //workbook.write(response.getOutputStream());
            //workbook调用write方法可以写入一个临时文件
            /*fos = new FileOutputStream("F:\\book.xlsx");
            workbook.write(fos);*/
            /*byte[] content = ((ByteArrayOutputStream) outputStream).toByteArray();
            is = new ByteArrayInputStream(content);
            //File file = new File("C:\\Users\\Administrator\\Desktop\\download");
            out = response.getOutputStream();
            byte buff[] = new byte[2048];
            int len;
            System.out.println("xiechuqian");
            while ((len = is.read(buff)) != -1 ){
                out.write(buff,0,len);
            }*/
        }catch (Exception e){
            e.printStackTrace();
        }finally {
           try {
               if ( out != null){
                   out.close();
               }
           }catch (Exception ex){
               ex.printStackTrace();
           }
        }
    }
    @ResponseBody
    //@RequestMapping("/reportExport")
    public void testdownload(HttpServletResponse response) throws Exception{
        System.out.println("testdownload");
        String fileName = "t.xls";
        response.reset();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(fileName,"UTF-8"));
        OutputStream output;
        Workbook workbook = ExcelUtil.networkDownload();
        try {
            output = response.getOutputStream();
            BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);
            bufferedOutPut.flush();
            workbook.write(bufferedOutPut);
            bufferedOutPut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
