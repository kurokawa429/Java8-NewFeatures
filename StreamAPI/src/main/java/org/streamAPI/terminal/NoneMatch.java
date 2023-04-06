package org.streamAPI.terminal;

import org.junit.Test;
import org.streamAPI.entity.People;
import org.streamAPI.entity.PeopleData;

import java.util.List;

//noneMatch-检查是否没有匹配所有元素
public class NoneMatch {
    @Test
    public void test(){
        PeopleData peopleData = new PeopleData();
        List<People> people = peopleData.getPeople();

        boolean b = people.stream().noneMatch(p -> p.getAge() > 55);
        System.out.println("是否至没有员工年龄大于大于55：" + b);
    }
}
