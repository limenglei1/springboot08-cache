package com.limenglei.service;

import com.limenglei.bean.Employee;
import com.limenglei.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {


    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * 将方法的运行结果进行缓存,当查到相同的结果时就 从缓存中获取
     *
     * @param id
     * @return
     */
    @Cacheable(cacheNames = "{emp}")
    public Employee getEmpById(Integer id) {
        System.out.println("查询" + id + "员工");
        Employee emp = employeeMapper.getDeptById(id);
        return emp;
    }

    /**
     * @param employee
     * @return
     * @CachePut 既调用方法, 又同步更新缓存数据
     * <p>
     * 运行步骤:
     * 1,先调用方法
     * 2,将目标方法的返回值缓存起来
     */
    @CachePut(value = "{emp}", key = "#result.id")
    public Employee updateEmp(Employee employee) {
        System.out.println("同步更新" + employee);
        employeeMapper.updateDeptById(employee);
        return employee;

    }

    /**
     * @param id
     * @CacheEvict 表示清除缓存数据
     * allEntries 表示删除所有相关的数据
     * beforeInvocation=false  缓存的清除是否在方法执行之前执行
     * 默认是在方法执行之后执行,入如果出现异常就不清除
     * beforeInvocation=true
     * 代表在方法执行之前执行,无论是否出现异常,缓存都清楚
     */
    @CacheEvict(value = "emp", key = "#result.id", allEntries = true)
    public void deleteEmp(Integer id) {
        System.out.println("delete:" + id);
//        employeeMapper.deleteEmpById(id);

    }
}
