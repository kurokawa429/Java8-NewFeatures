package org.streamAPI.terminal;

import org.junit.Test;
import org.streamAPI.entity.People;
import org.streamAPI.entity.PeopleData;

import java.util.List;
//allMatch-检查是否匹配所有元素
public class AllMatch {
    @Test
    public void test(){
        PeopleData peopleData = new PeopleData();
        List<People> people = peopleData.getPeople();

        boolean b = people.stream().allMatch(p -> p.getAge() > 17);
        System.out.println("是否所有员工年龄都大于17：" + b);

    }
}
