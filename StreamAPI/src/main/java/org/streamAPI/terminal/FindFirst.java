package org.streamAPI.terminal;

import org.junit.Test;
import org.streamAPI.entity.People;
import org.streamAPI.entity.PeopleData;

import java.util.List;
import java.util.Optional;

//findFirst-返回第一个元素//Optional是Java8中避免空指针异常的容器类
public class FindFirst {

    @Test
    public void test(){
        PeopleData peopleData = new PeopleData();
        List<People> people = peopleData.getPeople();

        Optional<People> first = people.stream().findFirst();
        System.out.println(first);
    }
}
