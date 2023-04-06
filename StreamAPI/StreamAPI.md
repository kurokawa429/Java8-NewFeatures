# StreamAPI



## **1.什么是 Stream**？

是数据渠道，用于操作数据源（集合、数组等）所生成的元素序列。“集合讲的是数据，流讲的是计算！ ”

注意：
①Stream 自己不会存储元素。
②Stream 不会改变源对象。相反，他们会返回一个持有结果的新Stream。
③Stream 操作是延迟执行的。这意味着他们会等到需要结果的时候才执行。



## 2.**Stream的操作三步骤**

- 创建Stream
  一个数据源（如：集合、数组），获取一个流
- 中间操作
  一个中间操作链，对数据源的数据进行处理
- 终止操作（终端操作）
  一个终止操作，执行中间操作链，并产生结果



### **2.1.创建Stream**

##### 1. 集合创建

通过Collection 系列集合提供的stream()或parallelStream()方法

default Stream< E> stream() : 返回一个顺序流
default Stream< E> parallelStream() : 返回一个并行流

##### 2. 数组创建

通过 Arrays 中的静态方法stream()获取数组流

static < T> Stream< T> stream(T[] array): 返回一个流
重载形式，能够处理对应基本类型的数组：

public static IntStream stream(int[] array)
public static LongStream stream(long[] array)
public static DoubleStream stream(double[] array)

##### 3. Stream类创建

通过Stream 类中的静态方法of()，通过显示值创建一个流。它可以接收任意数量的参数。

public static< T> Stream< T> of(T… values) : 返回一个流

##### 4. 无限流创建

创建无限流

可以使用静态方法 Stream.iterate() 和Stream.generate(), 创建无限流。

迭代
public static< T> Stream< T> iterate(final T seed, final UnaryOperator< T> f)
生成
public static< T> Stream< T> generate(Supplier< T> s)

```java
//创建Stream
@Test
public void test1(){
    //1.可以通过Collection 系列集合提供的stream()或parallelStream()
    List<String> list = new ArrayList<>();
    Stream<String> stream1 = list.stream();

    //2.通过 Arrays 中的静态方法stream()获取数组流
    Employee[] emps=new Employee[10];
    Stream<Employee> stream2=Arrays.stream(emps);

    //3.通过Stream 类中的静态方法of()
    Stream<String> stream3=Stream.of("aa","bb","cc");

    //4.创建无限流
    //迭代
    Stream<Integer> stream4=Stream.iterate(0, (x) -> x+2);
    stream4.limit(10).forEach(System.out::println);

    //生成
    Stream.generate(() -> Math.random())
        .limit(5)
        .forEach(System.out::println);
}
```

### 2.2 中间操作

##### 1. 筛选与切片

```markdown
 *  filter--接收Lambda，从流中排除某些元素。
 *  limit--截断流，使其元素不超过给定数量。
 *  skip(n)--跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n个，则返回一个空流。与limit(n) 互补
 *  distinct--筛选，通过流所生成元素的 hashCode() 和 equals() 去掉重复元素
```
###### 1.1 filter

```markdown
filter()方法是Stream中的一种中间操作，用于筛选出满足指定条件的元素。filter()方法接收一个Predicate参数，该参数是一个函数式接口，用于测试每个元素是否满足条件。在执行filter()方法后，只有满足条件的元素会被保留，而不满足条件的元素会被过滤掉。
```

````java
@Test
public void test1(){
    //中间操作：不会执行任何操作
    Stream<Employee> stream=employees.stream()
        .filter((e) -> e.getAge()>35 );
    //终止操作：一次性执行全部内容，即 惰性求值
    stream.forEach(System.out::println);
}
````

###### 1.2 limit

````markdown
limit()方法是Stream中的一种中间操作，可以用来限制Stream的元素数量。它接受一个long类型的参数n，表示限制Stream中元素的数量不超过n个。当Stream中元素数量达到n个时，limit()方法就会停止处理元素并返回一个新的Stream。
````

````java
Stream<Integer> stream = Stream.iterate(0, x -> x+2);
stream.limit(10).forEach(System.out::println);
````

###### 1.3 skip(n)

```markdown
skip()方法是Stream中的一种中间操作，可以用来跳过Stream的前n个元素。它接受一个long类型的参数n，表示跳过Stream中的前n个元素。当Stream中的元素数量不足n个时，skip()方法会返回一个空Stream。
```

````java
@Test
public void test(){
    List<String> s1 = Arrays.asList("ab", "bcc", "wbcd", "abcde", "abcdef", "abcdefg", "ebcdefgh", 	                               "abcdefghjj", "abaaaaaaaa");
    s1.stream().skip(5).forEach(System.out::println);
}
````

###### 1.4 distinct

````markdown
distinct()方法是Stream中的一种中间操作，可以用来去除Stream中的重复元素。它不接受任何参数，只是根据元素的hashCode()和equals()方法来判断元素是否重复。在去除重复元素后，distinct()方法返回一个新的Stream。
````

