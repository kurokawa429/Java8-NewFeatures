package org.streamAPI.intermediate;

import org.junit.Test;
import org.streamAPI.entity.People;
import org.streamAPI.entity.PeopleData;

import java.util.List;

//映射
//map--接收Lambda，将元素转换成其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新元素。
public class Map {
    @Test
    public void test(){
        PeopleData peopleData = new PeopleData();
        List<People> people = peopleData.getPeople();

        //获取姓名长度等于3的员工姓名
        people.stream().map(People::getName).filter(p -> p.length() == 3).forEach(System.out::println);}
}
