package org.streamAPI.entity;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class PeopleData {

    public List<People> getPeople(){
        return Stream.of(new People("jack",18,new Cat("小花",1)) ,
                new People("tom",23,new Cat("大猫",3)),
                new People("卢本伟",31,new Cat("pdd",10)))
                .collect(Collectors.toList());
    }
}
