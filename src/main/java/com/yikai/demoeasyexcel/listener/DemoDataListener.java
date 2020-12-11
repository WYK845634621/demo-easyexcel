package com.yikai.demoeasyexcel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.yikai.demoeasyexcel.entity.Employee;
import com.yikai.demoeasyexcel.mapper.EmployeeMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Tips
 * @Author yikai.wang
 * @Number K1171305
 * @Date 2020/12/11 10:16
 */
@Slf4j
public class DemoDataListener extends AnalysisEventListener<Employee> {

    private static final int BATCH_COUNT = 10;
    private EmployeeMapper mapper;
    private List<Employee> list = new ArrayList<>();

    public DemoDataListener(EmployeeMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * 每一条数据的解析都会调用这个方法
     * @param employee
     * @param analysisContext
     */
    @Override
    public void invoke(Employee employee, AnalysisContext analysisContext) {
        log.info("解析这一条数据: {}" + JSON.toJSONString(employee));
        list.add(employee);
        if (list.size() >= BATCH_COUNT){
            mapper.saveBatch(list);
            list.clear();
        }
    }

    /**
     * 所有数据解析完成了 都会来调用
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        mapper.saveBatch(list);
        log.info("全部数据解析完成");
    }
}
