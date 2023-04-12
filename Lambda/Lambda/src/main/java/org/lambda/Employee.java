package org.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Employee {
    private String name;
    private Integer age;
    private Double salary;

    public List<Employee> getEmployee(){
        return Stream.of(new Employee("tom", 23, 500d), new Employee("jack", 35, 5050d),
                new Employee("卢本伟", 17, 55550d)).collect(Collectors.toList());
    }
}
