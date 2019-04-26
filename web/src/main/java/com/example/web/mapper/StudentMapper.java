package com.example.web.mapper;

import com.example.web.pojo.Student;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Component;

@Component
public interface StudentMapper {

    void insertStudent(Student student);
}
