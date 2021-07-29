package com.minghao.oes;

import com.minghao.oes.domain.User;
import com.minghao.oes.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class RedisTest {
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    UserService userService;
    @Autowired
    RedisTemplate<Object, User> userRedisTemplate;
    @Test
    void redisTest() {
        User user = userService.getUserById(1);
        userRedisTemplate.opsForValue().set("user01", user);
        System.out.println(userRedisTemplate.opsForValue().get("user01"));
    }
}
