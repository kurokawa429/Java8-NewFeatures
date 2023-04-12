# Lambda表达式



## **1.什么是 Lambda表达式**？

Lambda表达式是JDK1.8之后的一种语法，是一个**匿名函数**。

本质上是：**函数式接口的实现类**



## 2.**Lambda表达式语法**

Java8中引入了一个新的操作符"`->`" 该操作符称为箭头操作符或Lambda操作符，箭头操作符将Lambda表达式拆分成两部分：
左侧：Lambda 表达式的**参数列表**
右侧：Lambda 表达式中所需执行的功能，即 **Lambda 体**



##### 1. 语法格式一：无参数，无返回值

```markdown
常用接口：
1. Runnable 接口。它定义了一个单独的无参方法 run()，用于在一个单独的执行线程中执行某些操作或任务。
```

````java
@Test
public void test1(){
    Runnable r1 = () -> System.out.println("Runnable 接口。它定义了一个单独的无参方法 run()，用于在一个单独的执行线程											中执行某些操作或任务。");
    r1.run();
}
````



##### 2. 语法格式二：Lambda需要一个参数，但是无返回值

```markdown
常用接口：
1. Consumer 接口：表示一个接受单个输入参数并且不返回任何结果的操作。它定义了一个单独的方法 accept(Object obj)。
2. BiConsumer<T, U> 接口：表示一个接受两个输入参数并且不返回任何结果的操作。它定义了一个单独的方法 accept(T t, U u)，用于接    受两个输入参数。
```

````java
@Test
public void test2(){
    Consumer c1 = s -> System.out.println(s + "Consumer 接口：表示一个接受单个输入参数并且不返回任何结果的操作。它定义											  了一个单独的方法 accept(Object obj)。");
    c1.accept(1);
    BiConsumer c2 = (o1 ,o2) -> System.out.println(o1 +"-"+ o2);
    c2.accept(1,2);
}
````



##### 3. 语法格式三：Lambda需要多个参数，可以有返回值

```markdown
常用接口：
1. Comparator 接口。定义了比较两个对象的顺序的方法，接受两个类型相同的对象作为输入，并返回一个整数值，表示它们之间的顺序。
2. Function<T, R>：接受一个类型为 T 的参数，返回类型为 R 的结果。
3. Operator<T>：接受一个类型为 T 的参数，返回同类型的结果。
4. Predicate<T>：接受一个类型为 T 的参数，返回一个 boolean 类型的结果。
```

````java
@Test
public void test3(){
    Comparator<Integer> c1 = (o1 , o2) -> Integer.compare(o1,o2);
    int compare = c1.compare(1, 4);
    System.out.println(compare);

    Function<Integer,String> f1 = (i) -> Integer.toString(i);
    String apply = f1.apply(2);
    System.out.println(apply);

    Predicate p1 = s -> s.equals("1");
    boolean test = p1.test(1);
    System.out.println(test);
}
````

### 2.2 函数式接口

只包含一个抽象方法的接口，称为 **函数式接口**。

我们可以在任意函数式接口上使用 @FunctionalInterface 注解，这样做可以检查它是否是一个函数式接口，同时 javadoc 也会包含一条声明，说明这个接口是一个函数式接口。

````java
@FunctionalInterface
public interface Supplier<T> {

    /**
     * Gets a result.
     *
     * @return a result
     */
    T get();
}
````

### 2.3 方法引用和构造器引用

##### 1. *方法引用*

````markdown
若Lambda体中的内容有方法已经实现了，我们可以使用“方法引用”（可以理解为方法引用时Lambda表达式的另一种表现形式）
要有三种语法格式：
对象::实例方法名
类::静态方法名
类::实例方法名

 注意：
 1、Lambda体中调用方法的参数列表与返回值类型，要与函数式接口中抽象方法的函数列表和返回值类型保持一致！
2、若Lambda参数列表中的第一个参数是 实例方法的调用者，而第二个参数是实例方法的参数时，可以使用ClassName::method
````

##### 2. *构造器引用*

````markdown
格式：
ClassName::new

注意：需要调用的构造器的参数列表要与函数式接口中抽象方法的参数列表保持一致！
````

##### 3. *数组引用*

````java
public class TestMethodRef { 
	
	//对象::实例方法名
	@Test
	public void test1(){
		PrintStream ps1=System.out;
		Consumer<String> con=(x)->ps1.println(x);//生成了一个实现了Consumer接口的类的对象
		
		PrintStream ps=System.out;
		Consumer<String> con1=ps::println;//相当于上面，引用了ps对象的println()方法
		
		Consumer<String> con2=System.out::println;
		con2.accept("abcdef");
	}
	
	@Test
	public void test2(){
		final Employee emp=new Employee();
		Supplier<String> sup=()->emp.getName();//代替匿名内部类
		String str=sup.get();
		System.out.println(str);
		
		Supplier<Integer> sup2=emp::getAge;
		Integer num=sup2.get();
		System.out.println(num);
	}
	
	//类::静态方法名
	@Test
	public void test3(){
		Comparator<Integer> com=(x,y)->Integer.compare(x,y);
		Comparator<Integer> com1=Integer::compare;
	}
	
	//类::实例方法名
	@Test
	public void test4(){
		BiPredicate<String,String> bp=(x,y)->x.equals(y);
		BiPredicate<String, String> bp2=String::equals;
	}
	
	
	//构造器引用
	@Test
	public void test5(){
		Supplier<Employee> sup=()->new Employee();
		
		//构造器引用方式
		Supplier<Employee> sup2=Employee::new;//使用无参构造器
		Employee emp=sup2.get();
		System.out.println(emp);
		
		Function<Integer,Employee> fun2=(x)->new Employee(x);
		Employee emp2=fun2.apply(101);
		System.out.println(emp2);
		
		BiFunction<String,Integer,Employee> bf=Employee::new;
	}
	
	//数组引用
	@Test
	public void test6(){
		Function<Integer,String[]> fun=(x)->new String[x];
		String[] strs=fun.apply(10);
		System.out.println(strs.length);
	
		Function<Integer,String[]> fun2=String[]::new;
		String[] str2=fun2.apply(20);
		System.out.println(str2.length);
	}
}
````
