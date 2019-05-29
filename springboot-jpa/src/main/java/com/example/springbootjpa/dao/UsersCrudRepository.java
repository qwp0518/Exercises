package com.example.springbootjpa.dao;

import com.example.springbootjpa.pojo.Users;
import org.springframework.data.repository.CrudRepository;

public interface UsersCrudRepository extends CrudRepository<Users,Integer> {

}
