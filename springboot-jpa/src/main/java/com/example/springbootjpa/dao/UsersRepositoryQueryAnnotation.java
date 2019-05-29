package com.example.springbootjpa.dao;

import com.example.springbootjpa.pojo.Users;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface UsersRepositoryQueryAnnotation extends Repository<Users,Integer> {

    @Query(value = "select id,name,age,address from t_users where name = ?",nativeQuery = true)
    List<Users> queryByNameUseHQL(String name);

    @Query(value = "update t_users set name = ? where id = ?",nativeQuery = true)
    @Modifying
    void updateNameById(String name,Integer id);

}
