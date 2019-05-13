package com.example.springbootjpa.dao;

import com.example.springbootjpa.pojo.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Integer> {

}
