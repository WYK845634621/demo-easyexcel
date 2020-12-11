package com.yikai.demoeasyexcel.controller;

import com.alibaba.excel.EasyExcel;
import com.yikai.demoeasyexcel.entity.Employee;
import com.yikai.demoeasyexcel.listener.DemoDataListener;
import com.yikai.demoeasyexcel.mapper.EmployeeMapper;
import com.yikai.demoeasyexcel.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @Description
 * @Tips
 * @Author yikai.wang
 * @Number K1171305
 * @Date 2020/12/11 9:44
 */
@RestController
public class HelloController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeMapper mapper;

    @GetMapping("/all")
    public List<Employee> all(){
        return employeeService.all();
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    //读取本地文件: 单个sheet
    @GetMapping("/start")
    public String start(){
        long start = System.currentTimeMillis();
        String path = "C:\\Users\\WangYiKai\\Desktop\\1.xlsx";
        EasyExcel.read(path,Employee.class,new DemoDataListener(mapper)).sheet().doRead();
        long end = System.currentTimeMillis();
        return "" + (end - start);
    }


    /**
     * 读取单个sheet
     */
    @PostMapping("/startOne")
    public String startOne(@RequestParam("file") MultipartFile file) throws IOException {
        long start = System.currentTimeMillis();
        EasyExcel.read(file.getInputStream(),Employee.class,new DemoDataListener(mapper)).sheet().doRead();
        long end = System.currentTimeMillis();
        return "" + (end - start);
    }


    @PostMapping("/readAllSheet")
    public String readAllSheet(@RequestParam("file") MultipartFile file) throws IOException {
        long start = System.currentTimeMillis();
        EasyExcel.read(file.getInputStream(),Employee.class,new DemoDataListener(mapper)).doReadAll();
        long end = System.currentTimeMillis();
        return "" + (end - start);
    }


}
