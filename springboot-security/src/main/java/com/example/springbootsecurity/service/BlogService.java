package com.example.springbootsecurity.service;

import com.example.springbootsecurity.pojo.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> getBlogs();
    void deleteBlog(long id);
}
