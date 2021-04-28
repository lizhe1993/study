package com.study.a;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ClassName: Test
 * Description:
 *
 * Date: 2019/7/23 16:33
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class Test {


    static class Animal {}

    static class Cat extends Animal {}

    static class Garfield extends Cat {}


    public static void main(String[] args) {
//        List<Animal> animals = new ArrayList<Animal>();
//        List<Cat> cats = new ArrayList<Cat>();
//        List<Garfield> garfields = new ArrayList<Garfield>();
//
//        animals.add(new Animal());
//
//        cats.add(new Cat());
//
//        garfields.add(new Garfield());
//
//
//        //List<? extends Cat> extCatFromAnimal = animals;
//        List<? super Cat> supCatFromAnimal = animals;
//
//        List<? extends Cat> extCatFromCat = cats;
//        List<? super Cat> supCatFromCat = cats;
//
//        List<? extends Cat> extCatFromGar = garfields;
//        //List<? super Cat> supCatFromGar = garfields;

//        Animal obj = new Animal();
//        Class<?> aClass = obj.getClass().getSuperclass();
//        System.out.println(aClass.isAssignableFrom(Object.class));


        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(format.format(new Date()));

    }

}
