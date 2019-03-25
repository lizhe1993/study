package com.lz.shiro.study.chapter6.service;

import com.lz.shiro.study.chapter6.BaseTest;
import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

/**
 * Created by lz on 2017/3/10.
 */
public class ServiceTest extends BaseTest {


    @Test
    public void testUserRolePerissionRelation(){
        //zhang
        Set<String> roles = userService.findRoles(u1.getUsername());
        Assert.assertEquals(1,roles.size());
        Assert.assertTrue(roles.contains(r1.getRole()));

        Set<String> permission = userService.findPermissions(u1.getUsername());
        Assert.assertEquals(3,permission.size());
        Assert.assertTrue(permission.contains(p3.getPermission()));

        //li
        roles = userService.findRoles(u2.getUsername());
        Assert.assertEquals(0,roles.size());
        permission = userService.findPermissions(u2.getUsername());
        Assert.assertEquals(0,permission.size());

        //解除 admin-menu:update
        roleService.uncorrelationPermissions(r1.getId(),p3.getId());
        permission = userService.findPermissions(u1.getUsername());
        Assert.assertEquals(2,permission.size());
        Assert.assertFalse(permission.contains(p3.getPermission()));

        //删除一个permission
        permissionService.deletePermission(p2.getId());
        permission = userService.findPermissions(u1.getUsername());
        Assert.assertEquals(1,permission.size());

        //解除zhang-admin关联
        userService.uncorrelationRoles(u1.getId(),r1.getId());
        roles = userService.findRoles(u1.getUsername());
        Assert.assertEquals(0,roles.size());
    }
}
