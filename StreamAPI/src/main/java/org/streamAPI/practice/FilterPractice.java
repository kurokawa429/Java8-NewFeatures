package org.streamAPI.practice;

import org.streamAPI.entity.People;
import org.streamAPI.entity.PeopleData;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterPractice {

    public static void main(String[] args) {
        List<String> s1 = Arrays.asList("ab", "bcc", "wbcd", "abcde", "abcdef", "abcdefg", "ebcdefgh", "abcdefghjj", "abaaaaaaaa");
//        1.筛选出一个字符串集合中所有长度大于等于 5 的字符串。

//        2.筛选出一个字符串集合中所有以字母 "a" 开头的字符串。

//        3.筛选出一个整数集合中所有大于 5 小于 10 的整数。
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

//        4.筛选出一个字符串数组中所有包含字母 "e" 的字符串。

//        5.筛选出一个自定义的对象集合中所有满足某种条件的对象。
        PeopleData peopleData1 = new PeopleData();
        List<People> people = peopleData1.getPeople();

    }

}
