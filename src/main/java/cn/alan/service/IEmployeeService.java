package cn.alan.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

import cn.alan.entity.Employee;

public interface IEmployeeService extends IService<Employee> {
    List<Employee> search(String name);
}
