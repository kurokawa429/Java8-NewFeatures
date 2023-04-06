package org.streamAPI.terminal;

import org.junit.Test;
import org.streamAPI.entity.People;
import org.streamAPI.entity.PeopleData;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

//min-返回流中最小值
public class Min {
    @Test
    public void test(){
        PeopleData peopleData = new PeopleData();
        List<People> people = peopleData.getPeople();

        Optional<People> min = people.stream().min(Comparator.comparing(People::getAge));
        System.out.println(min);
    }
}
