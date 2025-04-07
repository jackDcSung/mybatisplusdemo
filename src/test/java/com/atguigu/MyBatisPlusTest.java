package com.atguigu;


import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.User;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@SpringBootTest
public class MyBatisPlusTest {


    @Autowired
    private UserMapper userMapper;


    @Test
    public void testSelectList() {


        // 1.通過條件構造器查詢一個list集合,若無條件
        List<User> list = userMapper.selectList(null);

        list.forEach(System.out::println);


    }
    @Test
    public void testInsert(){

        User user = new User();
        user.setName("張三");
        user.setAge(23);
        user.setEmail("zhangsan@atguigu.com");
        int result = userMapper.insert(user);
        System.out.println("result "+result);
        System.out.println("id "+user.getId());
    }


    @Test
    public void testDelete(){
//        userMapper.deleteById(1909324471597006850L);


//        Map<String, Object> map = new HashMap<>();
//        map.put("name", "張三");
//        map.put("age", 23);
//        int result = userMapper.deleteByMap(map);
//        System.out.println("result " + result);
        List<Long> list = Arrays.asList(1L, 2L, 3L, 4L);
        userMapper.deleteBatchIds(list);
        int result = userMapper.deleteBatchIds(list);

        System.out.println("result " + result);
    }







}
