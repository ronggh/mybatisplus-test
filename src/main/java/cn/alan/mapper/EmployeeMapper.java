package cn.alan.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.alan.entity.Employee;

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {

    @Select("SELECT id,last_name,gender,age FROM tbl_employee WHERE last_name LIKE #{name}")
    List<Employee> searchByName(@Param("name") String name);

}
