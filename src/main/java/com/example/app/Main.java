package com.example.app;

import com.example.collections.CollectionUtils;
import com.example.collections.predicates.FilterPredicate;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Пример использования фильтрации
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers = CollectionUtils.filter(numbers, n -> n % 2 == 0);
        System.out.println("Even numbers: " + evenNumbers);

        // Пример с пользовательскими объектами
        List<Person> people = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 20),
                new Person("David", 35)
        );

        // Фильтрация по возрасту
        List<Person> youngPeople = CollectionUtils.filter(people, p -> p.getAge() < 30);
        System.out.println("Young people: " + youngPeople);

        // Сортировка по имени
        List<Person> sortedByName = CollectionUtils.sort(people, Comparator.comparing(Person::getName));
        System.out.println("Sorted by name: " + sortedByName);

        // Поиск самого старого
        Person oldest = CollectionUtils.max(people, Comparator.comparing(Person::getAge));
        System.out.println("Oldest person: " + oldest);

        // Разбиение на группы
        List<List<Person>> groups = CollectionUtils.partition(people, 2);
        System.out.println("Groups of 2:");
        groups.forEach(System.out::println);
    }

    @Data
    @AllArgsConstructor
    static class Person {
        private String name;
        private int age;
    }
}