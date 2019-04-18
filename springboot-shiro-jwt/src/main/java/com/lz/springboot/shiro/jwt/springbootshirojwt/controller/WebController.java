package com.lz.springboot.shiro.jwt.springbootshirojwt.controller;

import com.lz.springboot.shiro.jwt.springbootshirojwt.base.JsonResponse;
import com.lz.springboot.shiro.jwt.springbootshirojwt.base.JsonResponseBuilder;
import com.lz.springboot.shiro.jwt.springbootshirojwt.exception.UnauthorizedException;
import com.lz.springboot.shiro.jwt.springbootshirojwt.model.User;
import com.lz.springboot.shiro.jwt.springbootshirojwt.service.UserService;
import com.lz.springboot.shiro.jwt.springbootshirojwt.util.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName: WebController
 * Description:
 * Author: LiZhe lizhej@enn.cn
 * Date: 2019/4/16 16:44
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@RestController
@Slf4j
public class WebController {

    //用户service
    @Autowired
    private UserService userService;

    /**
     * 登入
     *
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/login")
    public JsonResponse login(@RequestParam("username") String username, @RequestParam("password") String password) {
        User user = userService.getUserByName(username);
        if (user.getPassword().equals(password)) {
            return JsonResponseBuilder.success("Login success", JWTUtils.sign(username, password));
        } else {
            throw new UnauthorizedException();
        }
    }

    /**
     * 所有人都可以访问，但是用户与游客看到的内容不同
     *
     * @return
     */
    @GetMapping("/article")
    public JsonResponse article() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            return JsonResponseBuilder.success("You are already logged in");
        } else {
            return JsonResponseBuilder.success("You are guest");
        }
    }

    /**
     * 登入的用户才可以进行访问
     *
     * @return
     */
    @GetMapping("/require_auth")
    @RequiresAuthentication
    public JsonResponse requireAuth() {
        return JsonResponseBuilder.success("You are authenticated");
    }

    /**
     * admin的角色用户才可以登入
     *
     * @return
     */
    @GetMapping("/require_role")
    @RequiresRoles("admin")
    public JsonResponse requireRole() {
        return JsonResponseBuilder.success("You are visiting require_role");
    }

    /**
     * 拥有view和edit权限的用户才可以访问
     *
     * @return
     */
    @GetMapping("/require_permission")
    @RequiresPermissions(logical = Logical.AND, value = {"view", "edit"})
    public JsonResponse requirePermission() {
        return JsonResponseBuilder.success("You are visiting permission require edit,view");
    }

    @RequestMapping(path = "/401")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public JsonResponse unauthorized() {
        return JsonResponseBuilder.create(HttpStatus.UNAUTHORIZED, "Unauthorized", null);
    }


}
