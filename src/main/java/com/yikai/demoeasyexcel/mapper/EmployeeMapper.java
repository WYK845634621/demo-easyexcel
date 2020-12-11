package com.yikai.demoeasyexcel.mapper;


import com.yikai.demoeasyexcel.entity.Employee;

import java.util.List;

/**
 * @Author wangyikai
 * @Date 2018/9/18 - 15:53
 */
//提前要使用@Mapper或者@MapperScan将接口扫描到容器中去
public interface EmployeeMapper {

    List<Employee> all();

    void saveBatch(List<Employee> list);
}
