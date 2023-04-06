package org.streamAPI.intermediate;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

//筛选与切片  distinct--筛选，通过流所生成元素的 hashCode() 和 equals() 去掉重复元素
public class Distinct {

    @Test
    public void test(){
        List<String> s1 = Arrays.asList("ab", "bcc", "wbcd", "abcde", "abcdef", "abcdefg",
                "ebcdefgh", "abcdefghjj", "abaaaaaaaa","1","1","2","2");
        s1.stream().skip(5).distinct().forEach(System.out::println);
    }
}
