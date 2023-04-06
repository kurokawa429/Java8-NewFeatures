package org.streamAPI.intermediate;

import org.junit.Test;
import org.streamAPI.entity.People;
import org.streamAPI.entity.PeopleData;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//排序
//sorted()-自然排序（按照对象类实现Comparable接口的compareTo()方法 排序）
public class Sorted {

    @Test
    public void test(){
        List<Integer> list  = Arrays.asList(5,1,77,1,-99,500,45,99);
        list.stream().sorted().forEach(System.out::println);
    }

    @Test
    public void test2(){
        PeopleData peopleData = new PeopleData();
        List<People> people = peopleData.getPeople();
        //方法引用
        people.stream().sorted(Comparator.comparing(People::getAge)).forEach(System.out::println);
        //Lambda表达式
        people.stream().sorted( (e1 ,e2 ) ->
                                 Integer.compare(e1.getAge(),e2.getAge())
        ).forEach(System.out::println);

    }
}
