package com.sss.online.serviceimpl;
import com.sss.online.dao.EmployeeMapper;
import com.sss.online.dto.EmployeeDto;
import com.sss.online.pojo.Employee;
import com.sss.online.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    public EmployeeDto selectEmpDto(String name) {
        EmployeeDto employeeDto = employeeMapper.selectEmpDto(name);
        return employeeDto;
    }
    public Employee selectByName(String name) {
        List<Employee> employees = employeeMapper.selectByName(name);
        if (employees == null) {
            return null;
        }else {
            if (employees.size() == 1) {
                Employee employee = employees.get(0);
                return employee;
            } else {
                return null;
            }
        }
    }
}
