package org.streamAPI.intermediate;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
//筛选与切片  limit--截断流，使其元素不超过给定数量。
public class Limit {
    @Test
    public void test(){
        List<String> s1 = Arrays.asList("ab", "bcc", "wbcd", "abcde", "abcdef", "abcdefg", "ebcdefgh", "abcdefghjj", "abaaaaaaaa");
        s1.stream().limit(5).forEach(System.out::println);
    }
}
