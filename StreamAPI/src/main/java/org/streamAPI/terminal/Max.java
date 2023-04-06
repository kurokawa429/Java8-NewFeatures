package org.streamAPI.terminal;

import org.junit.Test;
import org.streamAPI.entity.People;
import org.streamAPI.entity.PeopleData;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

//max-返回流中最大值
public class Max {

    @Test
    public void test(){
        PeopleData peopleData = new PeopleData();
        List<People> people = peopleData.getPeople();

        Optional<People> max = people.stream().max(Comparator.comparing(People::getAge));
        System.out.println(max);
    }
}
