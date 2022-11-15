package com.cowbaby.java.Java8.Stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest01 {

    /*
        Stream 和 Collection 区别

            Stream用于计算 不会改变源对象 操作延迟执行
            分三步:
                创建Stream 中间操作 终止操作

     */


    @Test
    public void getStream(){

        List<Integer> list = Arrays.asList(12, 56, 78, 102);

        // 方式1
            // 顺序流
            Stream<Integer> stream = list.stream();

            // 并行流
            Stream<Integer> stream1 = list.parallelStream();

        // 方式2
            IntStream stream2 = Arrays.stream(new int[]{1, 2, 3});


        // 方式3
            Stream<Integer> stream3 = Stream.of(1, 4, 10);

        // 方式4 创建无限流

            Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);

            Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }

    @Test
    public void testMidOperate(){
        List<Integer> list = new ArrayList<>();

        /*
            中间操作
                filter limit skip distinct map flatMap mapToInt mapToDouble mapToLong

                sort | sorted
         */
        for(int i = 0; i < 100; i++){
            list.add(i);
        }

        Stream<Integer> stream = list.stream();

        // stream.filter((num) -> num >= 10 && num <= 20).forEach(System.out::println);

        // stream.limit(10);

        // stream.distinct();

        /*
            stream.skip(20).map((val) -> {
                if(val % 2 == 0){
                    return val;
                }else{
                    return 1;
                }
            }).forEach(System.out::println);
        */

        /*

            flatMap 扁平化 [[],[]] -> [,,,,]

         */


        // <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper);

        /*

            T -> R

            Function<<? super T>, Stream<? extends R>>
            -> <? extends Stream<? extends R>>

         */

        List<String> list2 = Arrays.asList("abc", "def");

        list2.stream().flatMap(StreamTest01::generateStream).forEach(System.out::println);


    }

    @Test
    public void testMidSortOperate(){
        Stream<Character> stream = StreamTest01.generateStream("eqdadsasd");

        // 注意 自然排序 要实现 Comparable 接口
        stream.sorted((a, b) -> b - a).forEach(System.out::println);
    }

    private static Stream<Character> generateStream(String str){
        List<Character> characters = new ArrayList<>();
        for(int i = 0; i < str.length(); i++){
            characters.add(str.charAt(i));
        }

        return characters.stream();
    }
}





