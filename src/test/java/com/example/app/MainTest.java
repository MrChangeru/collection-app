package com.example.app;

import com.example.collections.CollectionUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testPersonOperations() {
        List<Main.Person> people = Arrays.asList(
                new Main.Person("Alice", 25),
                new Main.Person("Bob", 30),
                new Main.Person("Charlie", 20)
        );

        // Тест фильтрации
        List<Main.Person> young = CollectionUtils.filter(people, p -> p.getAge() < 30);
        assertEquals(2, young.size());
        assertTrue(young.stream().allMatch(p -> p.getAge() < 30));

        // Тест сортировки
        List<Main.Person> sorted = CollectionUtils.sort(people, Comparator.comparing(Main.Person::getName));
        assertEquals("Alice", sorted.get(0).getName());
        assertEquals("Bob", sorted.get(1).getName());
        assertEquals("Charlie", sorted.get(2).getName());

        // Тест поиска максимального
        Main.Person oldest = CollectionUtils.max(people, Comparator.comparing(Main.Person::getAge));
        assertEquals("Bob", oldest.getName());
    }
}