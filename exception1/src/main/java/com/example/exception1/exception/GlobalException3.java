package com.example.exception1.exception;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 通过实现HandlerExceptionResolver接口来处理全局异常
 */
@Configuration
public class GlobalException3 implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView mv = new ModelAndView();
        //判断不同异常类型来跳转相应页面
        if (e instanceof ArithmeticException){
            mv.setViewName("error1");
        }
        if (e instanceof NullPointerException){
            mv.setViewName("error2");
        }
        mv.addObject("error",e.toString());
        return mv;
    }
}
