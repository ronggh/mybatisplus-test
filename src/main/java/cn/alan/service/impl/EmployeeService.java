package cn.alan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.alan.entity.Employee;
import cn.alan.mapper.EmployeeMapper;
import cn.alan.service.IEmployeeService;

@Service
public class EmployeeService extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 按名称模糊查询员工
     * 
     * @param name
     * @return
     */
    @Override
    public List<Employee> search(String name) {
        QueryWrapper<Employee> queryWrapper = new QueryWrapper();
        queryWrapper.like("last_name", name);
        List<Employee> list = employeeMapper.selectList(queryWrapper);
        return list;
    }

}
