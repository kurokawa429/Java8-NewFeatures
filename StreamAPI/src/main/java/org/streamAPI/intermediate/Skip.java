package org.streamAPI.intermediate;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
//筛选与切片  skip--跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n个，则返回一个空流。与limit(n) 互补
public class Skip {
    @Test
    public void test(){
        List<String> s1 = Arrays.asList("ab", "bcc", "wbcd", "abcde", "abcdef", "abcdefg", "ebcdefgh", "abcdefghjj", "abaaaaaaaa");
        s1.stream().skip(5).forEach(System.out::println);
    }
}
