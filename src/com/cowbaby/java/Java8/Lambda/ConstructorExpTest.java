package com.cowbaby.java.Java8.Lambda;

import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public class ConstructorExpTest {



    @Test
    public void testConstructor(){

        Supplier<String> supplier = () -> new String("ab-ab");

        Supplier<String > supplier1 = String::new;

    }

    @Test
    public void testBiMap(){
        ConstructorExpTest.biFunctionToDo((a, b) -> {
            System.out.println("创建对象");
            return new BiMap(a, b);
        });


        ConstructorExpTest.biFunctionToDo(BiMap::new);
    }

    private static void printSupplier(Supplier<String > supplier){
        System.out.println(supplier.get());
    }

    private static void biFunctionToDo(BiFunction<Integer, String, BiMap> biFunction){
        Integer key = 12;
        String value = "Value";
        System.out.println(biFunction.apply(key, value));

    }
}


class BiMap{
    Integer key;
    String value;

    public BiMap(Integer key, String value){
        this.key = key;
        this.value = value;
    }

    public String toString(){
        return this.key + " : " + this.value;
    }
}
