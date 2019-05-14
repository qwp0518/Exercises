package com.example.springbootjpa;

import com.example.springbootjpa.dao.UsersCrudRepository;
import com.example.springbootjpa.dao.UsersRepository;
import com.example.springbootjpa.dao.UsersRepositoryByName;
import com.example.springbootjpa.pojo.Roles;
import com.example.springbootjpa.pojo.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class OneToManyTests {
    @Autowired
    private UsersRepository usersRepository;
    private UsersRepositoryByName usersRepositoryByName;
    @Test
    public void saveTest(){
        Users users = new Users();
        users.setName("Trump");
        users.setAge(50);
        users.setAddress("Washington");

        Roles roles = new Roles();
        roles.setRolename("administrator");

        roles.getUsers().add(users);
        users.setRoles(roles);

        this.usersRepository.save(users);
    }

    /**
     * org.hibernate.LazyInitializationException: could not initialize proxy -no session
     * 该问题未解决
     */
//    @Test
//    public void findTest(){
//        Users users = this.usersRepository.getOne(4);
//        System.out.println(users);
//
//        Roles roles = users.getRoles();
//        System.out.println(roles);
//    }




}
