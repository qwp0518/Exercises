package com.example.controller;

import com.example.pojo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * 表单数据检验
 */
@Controller
public class UserController {
    @RequestMapping("/addUser")
    public String showPage(Users users){
        return "add";
    }

    /**
     * 完成用户添加
     * @Valid  开启对该对象的数据校验
     * BindingResult 封装了校验的结果
     */

    @RequestMapping("/save")
    public String saveUser(@Valid Users users, BindingResult result){
        if (result.hasErrors()){
            return "add";
        }

        System.out.println(users);
        return "ok";
    }
}
