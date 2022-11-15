package com.cowbaby.java.Java8.Lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class MethodExpTest {


    @Test
    public void testMethodExp(){

        printLog(new MethodExpTest()::printLog, System.out::println);
    }


    @Test
    public void testGetIntegerList(){
        List<Integer> list = getIntegerList(Arrays.asList(10, 20, 100), (id) -> id <= 100);

        System.out.println(list);
    }

    @Test
    public void testCompare(){
        int a = 12;
        int b = 56;

        Integer.valueOf(a).compareTo(b);

        sortBi(a, b, Integer::compareTo);

    }

    @Test
    public void testSum(){
        sum((a, b, c) -> {
            System.out.println(a + b + c);
        });

    }

    @Test
    public void judgeEqual(){
        String a = "io";
        String b = "nio";

        BiConsumer<String, String>  biConsumer = (c, d) -> {
            System.out.println("a + b");
        };

        BiConsumer<Integer, Integer> biConsumer1 = Integer::equals;

        Function<IDCard, Integer> function = IDCard::getId;

    }
    private static void sum(MultiFunction<Integer, Integer, Integer> multiFunction){
        multiFunction.sum(Integer.valueOf(12), Integer.valueOf(23), Integer.valueOf(15));

    }
    private static void printLog(PrintFunction printFunction, Consumer<String> consumer){
        printFunction.print();

        consumer.accept("print...log");
    }


    public void printLog(){
        System.out.println("print...");
    }


    public static List<Integer> getIntegerList(List<Integer> list, Predicate<Integer> predicate){
        List<Integer> filterList = new ArrayList<>();
        if(list != null && list.size() != 0){
            for(Integer id: list){
                if(predicate.test(id)){
                    filterList.add(id);
                }
            }
        }
        return filterList;
    }

    public static void sortBi(Integer a, Integer b, Comparator<Integer> comparator){
        System.out.println(comparator.compare(a, b));
    }
}

@FunctionalInterface
interface PrintFunction{
    void print();
}

@FunctionalInterface
interface MultiFunction<T, R, U>{
    void sum(T t, R r, U u);
}


class Val{
    Integer value;

    public void judgeEquals(Integer otherValue){
        value.equals(otherValue);
    }
}

class IDCard{
    Integer id = 12;

    Integer getId(){
        return this.id;
    }
}

