package org.lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


/**
 * Java8中引入了一个新的操作符"->" 该操作符称为箭头操作符或Lambda操作符，箭头操作符将Lambda表达式拆分成两部分：
 * 左侧：Lambda 表达式的参数列表                   -> 其实就是接口中抽象方法的形参列表
 * 右侧：Lambda 表达式中所需执行的功能，即 Lambda 体  -> 其实就是重写的抽象方法的方法体
 */
public class LambdaBasicSyntax {
    /* 语法格式一：无参数，无返回值
    常用接口：1. Runnable 接口。它定义了一个单独的无参方法 run()，用于在一个单独的执行线程中执行某些操作或任务。
    */
    @Test
    public void test1(){
        Runnable r1 = () -> System.out.println("Runnable 接口。它定义了一个单独的无参方法 run()，用于在一个单独的执行线程中执行某些操作或任务。");
         r1.run();
    }

    /* 语法格式二：Lambda需要一个参数，但是无返回值
    常用接口：1. Consumer 接口：表示一个接受单个输入参数并且不返回任何结果的操作。它定义了一个单独的方法 accept(Object obj)。
            2. BiConsumer<T, U> 接口：表示一个接受两个输入参数并且不返回任何结果的操作。它定义了一个单独的方法 accept(T t, U u)，用于接受两个输入参数。
    */
    @Test
    public void test2(){
        Consumer c1 = s -> System.out.println(s + "Consumer 接口：表示一个接受单个输入参数并且不返回任何结果的操作。它定义了一个单独的方法 accept(Object obj)。");
        c1.accept(1);
        BiConsumer c2 = (o1 ,o2) -> System.out.println(o1 +"-"+ o2);
        c2.accept(1,2);
    }

    /* 语法格式三：Lambda需要多个参数，可以有返回值
    常用接口：1. Comparator 接口。定义了比较两个对象的顺序的方法，接受两个类型相同的对象作为输入，并返回一个整数值，表示它们之间的顺序。
            2. Function<T, R>：接受一个类型为 T 的参数，返回类型为 R 的结果。
            3. Operator<T>：接受一个类型为 T 的参数，返回同类型的结果。
            4. Predicate<T>：接受一个类型为 T 的参数，返回一个 boolean 类型的结果。
    */
    @Test
    public void test3(){
        Comparator<Integer> c1 = (o1 , o2) -> Integer.compare(o1,o2);
        int compare = c1.compare(1, 4);
        System.out.println(compare);

        Function<Integer,String> f1 = (i) -> Integer.toString(i);
        String apply = f1.apply(2);
        System.out.println(apply);

        Predicate p1 = s -> s.equals("1");
        boolean test = p1.test(1);
        System.out.println(test);
    }
}
