package com.sss.online.serviceimpl;

import com.sss.online.XZGLType;
import com.sss.online.dao.QJGLMapper;
import com.sss.online.dao.XZGLMapper;
import com.sss.online.pojo.*;
import com.sss.online.service.XZGLService;
import com.sss.online.util.DateUtil;
import com.sss.online.vo.QJGLVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author
 * @create 2019-06-27-16:14
 */
@Service("qjglServiceImp")
public class QJGLServiceImp implements XZGLService {

    @Autowired
    QJGLMapper qjglMapper;
    @Autowired
    XZGLMapper xzglMapper;

    @Override
    public List<UICombobox> qjlxquery() {
        List<QJLX> lists = qjglMapper.selectAll();
        List<UICombobox> qjlxs = new ArrayList<>();
        for (QJLX qjlx : lists){
           UICombobox uiCombobox = new UICombobox();
           uiCombobox.setId(Integer.toString(qjlx.getId()));
           uiCombobox.setText(qjlx.getQjlx());
           uiCombobox.setSelected(false);
           qjlxs.add(uiCombobox);
        }
        return qjlxs;
    }

    @Override
    public List<UICombobox> csQuery() {
        List<Employee> employees = qjglMapper.selectCSAll();
        List<UICombobox> css = new ArrayList<>();
        for (Employee  cs: employees){
            UICombobox uiCombobox = new UICombobox();
            uiCombobox.setId(Integer.toString(cs.getId()));
            uiCombobox.setText(cs.getName());
            uiCombobox.setSelected(false);
            css.add(uiCombobox);
        }
        return css;
    }

    @Override//请假申请添加记录
    public int qjglAdd(QJGLVO qjglvo) {
        Date date = new Date();
        System.out.println(date);
        XZGL xzgl = new XZGL();
        xzgl.setType(XZGLType.qingjia.getCode());
        xzgl.setTypeName(XZGLType.qingjia.getTypeName());
        xzgl.setEmpName(qjglvo.getEmpName());
        xzgl.setDeptName(qjglvo.getDeptName());
        xzgl.setPost(qjglvo.getPost());
        xzgl.setEmpId(Integer.parseInt(qjglvo.getEmpId()));
        xzgl.setCreateDate(DateUtil.dateToTimestamp(date,"yyyy-MM-dd HH:mm:ss"));
        xzgl.setStart(DateUtil.stringToTimestamp(qjglvo.getStart(),"yyyy-MM-dd HH:mm:ss"));
        xzgl.setEnd(DateUtil.stringToTimestamp(qjglvo.getEnd(),"yyyy-MM-dd HH:mm:ss"));
        xzgl.setContent(qjglvo.getQjsy());
        xzgl.setCs(qjglvo.getCs());
        xzgl.setLeader(qjglvo.getLeader());
        xzgl.setFormType(qjglvo.getQjlx());
        xzgl.setTime(qjglvo.getTime());
        xzgl.setFormTypeDetail(qjglvo.getFormTypeDetail());
        int i = xzglMapper.QJGLAdd(xzgl);
        return i;
    }
}
