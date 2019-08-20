package com.sss.online.serviceimpl;

import com.sss.online.dao.OverTimeMapper;
import com.sss.online.dto.EmployeeDto;
import com.sss.online.pojo.OverTime;
import com.sss.online.service.OverTimeService;
import com.sss.online.vo.JBGLVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author
 * @create 2019-06-04-16:10
 */
@Service
public class OverTimeServiceImpl implements OverTimeService {

    @Autowired
    OverTimeMapper overTimeMapper;
    @Override
    public int insertOverTime(JBGLVO jbglvo, EmployeeDto employeeDto) {
        OverTime overTime = new OverTime();
        overTime.setEmpName(employeeDto.getName());
        overTime.setEmpEmail(employeeDto.getEmail());
        overTime.setEmpId(employeeDto.getEmpId());
        overTime.setLeader(employeeDto.getLeader());
        overTime.setLeaderEmail(employeeDto.getLeaderEmail());
        overTime.setWorkStart(jbglvo.getWorkStart());
        overTime.setWorkEnd(jbglvo.getWorkEnd());
        overTime.setWorkTime(Double.parseDouble(jbglvo.getWorkTime()));
        overTime.setWorkContent(jbglvo.getWorkContent());
        overTime.setOtherEmail(jbglvo.getOtherEmail());
        overTime.setType("0");
        return 0;
    }
}
