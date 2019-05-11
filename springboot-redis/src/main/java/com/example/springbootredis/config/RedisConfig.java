package com.example.springbootredis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 配置Redis
 */
@Configuration
public class RedisConfig {
    /**
     * 配置JedisPool
     */
    @Bean
    public JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig config = new JedisPoolConfig();

        //配置最大空闲数
        config.setMaxIdle(10);
        //最小空闲数
        config.setMinIdle(5);
        //最大连接数
        config.setMaxTotal(20);

        return config;

    }

    /**
     * 配置Redis连接信息
     */
    @Bean
    public JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig config){
        JedisConnectionFactory factory = new JedisConnectionFactory();

        //关联连接池的配置对象
        factory.setPoolConfig(config);

        //配置连接Redis的信息
        factory.setHostName("192.168.88.128");
        factory.setPort(6379);

        return factory;
    }

    /**
     * 创建RedisTemplates,用于执行对Redis操作的方法
     */
    @Bean
    public RedisTemplate<String,Object> redisTemplate(JedisConnectionFactory factory){
        RedisTemplate<String,Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);

        //为key设置序列化器
        template.setKeySerializer(new StringRedisSerializer());
        //为value设置序列化器
        template.setValueSerializer(new StringRedisSerializer());

        return template;
    }

}
