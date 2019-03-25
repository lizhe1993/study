package com.lz.shiro.study.role;

import org.apache.shiro.authz.UnauthorizedException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by lz on 2017/3/3.
 */
public class RoleTest extends BaseTest {

    @Test
    public void testHasRole(){
        login("classpath:role/shiro-role.ini","zhang","123");

        Assert.assertTrue(getSubject().hasRole("role1"));
        Assert.assertTrue(getSubject().hasAllRoles(Arrays.asList("role1","role2")));
        boolean[] result= getSubject().hasRoles(Arrays.asList("role1","role2","role3"));
        Assert.assertEquals(true, result[0]);
        Assert.assertEquals(true, result[1]);
        Assert.assertEquals(false, result[2]);
    }


    @Test(expected = UnauthorizedException.class)
    public void testCheckRole(){
        login("classpath:role/shiro-role.ini","zhang","123");
        getSubject().checkRole("role1");
        getSubject().checkRoles("role1", "role3");
    }


}
