package com.lz.shiro.study.role;

import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by lz on 2017/3/7.
 */
public class PermissionTest extends BaseTest {

    @Test
    public void testIsPermitted(){
        login("classpath:role/shiro-permission.ini","zhang","123");
        //判断拥有全新：user：create
        Assert.assertTrue(getSubject().isPermitted("user:create"));
        Assert.assertTrue(getSubject().isPermittedAll("user:update","user:delete"));
        Assert.assertFalse(getSubject().isPermitted("user:view"));
    }

    @Test(expected = UnauthorizedException.class)
    public void testCheckPermission(){
        login("classpath:role/shiro-permission.ini","zhang","123");
        getSubject().checkPermission("user:create");
        getSubject().checkPermissions("user:delete","user:update");
        getSubject().checkPermission("user:view");

    }

    @Test
    public void testWildcardPermission1() {
        login("classpath:shiro-permission.ini", "li", "123");

        getSubject().checkPermissions("system:user:update", "system:user:delete");
        getSubject().checkPermissions("system:user:update,delete");
    }

    @Test
    public void testWildcardPermission2() {
        login("classpath:shiro-permission.ini", "li", "123");
        getSubject().checkPermissions("system:user:create,delete,update:view");

        getSubject().checkPermissions("system:user:*");
        getSubject().checkPermissions("system:user");
    }

    @Test
    public void testWildcardPermission3() {
        login("classpath:shiro-permission.ini", "li", "123");
        getSubject().checkPermissions("user:view");

        getSubject().checkPermissions("system:user:view");
    }

    @Test
    public void testWildcardPermission4() {
        login("classpath:shiro-permission.ini", "li", "123");
        getSubject().checkPermissions("user:view:1");

        getSubject().checkPermissions("user:delete,update:1");
        getSubject().checkPermissions("user:update:1", "user:delete:1");

        getSubject().checkPermissions("user:update:1", "user:delete:1", "user:view:1");

        getSubject().checkPermissions("user:auth:1", "user:auth:2");

    }

    @Test
    public void testWildcardPermission5() {
        login("classpath:shiro-permission.ini", "li", "123");
        getSubject().checkPermissions("menu:view:1");

        getSubject().checkPermissions("organization");
        getSubject().checkPermissions("organization:view");
        getSubject().checkPermissions("organization:view:1");

    }


    @Test
    public void testWildcardPermission6() {
        login("classpath:shiro-permission.ini", "li", "123");
        getSubject().checkPermission("menu:view:1");
        getSubject().checkPermission(new WildcardPermission("menu:view:1"));

    }

}
