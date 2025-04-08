package com.tw;

import com.tw.pojo.User;
import com.tw.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class MyBatisPlusServiceTest {



    @Autowired
    private UserService userService;


    @Test
    public void testGetCount() {


        // 查詢總紀錄數.

        long count = userService.count();

        System.out.println("count = " + count);


    }


    @Test
    public void testInsertMore() {

        List<User> list = new ArrayList<>();
        //批量添加
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("ybc" + i);
            user.setAge(20 + i);
            user.setAge(20+i);
            list.add(user);
        }

        boolean b = userService.saveBatch(list);

        System.out.println(b);


    }



}