````java
@Test
public void test(){
    List<String> s1 = Arrays.asList("ab", "bcc", "wbcd", "abcde", "abcdef", "abcdefg",
                                    "ebcdefgh", "abcdefghjj", "abaaaaaaaa","1","1","2","2");
    s1.stream().skip(5).distinct().forEach(System.out::println);
}
````

##### 2.映射

###### 2.1 map

````markdown
map()方法是Stream中的一种中间操作，可以用来将Stream中的每个元素转换为另一个元素。它接受一个Function类型的参数，表示将Stream中的每个元素应用到该函数中，产生一个新的元素。最终map()方法返回一个新的Stream，其中包含由Function返回的新元素。
````

````java
@Test
public void test(){
    PeopleData peopleData = new PeopleData();
    List<People> people = peopleData.getPeople();

    //获取姓名长度等于3的员工姓名
    people.stream().map(People::getName).filter(p -> p.length() == 3).forEach(System.out::println);}
}
````

###### 2.2 *flatMap*

````markdown
flatMap()方法是Stream中的一种中间操作，可以用来将Stream中的每个元素转换为多个元素，并将它们合并成一个新的Stream。它接受一个Function类型的参数，表示将Stream中的每个元素应用到该函数中，产生一个新的Stream，最终将所有的Stream合并成一个新的Stream。
````

````java
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
````

*map和flatMap的关系  类似于 List数组当中的 add(Object)和addAll(Collection coll)*

##### 3.排序

###### 3.1 *sorted*

````markdown
sorted()方法是Stream中的一种中间操作，可以用来对Stream中的元素进行排序。它可以接受一个Comparator类型的参数，表示如何比较元素。如果没有传递Comparator，则默认使用元素的自然顺序进行排序。
````

````java
//自然排序
@Test
public void test(){
    List<Integer> list  = Arrays.asList(5,1,77,1,-99,500,45,99);
    list.stream().sorted().forEach(System.out::println);
}
````

````java
//定制排序
@Test
public void test2(){
    PeopleData peopleData = new PeopleData();
    List<People> people = peopleData.getPeople();
    //方法引用
    people.stream().sorted(Comparator.comparing(People::getAge)).forEach(System.out::println);
    //Lambda表达式
    people.stream().sorted( (e1 ,e2 ) ->
                           Integer.compare(e1.getAge(),e2.getAge())
                          ).forEach(System.out::println);

}
````

### 2.3 终止操作

##### 1. 查找与匹配

###### 1.1 allMatch

````markdown
allMatch()方法是Stream中的一种终端操作，可以用来判断Stream中的所有元素是否都满足某个条件。它接受一个Predicate类型的参数，表示判断条件。如果Stream中的所有元素都满足该条件，则返回true，否则返回false。
````

````java
@Test
public void test(){
    PeopleData peopleData = new PeopleData();
    List<People> people = peopleData.getPeople();

    boolean b = people.stream().allMatch(p -> p.getAge() > 17);
    System.out.println("是否所有员工年龄都大于17：" + b);

}
````

###### 2.2 anyMatch

````markdown
anyMatch()方法是Stream中的一种终端操作，可以用来判断Stream中是否有任意一个元素满足某个条件。它接受一个Predicate类型的参数，表示判断条件。如果Stream中的任意一个元素满足该条件，则返回true，否则返回false。
````

````java
@Test
public void test(){
    PeopleData peopleData = new PeopleData();
    List<People> people = peopleData.getPeople();

    boolean b = people.stream().anyMatch(p -> p.getAge() > 30);
    System.out.println("是否至少有一个员工年龄大于大于30：" + b);
}
````

###### 2.3 *noneMatch*

````markdown
noneMatch()方法是Stream中的一种终端操作，可以用来判断Stream中是否所有元素都不满足某个条件。它接受一个Predicate类型的参数，表示判断条件。如果Stream中的所有元素都不满足该条件，则返回true，否则返回false。
````

````java
@Test
public void test(){
    PeopleData peopleData = new PeopleData();
    List<People> people = peopleData.getPeople();

    boolean b = people.stream().noneMatch(p -> p.getAge() > 55);
    System.out.println("是否至没有员工年龄大于大于55：" + b);
}
````

###### 2.4 *findFirst*

````markdown
findFirst()方法是Stream中的一种终端操作，可以用来查找Stream中的第一个元素。它返回一个Optional类型的对象，如果Stream为空，则返回一个空的Optional对象，否则返回一个包含第一个元素的Optional对象。
````

````java
@Test
public void test(){
    PeopleData peopleData = new PeopleData();
    List<People> people = peopleData.getPeople();

    Optional<People> first = people.stream().findFirst();
    System.out.println(first);
}
````

###### 2.5 findAny

````markdown
findAny()方法是Stream中的一种终端操作，可以用来查找Stream中的任意一个元素。它返回一个Optional类型的对象，如果Stream为空，则返回一个空的Optional对象，否则返回一个包含任意一个元素的Optional对象。
````

````java
@Test
public void test(){
    PeopleData peopleData = new PeopleData();
    List<People> people = peopleData.getPeople();

    Optional<People> any = people.stream().findAny();
    System.out.println(any);
}
````

