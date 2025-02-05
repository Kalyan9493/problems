package org.example.streamproblems.complexproblems;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ComplexProblems {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 30, 60000),
                new Employee("Bob", 25, 50000),
                new Employee("Charlie", 35, 70000),
                new Employee("David", 28, 45000),
                new Employee("Eve", 40, 80000)
        );

/*
1. Custom Object Filtering and Transformation:
Given a list of Employee objects (with fields like name, age, and salary),
filter out employees with a salary below a certain threshold and
return a list of names of the remaining employees sorted by age.
 */
        employees.stream()
                .sorted(Comparator.comparingInt(Employee::getAge))
                .filter(emp -> emp.getSalary() > 50000)
                .map(Employee::getName)
                .forEach(System.out::println);



/*
2. Finding the Most Frequent Element: Given a list of integers,
use streams to find the most frequently occurring number.
If there are ties, return the smallest number.
 */
        List<Integer> integers = Arrays.asList(
                5, 3, 8, 5, 2, 3, 5, 1, 8, 2, 3, 3, 9, 2, 5, 1
        );
        integers.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .ifPresent(k -> System.out.println(k.getKey() + ":" + k.getValue()));

/*
3. Nested Stream Operations:
Given a list of Order objects (with fields like orderId, customerId, and items where items is
a list of Item objects), calculate the total revenue generated by all orders for a specific customer.
 */



        ArrayList<Order> orders = new ArrayList<>(Arrays.asList(
                new Order("O001", "C001", Arrays.asList(new Item("Laptop", 1200.00), new Item("Mouse", 25.00))),
                new Order("O002", "C002", Arrays.asList(new Item("Phone", 800.00), new Item("Charger", 20.00))),
                new Order("O003", "C001", Arrays.asList(new Item("Tablet", 400.00), new Item("Headphones", 50.00))),
                new Order("O004", "C003", Arrays.asList(new Item("Monitor", 300.00), new Item("Keyboard", 50.00)))
        ));

        String customerId = "C001";
        double totalRevenue = orders.stream()
                .filter(order -> order.getCustomerId().equals(customerId))
                .mapToDouble(order -> order.getItems().stream().mapToDouble(Item::getPrice).sum())
                .sum();

        System.out.println("Total Revenue : " + totalRevenue);


/*
4. find the longest word in the list of strings
 */
        List<String> words = Arrays.asList("stream", "java", "parallel", "concurrency");
        String longestWord = words.stream().max(Comparator.comparingInt(String::length)).get();
        System.out.println("Longest Word : " + longestWord);



/*
5. find the first non-repeating character from the string
 */
        String input = "swiss";

        Character nonRepeatingCharacter = input.chars()
                .mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(map -> map.getValue() == 1)
                .findFirst().get().getKey();

        System.out.println("First Non Repeated Character : " + nonRepeatingCharacter);

/*

 */
    }
}




