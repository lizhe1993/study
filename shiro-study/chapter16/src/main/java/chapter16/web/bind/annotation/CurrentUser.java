package chapter16.web.bind.annotation;

import chapter16.Constants;

import java.lang.annotation.*;

/**
 * chapter16.web.bind.annotation.shiro-study
 * lz 创建于 2017/3/24。
 * 李哲 邮件：QUERYBYLJS@163.com
 * 描述：
 */
@Target({ElementType.PACKAGE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrentUser {

    /**
     * 当前用户在request中的名字
     *
     * @return
     */
    String value() default Constants.CURRENT_USER;
}
