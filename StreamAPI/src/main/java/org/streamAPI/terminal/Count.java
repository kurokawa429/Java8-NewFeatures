package org.streamAPI.terminal;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

//count-返回流中元素的总个数
public class Count {

    @Test
    public void test(){
        List<String> s1 = Arrays.asList("ab", "bcc", "wbcd", "abcde", "abcdef", "abcdefg", "ebcdefgh", "abcdefghjj", "abaaaaaaaa");
        long count = s1.stream().count();
        System.out.println(count);
    }
}
