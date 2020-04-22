package com.lz.study.proxy;

/**
 * @ClassName: Customer
 * @Description:
 * @Author: LiZhe lizhej@enn.cn
 * @Date: 2020/4/21 17:19
 * @History: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class Customer implements Person {
    @Override
    public void findLove() {
        System.out.println("高富帅");
        System.out.println("身高180cm");
        System.out.println("有6块腹肌");
    }
}
