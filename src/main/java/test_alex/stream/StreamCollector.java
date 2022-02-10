package test_alex.stream;

import test_alex.Person;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author luoyuntian
 * @program: p40-algorithm
 * @description: 流收集器
 * @date 2021-12-29 22:07:49
 */
public class StreamCollector {
    public static void main(String[] args) {
        List<Person> persons = StreamOperatore.persons;
        persons.stream().filter(person -> person.getAge() < 20)
                .collect(Collectors.toList());
        persons.stream()
                .collect(Collectors.groupingBy(person -> person.getGender()));

        persons.stream().collect(Collectors.partitioningBy(person -> person.getAge()>20));
    }
}
