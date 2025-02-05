package org.example.streamproblems.easyproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EasyProblems {

    public static void main(String[] args) {
        /*
            1. Filtering Even Numbers: Given a list of integers,
            use streams to filter out the even numbers and return a new list.
         */
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,3,4,8,7,6,9,0,1,12,14,13,11));
        numbers.stream().filter(num -> num%2==0).forEach(System.out::println);


    }
}
