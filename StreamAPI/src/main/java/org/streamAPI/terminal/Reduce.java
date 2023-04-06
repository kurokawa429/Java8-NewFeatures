package org.streamAPI.terminal;

import org.junit.Test;
import org.streamAPI.entity.People;
import org.streamAPI.entity.PeopleData;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//归约
//reduce(T identity,BinaryOperator b) / reduce(BinaryOperator b)-可以将流中元素反复结合起来，得到一个值。
public class Reduce {
    @Test
    public void test(){
        List<Integer> list  = Arrays.asList(5,1,77,1,-99,500,45,99);
        Integer reduce = list.stream().reduce(0, Integer::sum);
        System.out.println(reduce);
    }

    @Test
    public void tes2t(){
        PeopleData peopleData = new PeopleData();
        List<People> people = peopleData.getPeople();
        //得到people中所有人的年龄之和
        Optional<Integer> ageSum = people.stream().map(People::getAge).reduce(Integer::sum);
        System.out.println(ageSum);
    }
}
