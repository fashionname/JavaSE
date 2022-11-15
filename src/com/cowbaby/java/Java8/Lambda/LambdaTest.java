package com.cowbaby.java.Java8.Lambda;

import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaTest {

    private static LambdaTest lambdaTest = new LambdaTest();

    public void setFunInterface(Consumer<String> consumer, Supplier<Integer> supplier,
                                 Function<String, Integer> function, Predicate<Integer> integerPredicate){

        String product = "消费产品";

        consumer.accept(product);

        supplier.get();

        Integer id = function.apply("传入T返回R");

        integerPredicate.test(id);
    }


    @Test
    public void getFunInterface(){
        Consumer<String> consumer = (str) -> {
            System.out.println("Consumer:  ( get:  " + str + " ) ");
        };

        Supplier<Integer> supplier = () ->{
            Integer id = Integer.valueOf("2022");
            System.out.println("Supplier: ( return: " + id + " ) ");
            return id;
        };

        Function<String, Integer> function = (str) -> {
            Integer id = Integer.valueOf("2023");
            System.out.println("Function: (get: " + str + " ) " + "( return: " + id + " ) ");
            return id;
        };

        Predicate<Integer> predicate = (id) -> Integer.valueOf(2023).equals(id);

        lambdaTest.setFunInterface(consumer, supplier, function, predicate);

    }
}
