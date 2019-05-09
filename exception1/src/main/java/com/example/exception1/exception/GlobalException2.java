//package com.example.exception1.exception;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
//
//import java.util.Properties;
//
///**
// * 通过SimpleMappingExceptionResolver来处理全局异常
// */
//@Configuration
//public class GlobalException2 {
//
//    /**
//     * 该方法必须有返回值，且返回值必须为SimpleMappingExceptionResolver
//     * 无法传递异常信息
//     */
//    @Bean
//    public SimpleMappingExceptionResolver getSimpleMappingExceptionResolver(){
//        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
//        Properties properties = new Properties();
//        properties.setProperty("java.lang.ArithmeticException","error1");
//        properties.setProperty("java.lang.NullPointerException","error2");
//        resolver.setExceptionMappings(properties);
//
//        return resolver;
//    }
//}
