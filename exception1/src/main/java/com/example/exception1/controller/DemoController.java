package com.example.exception1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * SpringBoot处理异常方式一：自定义错误页面
 */
@Controller
public class DemoController {
    @RequestMapping("/show")
    public String showInfo(){
        String str = null;
        str.length();
        return "index";
    }

    @RequestMapping("/show2")
    public String showInfo2(){
        int a = 10 / 0;
        return "index";
    }

    /**
     * java.lang.ArithmeticException
     * @param e 会将产生的对象注入到方法中
     * @return ModelAndView 目的是可以封装异常信息和视图的指定
     */
    @ExceptionHandler(value = {java.lang.ArithmeticException.class})
    public ModelAndView exceptionHandler(Exception e){
        ModelAndView mv = new ModelAndView();
        mv.addObject("error",e.toString());
        mv.setViewName("error1");
        return mv;
    }
}