###### 2.6 *count*

````markdown
count()方法是Stream中的一种终端操作，可以用来计算Stream中元素的数量。它返回一个long类型的值，表示Stream中元素的数量。
````

````java
@Test
public void test(){
    List<String> s1 = Arrays.asList("ab", "bcc", "wbcd", "abcde", "abcdef", "abcdefg", "ebcdefgh",                                               "abcdefghjj", "abaaaaaaaa");
    long count = s1.stream().count();
    System.out.println(count);
}
````

###### 2.7 *max*

````markdown
max()方法是Stream中的一种终端操作，可以用来查找Stream中的最大元素。它使用一个Comparator对象来确定元素的顺序，返回一个Optional类型的对象，如果Stream为空，则返回一个空的Optional对象，否则返回一个包含最大元素的Optional对象。
````

````java
@Test
public void test(){
    PeopleData peopleData = new PeopleData();
    List<People> people = peopleData.getPeople();

    Optional<People> max = people.stream().max(Comparator.comparing(People::getAge));
    System.out.println(max);
}
````

###### 2.8 min

````markdown
min()方法是Stream中的一种终端操作，可以用来查找Stream中的最小元素。它使用一个Comparator对象来确定元素的顺序，返回一个Optional类型的对象，如果Stream为空，则返回一个空的Optional对象，否则返回一个包含最小元素的Optional对象。
````

````java
@Test
public void test(){
    PeopleData peopleData = new PeopleData();
    List<People> people = peopleData.getPeople();

    Optional<People> min = people.stream().min(Comparator.comparing(People::getAge));
    System.out.println(min);
}
````

##### 2. 规约

2.1 reduce

````markdown
reduce()方法有多个重载形式，其中最简单的一种形式是：
T reduce(T identity, BinaryOperator<T> accumulator)
该方法接收两个参数：identity和accumulator。其中，identity是起始值，accumulator是一个二元运算符，用于将两个元素组合成一个元素。reduce()方法从左到右依次对Stream中的每个元素调用accumulator，并将上次调用的结果作为下次调用的第一个参数。
````

````java
    @Test
    public void test(){
        List<Integer> list  = Arrays.asList(5,1,77,1,-99,500,45,99);
        Integer reduce = list.stream().reduce(0, Integer::sum);
        System.out.println(reduce);
    }

    @Test
    public void tes2t(){
        PeopleData peopleData = new PeopleData();
        List<People> people = peopleData.getPeople();
        //得到people中所有人的年龄之和
        Optional<Integer> ageSum = people.stream().map(People::getAge).reduce(Integer::sum);
        System.out.println(ageSum);
    }
````

##### 3. 收集

###### 3.1 *collect*

````markdown
collect()方法是一个终止操作，它有多个重载形式，其中最常用的一种形式是：
<R, A> R collect(Collector<? super T, A, R> collector)
该方法接收一个Collector对象作为参数，Collector接口定义了将Stream中的元素累积到一个可变的容器中的操作，具有以下四个方法：

supplier()：用于创建一个新的容器。
accumulator()：用于将Stream中的元素添加到容器中。
combiner()：用于将两个容器合并为一个。
finisher()：用于对容器进行最终的转换。

使用Collector接口，我们可以方便地将Stream中的元素收集到列表、集合、Map、字符串等数据结构中。
````

````java
@Test
public void test(){
    PeopleData peopleData = new PeopleData();
    List<People> people = peopleData.getPeople();

    //找到年龄大于20岁的人，并返回一个新的List
    people.stream().filter(p -> p.getAge() > 20).collect(Collectors.toList()).forEach(System.out::println);
}
````

###### 3.2 Collectors类

````markdown
toList()：将Stream中的元素收集到一个List中。

toSet()：将Stream中的元素收集到一个Set中。

toMap()：将Stream中的元素收集到一个Map中。该方法接收两个参数，一个keyMapper函数用于生成Map的key，一个valueMapper函数用于生成Map的value。

joining()：将Stream中的元素连接成一个字符串。该方法有多个重载形式，可以指定分隔符、前缀和后缀等。

averagingInt()：计算Stream中元素的平均值，并将结果封装为Double对象。

counting()：统计Stream中元素的个数。

maxBy()：根据指定的比较器，从Stream中选择最大的元素。

minBy()：根据指定的比较器，从Stream中选择最小的元素。

partitioningBy()：将Stream中的元素根据指定的条件分成两个部分，true的一部分和false的一部分。返回一个Map对象，其中键是Boolean类型，值是Stream中元素的List。

groupingBy()：将Stream中的元素根据指定的条件分组。返回一个Map对象，其中键是分组的条件，值是Stream中元素的List。

summarizingInt()：计算Stream中元素的汇总信息，包括元素个数、总和、最大值、最小值和平均值。

mapping()：将Stream中的元素通过指定的映射函数转换为新的类型，然后将转换后的元素收集到一个集合中。

reducing()：根据指定的累加器函数，将Stream中的元素进行累积计算。
````

