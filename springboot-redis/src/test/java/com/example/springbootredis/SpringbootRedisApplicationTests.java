package com.example.springbootredis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootRedisApplication.class)
public class SpringbootRedisApplicationTests {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Test
    public void tsetSet() {
        this.redisTemplate.opsForValue().set("name","william");
    }

    @Test
    public void testGet(){
        String value = (String) this.redisTemplate.opsForValue().get("name");
        System.out.println(value);
    }

}
