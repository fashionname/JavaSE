package com.cowbaby.java.Generic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {


    @Test
    public void testUpperWildCard(){

        List<String> list = new ArrayList<String>();

        list.add("abc");

        List<? extends String> list1 = list;

        List<? super String> list2 = list;

        String str = list1.get(0);

        String str1 = (String) list2.get(0);

        // list1.add("abc");

        list2.add("abc");


    }
}
