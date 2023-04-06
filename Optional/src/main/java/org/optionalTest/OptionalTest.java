package org.optionalTest;


import org.junit.Test;
import java.util.Optional;


public class OptionalTest {

    @Test
    public void test(){
//      Optional.of(T t) : 创建一个 Optional 实例(不能为null)
        Boy boy = new Boy();
        boy.setName("张三");
        Optional<Boy> boy1 = Optional.of(boy);
        Optional<String> optional = Optional.of("Hello");

//      Optional.empty() : 创建一个空的 Optional 实例
        Optional<Object> empty = Optional.empty();

//      Optional.ofNullable(T t):若 t 不为 null,创建 Optional 实例,否则创建空实例
        boy = null;
        Optional<Boy> boy2 = Optional.ofNullable(boy);

//      isPresent() : 判断是否包含值
        System.out.println(boy1.isPresent());
        System.out.println(boy2.isPresent());
//      orElse(T t) : 如果调用对象包含值，返回该值，否则返回t
        System.out.println(boy1.orElse(null));
        System.out.println(boy2.orElse(null));

//      orElseGet(Supplier s) :如果调用对象包含值，返回该值，否则返回 s 获取的值
        System.out.println(boy1.orElseGet(() -> new Boy("tom")));
        System.out.println(boy2.orElseGet(() -> new Boy("tom")));

//      map(Function f): 如果有值对其处理，并返回处理后的Optional，否则返回 Optional.empty()
        Optional<String> s = boy1.map(Boy::getName);
        System.out.println(s);
        Optional<String> s2 = boy2.map(Boy::getName);
        System.out.println(s2);
//      flatMap(Function mapper):与 map 类似，要求返回值必须是Optional
    }
}
