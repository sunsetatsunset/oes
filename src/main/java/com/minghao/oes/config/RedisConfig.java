package com.minghao.oes.config;

import com.minghao.oes.domain.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.net.UnknownHostException;
@Configuration
public class RedisConfig {
    //改变redisTemplate默认序列化规则
    @Bean
    public RedisTemplate<Object, User> userRedisTemplate(RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<Object, User> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<User> userJackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<User>(User.class);
        template.setDefaultSerializer(userJackson2JsonRedisSerializer);
        return template;
    }
}
