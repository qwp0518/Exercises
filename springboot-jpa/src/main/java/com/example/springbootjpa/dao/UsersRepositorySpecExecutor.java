package com.example.springbootjpa.dao;

import com.example.springbootjpa.pojo.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UsersRepositorySpecExecutor extends JpaRepository<Users,Integer>, JpaSpecificationExecutor<Users> {
}
