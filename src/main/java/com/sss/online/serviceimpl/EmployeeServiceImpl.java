package com.sss.online.serviceimpl;
import com.sss.online.dao.EmployeeMapper;
import com.sss.online.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;
    @Override
    public Integer selectEmployee(String name, String password) {
        Integer integer = employeeMapper.selectEmployee(name, password);
        return integer;
    }
}
