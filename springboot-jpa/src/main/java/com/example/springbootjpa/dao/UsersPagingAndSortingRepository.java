package com.example.springbootjpa.dao;

import com.example.springbootjpa.pojo.Users;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UsersPagingAndSortingRepository extends PagingAndSortingRepository<Users,Integer> {

}
