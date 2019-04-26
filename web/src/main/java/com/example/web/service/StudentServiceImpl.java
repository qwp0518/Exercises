package com.example.web.service;

import com.example.web.mapper.StudentMapper;
import com.example.web.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public void addStudent(Student student) {
        this.studentMapper.insertStudent(student);
    }
}
