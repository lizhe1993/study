package com.lz.study.observable;

import java.util.Observable;

/**
 * @ClassName: GPer
 * @Description:
 * @Author: LiZhe lizhej@enn.cn
 * @Date: 2020/4/22 16:55
 * @History: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class GPer extends Observable {

    private String name = "GPer 生态圈";
    private static GPer gper = null;

    public static GPer getInstance() {
        if (gper == null) {
            gper = new GPer();
        }
        return gper;
    }

    public String getName() {
        return name;
    }

    public void publishQuestion(Question question) {
        System.out.println(question.getUserName() + "在" + this.name + "上提交了一个问题");
        setChanged();
        notifyObservers(question);
    }
}
