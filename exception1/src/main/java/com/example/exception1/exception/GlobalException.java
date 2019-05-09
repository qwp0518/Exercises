//package com.example.exception1.exception;
//
//
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.servlet.ModelAndView;
//
///**
// * 全局异常处理类
// */
//@ControllerAdvice
//public class GlobalException {
//
//    /**
//     * java.lang.ArithmeticException
//     * @param e 会将产生的对象注入到方法中
//     * @return ModelAndView 目的是可以封装异常信息和视图的指定
//     */
//    @ExceptionHandler(value = {java.lang.ArithmeticException.class})
//    public ModelAndView exceptionHandler(Exception e){
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("error",e.toString());
//        mv.setViewName("error1");
//        return mv;
//    }
//
//    @ExceptionHandler(value = {java.lang.NullPointerException.class})
//    public ModelAndView exceptionHandler1(Exception e){
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("error",e.toString());
//        mv.setViewName("error2");
//        return mv;
//    }
//}
