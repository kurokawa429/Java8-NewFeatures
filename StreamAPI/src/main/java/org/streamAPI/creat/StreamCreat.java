package org.streamAPI.creat;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamCreat {
    @Test
    public void test1(){
        //可以通过Collection 系列集合提供的stream()或parallelStream()方法  ->  通过集合创建
        List<String> list = Arrays.asList("a", "b", "c", "d", "e");

        //1. 创建顺序流
        Stream<String> stream = list.stream();
        //2. 创建并行流
        Stream<String> parallelStream = list.parallelStream();
    }
    @Test
    public void test2(){
        //通过 Arrays 中的静态方法stream()获取数组流  ->  通过数组创建
        int[] arr = new int[]{1,2,3,4,5};
        Double[] arrs = new Double[]{1.1,2.2,3.3,4.4,5.5};

        IntStream stream = Arrays.stream(arr);
        Stream<Double> stream1 = Arrays.stream(arrs);
    }
    @Test
    public void test3(){
        //通过Stream 类中的静态方法of()，通过显示值创建一个流。它可以接收任意数量的参数  ->  通过任意参数创建
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4);
        Stream<String> stringStream = Stream.of("a", "b", "c");

    }
    @Test
    public void test4(){
        //可以使用静态方法 Stream.iterate() 和Stream.generate(), 创建无限流。
        //迭代
        Stream<Integer> stream = Stream.iterate(0, x -> x+2);
        stream.limit(10).forEach(System.out::println);
        //生成
        Stream.generate(() -> Math.random())
                .limit(5)
                .forEach(System.out::println);
    }
}
