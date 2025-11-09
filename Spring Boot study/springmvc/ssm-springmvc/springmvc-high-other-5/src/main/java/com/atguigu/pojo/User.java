package com.atguigu.pojo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Past;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Data
public class User {
    //age   1 <=  age < = 150
    @Min(10)
    private int age;

    //name 3 <= name.length <= 6
    @Length(min = 3,max = 6)
    private String name;

    //email 邮箱格式
    @Email
    private String email;

    @Length(min = 6)
    private String password;

    //只能在日期上使用，检查日期是否是过去的
    @Past
    private Date birthday;
}
