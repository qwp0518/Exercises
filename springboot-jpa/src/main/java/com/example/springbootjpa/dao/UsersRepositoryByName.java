package com.example.springbootjpa.dao;

import com.example.springbootjpa.pojo.Users;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface UsersRepositoryByName extends Repository<Users,Integer> {
    List<Users> findByName(String name);
    List<Users> findByNameAndAge(String name,Integer age);
    List<Users> findByNameLike(String name);
    List<Users> findById(Integer id);
}
