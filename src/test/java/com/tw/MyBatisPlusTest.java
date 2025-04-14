package com.tw;


import com.tw.mapper.UserMapper;
import com.tw.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;


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
    public void testInsert() {

        User user = new User();
//        user.setId(100L);
        user.setName("張三");
        user.setAge(23);
        user.setEmail("zhangsan@atguigu.com");
        int result = userMapper.insert(user);
        System.out.println("result " + result);
        System.out.println("id " + user.getId());
    }


    @Test
    public void testDelete() {
//        userMapper.deleteById(1909324471597006850L);


//        Map<String, Object> map = new HashMap<>();
//        map.put("name", "張三");
//        map.put("age", 23);
//        int result = userMapper.deleteByMap(map);
//        System.out.println("result " + result);
        List<Long> list = Arrays.asList(1L, 2L, 3L);
        userMapper.deleteBatchIds(list);
        int result = userMapper.deleteBatchIds(list);

        System.out.println("result " + result);
    }

    @Test
    public void testUpdate() {
        //修改用戶信息
        // 1.通過id查詢用戶
        User user = new User();
        user.setId(4L);
        user.setName("李四");
        user.setEmail("lisi@atguigu.com");
        int result = userMapper.updateById(user);
        System.out.println("result " + result);


    }


    @Test
    public void testSelect() {
        //通過ID查詢用戶訊息
//        User user = userMapper.selectById(1L);
//
//        System.out.println(user);
//
//        List<Long> list = Arrays.asList(1L, 2L, 3L);

        //根據多個ID查詢信息
//        List<User> users = userMapper.selectBatchIds(list);
//
//        users.forEach(System.out::println);


        //根據Map集合中的條件查詢用戶信息
//        Map<String, Object> map = new HashMap<>();
//
//        map.put("name", "Jack");
//
//        map.put("age", 20);
//
//        List<User> users = userMapper.selectByMap(map);
//
//        users.forEach(System.out::println);


        //select id,name,age,emall from user
        List<User> users = userMapper.selectList(null);

        users.forEach(System.out::println);

//        Map<String, Object> stringObjectMap = userMapper.selectMapById(1L);
//
//        System.out.println(stringObjectMap);

    }





}
