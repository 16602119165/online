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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
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
        File file = new File("classpath:考勤记录.xlsx");
        OutputStream outputStream;
        try {
            outputStream = response.getOutputStream();
            ExcelUtil.exportExcle(file,xzbbList,outputStream,sheetName,headers);
        }catch (IOException io){
            io.printStackTrace();
        }
    }
}
