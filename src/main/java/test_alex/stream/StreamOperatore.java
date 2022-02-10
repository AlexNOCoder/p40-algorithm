package test_alex.stream;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableList;
import test_alex.Person;

import java.util.*;

/**
 * @author luoyuntian
 * @program: p40-algorithm
 * @description: 演示流的各种操作
 * @date 2021-12-29 21:14:57
 */
public class StreamOperatore {
    static List<Person> persons = ImmutableList.of(
            new Person(1,"Tom",17,"男"),
            new Person(2,"Alex",18,"男"),
            new Person(3,"Liz",19,"女"),
            new Person(4,"rola",22,"女"),
            new Person(5,"rola1",22,"女"),
            new Person(6,"rola1",22,"女")
    );

    public static void main(String[] args) {
//        persons.stream().flatMap(person -> Arrays.stream(person.getPersonName().split("")))
//                .forEach(item -> System.out.println(
//                        JSON.toJSONString(item,true)
//                ));

//        persons.stream().sorted(Comparator.comparing(Person::getAge))
//                .skip(2).forEach(
//                        item -> System.out.println(JSON.toJSONString(item,true))
//        );
//
//        boolean match = persons.stream().peek(person -> System.out.println(JSON.toJSONString(person,true))).allMatch(person -> person.getAge() < 20);
//        boolean nonMatch = persons.stream().noneMatch(person -> person.getAge()>10_00);
//        System.out.println(nonMatch);
        Optional<Person> first = persons.stream().findFirst();
        OptionalInt intMax = persons.stream().mapToInt(Person::getAge).max();
        System.out.println(intMax.getAsInt());
    }
}
