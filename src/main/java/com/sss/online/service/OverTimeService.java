package com.sss.online.service;

import com.sss.online.dto.EmployeeDto;
import com.sss.online.vo.JBGLVO;

/**
 * @author
 * @create 2019-06-04-16:04
 */
public interface OverTimeService {
    int insertOverTime(JBGLVO jbglvo, EmployeeDto employeeDto);
}
