package org.streamAPI.intermediate;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

//映射
//flatMap--接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
public class FlatMap {

    @Test
    public void test(){
        List<String> s1 = Arrays.asList("ab", "bcc", "wbcd", "abcde", "abcdef", "abcdefg", "ebcdefgh", "abcdefghjj", "abaaaaaaaa");
        //使用map循环遍历character需要嵌套2层foreach
        s1.stream().map(this::fromStringToCharacter).forEach( s -> s.forEach(System.out::println));
        //使用flatmap无需嵌套foreach
        s1.stream().flatMap(this::fromStringToCharacter).forEach(System.out::println);
    }

    public Stream<Character> fromStringToCharacter(String s){
        List<Character> list = new ArrayList<>();
        for (char c : s.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }
}
