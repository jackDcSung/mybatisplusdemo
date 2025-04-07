package com.atguigu;


import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.User;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class MyBatisPlusTest {


    @Autowired
    private UserMapper userMapper;



    @Test
    public void testSelectList(){


        // 1.通過條件構造器查詢一個list集合,若無條件
        List<User> list = userMapper.selectList(null);

        list.forEach(System.out::println);





    }



}
