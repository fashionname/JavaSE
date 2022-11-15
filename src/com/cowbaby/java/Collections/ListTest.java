package com.cowbaby.java.Collections;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ListTest {


    @Test
    public void testArrayList(){
        List<Integer> list = Arrays.asList(Integer.valueOf(12), 13, 25, 8);

        list.sort((a, b) -> a - b);

        System.out.println(list);
    }
}
