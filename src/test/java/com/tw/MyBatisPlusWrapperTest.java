package com.tw;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tw.mapper.UserMapper;
import com.tw.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class MyBatisPlusWrapperTest {


    @Autowired
    private UserMapper userMapper;


    @Test
    public void test01() {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //==>  Preparing: SELECT uid AS id,user_name AS name,age,email,is_deleted
        // FROM t_user WHERE is_deleted=0 AND (user_name LIKE ? AND age BETWEEN ? AND ? AND email IS NOT NULL) ORDER BY age DESC
        queryWrapper.like("user_name", "a")
                .between("age", 20, 30)
                .isNotNull("email")
                .orderByDesc("age");

        List<User> list = userMapper.selectList(queryWrapper);


        list.forEach(System.out::println);

    }

    @Test
    public void test02() {
        //查詢用戶信息 按照年齡的降序排序，若相同 在按照id排序
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();


        //SELECT uid AS id,user_name AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0 ORDER BY age DESC,uid ASC
        queryWrapper.orderByDesc("age")
                .orderByAsc("uid");

        List<User> list = userMapper.selectList(queryWrapper);

        list.forEach(System.out::println);


    }


    @Test
    void Test03() {

        //刪除郵件地址為null的用戶信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("email");
        int result = userMapper.delete(queryWrapper);
        System.out.println("result = " + result);

    }

    @Test
    public void test04() {
        //年齡大於20用戶名包含a 的用戶信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        queryWrapper.gt("age", 20)
                .like("user_name", "a")
                .or()
                .isNull("email");

        User user= new User();
        user.setName("小明");
        user.setEmail("test@atguigu.com");

        int result = userMapper.update(user, queryWrapper);

        System.out.println("result = " + result);

    }

    @Test
    public void test05() {
        //將用戶明中包含有a並且(年齡大於20或是郵件為null)的用戶信息

        //UPDATE t_user SET user_name=?, email=? WHERE is_deleted=0 AND (user_name LIKE ? AND (age > ? OR email IS NULL))

        QueryWrapper<User>  queryWrapper = new QueryWrapper<>();

        queryWrapper.like("user_name", "a")
                .and(i->i.gt("age", 20).or().isNull("email"));


        User user= new User();

        user.setName("小紅");

        user.setEmail("test@atguigu.com");

        int update = userMapper.update(user, queryWrapper);

        System.out.println("update = " + update);


    }

    @Test
    void Test06() {


        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        queryWrapper.select("user_name", "age","email");


        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);


        maps.forEach(System.out::println);

    }


    @Test
    void Test07() {

        //查詢id 小於等於100 的用戶信息
        //SELECT uid AS id,user_name AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0 AND (uid IN (select uid from t_user where uid <= 100))
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        queryWrapper.inSql("uid", "select uid from t_user where uid <= 100");

        List<User> list = userMapper.selectList(queryWrapper);

        list.forEach(System.out::println);


    }


}
