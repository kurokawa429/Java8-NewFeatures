package org.streamAPI.terminal;

import org.junit.Test;
import org.streamAPI.entity.People;
import org.streamAPI.entity.PeopleData;

import java.util.List;
import java.util.Optional;

//findAny-返回当前流中的任意元素
public class FindAny {
    @Test
    public void test(){
        PeopleData peopleData = new PeopleData();
        List<People> people = peopleData.getPeople();

        Optional<People> any = people.stream().findAny();
        System.out.println(any);
    }
}
