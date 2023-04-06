package org.streamAPI.terminal;

import org.junit.Test;
import org.streamAPI.entity.People;
import org.streamAPI.entity.PeopleData;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//收集
//collect-将流转换为其他形式，接收一个Collector接口的实现，用于给Stream中元素做汇总的方法。
public class Collect {

    @Test
    public void test(){
        PeopleData peopleData = new PeopleData();
        List<People> people = peopleData.getPeople();

        //找到年龄大于20岁的人，并返回一个新的List
        people.stream().filter(p -> p.getAge() > 20).collect(Collectors.toList()).forEach(System.out::println);
    }
}
