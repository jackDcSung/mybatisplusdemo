package com.tw.pojo;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@Data
//設置實體類對應的表明
//@TableName("t_user")
public class User {

    //將屬性指定對應字段指定為主鍵
    //@TableId註解的value屬性指定主鍵對應的表字段
    //@TableId註解的type屬性指定主鍵生成策略
//    @TableId(value = "uid",type = IdType.AUTO)
    @TableId(value = "uid")
    private Long id;

    //通過他指定屬性對應的字段名
    @TableField("user_name")
    private String name;

    private Integer age;

    private String email;

    @TableLogic
    private Integer isDeleted;




}
