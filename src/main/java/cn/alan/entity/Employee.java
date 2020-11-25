package cn.alan.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.*;

import lombok.Data;

@Data
@TableName("tbl_employee")
public class Employee implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String lastName;
    private String email;
    private Integer gender;
    private Integer age;

    // 注意！这里需要标记为填充字段
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
