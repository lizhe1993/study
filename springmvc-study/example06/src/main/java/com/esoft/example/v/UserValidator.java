package com.esoft.example.v;

import com.esoft.example.m.User;
import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * 类springmvc注释说明:
 * <p></p>
 *
 * @author ${user}-QUERYBYLJS@163.com 金鼎科技
 * @version 6.0.0 ${date}
 */
@Repository("userValidator")
public class UserValidator implements Validator {

    public boolean supports(Class<?> aClass) {
        return User.class.isAssignableFrom(aClass);
    }

    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors,"username",null,"登陆账号不可以为空");
        ValidationUtils.rejectIfEmpty(errors,"password",null,"登陆密码不可以为空");

        User user = (User) o;
        if(user.getUsername().length()>10){
            errors.rejectValue("username",null,"用户名不能超过10个字符");
        }
        if(user.getPassword()!=null && !user.getPassword().equals("") && user.getPassword().length()<6){
            errors.rejectValue("password",null,"密码不能小于6位");
        }

    }
}
