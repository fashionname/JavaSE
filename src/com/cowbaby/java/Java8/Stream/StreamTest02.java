package com.cowbaby.java.Java8.Stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest02 {

    /*
        Stream 终止操作

        // 返回boolean
        allMatch  anyMatch  noneMatch

        // 返回 Optional<myObj>
        findFirst findAny

        // max min 需要比较器Comparator 或者 自然排序
        count  max min

        forEach


        归约操作
            reduce(T identity, BinaryOperator)

        收集操作
            // 将流转换成其他形式
            collect(Collector c)

            // 另外Collectors 提供了很多静态方法
            Collectors.toList
            Collectors.toSet

            .toCollection(ArrayList::new)

            .counting
            .summingInt
            .averagingInt
            .summarizingInt
     */


    @Test
    public void testReduce(){

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < 100; i++){
            list.add(i);
        }

        list.stream().reduce(0, Integer::sum);

        /*
            List<Employee> list = new ArrayList<>();

            Stream<Integer> stream = list.stream().map(Employee::getSalary)

            stream.reduce(Integer::sum)

         */
    }

    @Test
    public void testCollect(){

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < 100; i++){
            list.add(i);
        }

        List<Integer> collect = list.stream().limit(10).collect(Collectors.toList());

        System.out.println(collect);
    }

}
