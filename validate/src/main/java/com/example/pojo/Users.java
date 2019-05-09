package com.example.pojo;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


/**
 * 其他校验规则：
 * @NotBlank:判断字符串是否为null或者空串（去掉首尾空格）
 * @NotEmpty：判断字符串是否为null或者空串
 * @Length：判断字符串的长度（最大或者最小）
 * @Email:判断邮箱是否合法
 * @Min：设置数值的最小值
 * @Max：设置数值的最大值
 *
 *
 */
public class Users {
    @NotBlank(message = "用户名不能为空") //非空校验
    @Length(min = 2,max = 6)
    private String name;
    @NotBlank(message = "用户密码不能为空")
    private String password;
    @Min(value = 15)
    private Integer age;
    @Email
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Users{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
