package org.streamAPI.intermediate;

import org.junit.Test;
import org.streamAPI.entity.People;
import org.streamAPI.entity.PeopleData;

import java.util.List;
//筛选与切片  filter--接收Lambda，从流中排除某些元素。
public class Filter {

    @Test
    public void test(){
        PeopleData peopleData = new PeopleData();
        List<People> people = peopleData.getPeople();

        people.stream().filter(p -> p.getAge() < 25).forEach(System.out::println);
    }
}
