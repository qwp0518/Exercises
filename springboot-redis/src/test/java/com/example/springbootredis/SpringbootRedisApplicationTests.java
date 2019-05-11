package com.example.springbootredis;

import com.example.springbootredis.pojo.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
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

    /**
     * 基于Jdk序列化器
     */
    @Test
    public void testSetUsers(){
        this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        Users users = new Users();
        users.setAge(25);
        users.setName("william");
        users.setId(17);

        this.redisTemplate.opsForValue().set("users",users);
    }

    @Test
    public void testGetUsers(){
        this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        Users user = (Users) this.redisTemplate.opsForValue().get("users");
        System.out.println(user);
    }

    /**
     * 基于JSON序列化器
     */
    @Test
    public void testSetUsersJson(){
        Users users_json = new Users();
        users_json.setId(18);
        users_json.setName("BrotherP");
        users_json.setAge(18);

        this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Users.class));
        this.redisTemplate.opsForValue().set("users_json",users_json);
    }

    @Test
    public void testGetUsersJson(){
        this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Users.class));
        Users user_json =(Users) this.redisTemplate.opsForValue().get("users_json");
        System.out.println(user_json);

    }

}
