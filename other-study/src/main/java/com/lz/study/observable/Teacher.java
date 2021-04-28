package com.lz.study.observable;

import java.util.Observable;
import java.util.Observer;

/**
 * @ClassName: Teacher
 * @Description:
 * @Date: 2020/4/22 16:59
 * @History: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class Teacher implements Observer {

    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        GPer gper = (GPer) o;
        Question question = (Question) arg;
        System.out.println("==================================");
        System.out.println(name
                + "老师，你好！\n您收到一个来自“" + gper.getName()
                + "”的提问，希望您解答，问题内容如下：\n" + question.getContent()
                + "\n提问者：" + question.getUserName());

    }


    public static void main(String[] args) {
        GPer gper = GPer.getInstance();
        Teacher tom = new Teacher("Tom");
        Teacher mic = new Teacher("Mic");
        gper.addObserver(tom);
        gper.addObserver(mic);
        // 业务逻辑代码
        Question question = new Question();
        question.setUserName("小明");
        question.setContent("观察者设计模式适用于那些场景？");
        gper.publishQuestion(question);
    }
}
