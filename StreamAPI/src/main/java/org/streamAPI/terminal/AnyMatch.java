package org.streamAPI.terminal;

import org.junit.Test;
import org.streamAPI.entity.People;
import org.streamAPI.entity.PeopleData;

import java.util.List;

//anyMatch-检查是否至少匹配一个元素
public class AnyMatch {
    @Test
    public void test(){
        PeopleData peopleData = new PeopleData();
        List<People> people = peopleData.getPeople();

        boolean b = people.stream().anyMatch(p -> p.getAge() > 30);
        System.out.println("是否至少有一个员工年龄大于大于30：" + b);
    }
}
