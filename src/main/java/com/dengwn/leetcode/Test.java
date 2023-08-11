package com.dengwn.leetcode;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: dengwn
 * @date: 2023-06-21
 **/
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Person person117 = new Person(1, 1, "数学", 50, 7);
        Person person127 = new Person(1, 1, "英语", 40, 7);
        Person person137 = new Person(1, 2, "语文", 30, 7);
        Person person217 = new Person(2, 3, "数学", 90, 7);
        Person person126 = new Person(1, 2, "英语", 80, 6);

        List<Person> people = Arrays.asList(person117, person127, person137, person126, person217);

        int[][][] table = new int[10][10][10];

        for (Person person : people) {
            table[person.cla][person.time][person.id] += person.score;
        }

        System.out.println(Arrays.deepToString(table));

    }

}

@AllArgsConstructor
@NoArgsConstructor
class Person {
    int id;
    int cla;
    String name;
    int score;
    int time;
}
