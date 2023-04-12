package org.lambda;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/*
 * 一、方法引用：若Lambda体中的内容有方法已经实现了，我们可以使用“方法引用”（可以理解为方法引用时Lambda表达式的另一种表现形式）
 *
 * 主要有三种语法格式：
 * 对象::实例方法名
 * 类::静态方法名
 * 类::实例方法名
 *
 * 注意：
 * 1、Lambda体中调用方法的参数列表与返回值类型，要与函数式接口中抽象方法的函数列表和返回值类型保持一致！
 * 2、若Lambda参数列表中的第一个参数是 实例方法的调用者，而第二个参数是实例方法的参数时，可以使用ClassName::method
*/

public class MethodReference {

    //对象::实例方法名
    @Test
    public void test1(){
        PrintStream out = System.out;
        Consumer c = out::println;
        c.accept("123");

        Employee employee = new Employee();
        List<Employee> employees = employee.getEmployee();

        Supplier s = employee::getName;
        System.out.println(s.get());
    }

    //类::静态方法名
    @Test
    public void test2(){
        Comparator<Integer> c = Integer::compare;
        System.out.println(c.compare(1, 3));

        Employee employee = new Employee();
        List<Employee> employees = employee.getEmployee();
        Map<String, List<Employee>> collect = employees.stream().collect(Collectors.groupingBy(Employee::getName));
    }

    //类::实例方法名
    @Test
    public void test3(){
        BiPredicate<String,String> b = String::equals;
        System.out.println(b.test("1", "1"));
    }
}
