package com.tw.mapper;


import com.tw.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.Map;


@Repository
public interface UserMapper extends BaseMapper<User> {


Map<String,Object> selectMapById(Long id);
















}
