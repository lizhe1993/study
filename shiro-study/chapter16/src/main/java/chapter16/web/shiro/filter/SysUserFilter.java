package chapter16.web.shiro.filter;

import chapter16.Constants;
import chapter16.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * chapter16.web.shiro.filter.shiro-study
 * lz 创建于 2017/3/24。
 * 李哲 邮件：QUERYBYLJS@163.com
 * 描述：
 */
public class SysUserFilter extends PathMatchingFilter {

    @Autowired
    private UserService userService;

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        request.setAttribute(Constants.CURRENT_USER,userService.findByUsername(username));
        return true;
    }
}
