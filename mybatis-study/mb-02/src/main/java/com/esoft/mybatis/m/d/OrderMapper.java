package com.esoft.mybatis.m.d;

import com.esoft.mybatis.m.Order;

/**
 * 类mybaits-study注释说明:
 * <p></p>
 *
 * @author ${user}-QUERYBYLJS@163.com 金鼎科技
 * @version 6.0.0 ${date}
 */
public interface OrderMapper {

    public Order selectOrderByUserId(Integer id);

    public Order selectOrderById(Integer id);
}
