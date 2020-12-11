package com.yikai.demoeasyexcel.service.impl;

import com.yikai.demoeasyexcel.entity.Employee;
import com.yikai.demoeasyexcel.mapper.EmployeeMapper;
import com.yikai.demoeasyexcel.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Tips
 * @Author yikai.wang
 * @Number K1171305
 * @Date 2020/12/11 10:12
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper mapper;
    @Override
    public List<Employee> all() {
        return mapper.all();
    }
}
