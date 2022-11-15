package com.cowbaby.java.Java9;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Java9Test {

    /*
        新特性
            模块化系统 jshell命令

            多版本兼容jar包

            接口的私有方法
            钻石操作符(泛形)的升级版
            语法改进 try语句

            String存储结构变更
            便利的集合特性 of
            增强Stream API
            全新的HTTP客户端 API
            Deprecated API

            javadoc HTML5支持
            js引擎升级 Nashorn （11 去除）
            java动态编译器

     */

    /*

        java之前 无论怎么加载 rt.jar 臃肿
        每一个公开类都会被访问到
     */


    /*

        module-info.java
            module xxx{
                requires junit; // junit 是模块
            }

         另一个module
            module xxx{
                exports com.atguigu.bean
            }

     */


    /*
       交互式编程环境 REPL(Read Evaluate Print Loop)
       像 Python Scala

       jSHell 在命令行直接运行 并保存结果

       输入jShell

       /jShell /help /edit 没有受检异常 /edit

    */


    /*
        接口 私有方法

        在 默认方法 和 静态方法基础之上
     */


    @Test
    public void testDiamondOperator(){
        // 8以前不可以 <>
        // Comparator<Object> com = new Comparator<>(){}
    }

    @Test
    public void testTry(){
        /*
            InputStreamReader reader = new InputSteamReader(System.in)
            ...(System.out)

            try(reader;writer){}


            try(InputStreamReader reader = new InputStreamReader(System.in)){
                char[] buf = new char[16];
                int len;
                StringBuilder sb = new StringBuilder();
                while((len = reader.read(buf) != -1)){
                    String str = new String(buf, 0, len);
                    sb.append(str);
                }

            } catch(IOException e){
                e.printStackTrace();
            }

         */
    }

    @Test
    public void testChar(){
        /*
            String 底层 从 char 变成 byte

            包括StringBuilder StringBuffer
         */
    }


    @Test
    public void testOnlyReadCollection(){

        /*
            创建只读集合

         */

        // java8 Arrays.asList() 也是只读集合
        List<Integer> list = Collections.unmodifiableList(new ArrayList<>());

        // error list.add("123");

        // java9 List.of() 也是只读 Set.of()

    }

    @Test
    public void testInputStream(){

        // transferTo 将输入流数据传输到输出流
        /*
            ClassLoader c1 = this.getClass().getClassLoader();
            try(InputStream is = c1.getResourceAsStream("hello.txt")){
              OutputStream os = new FileOutputStream("src\\hello1.txt");
              is.transferTo(os);
            }
        */
    }

    @Test
    public void testEnhancedAPI(){
        /*
            takewhile   从开头开始 按照制定规则返回尽可能多的元素

            dropWhile   同上 丢弃

            ofNullable 可以放一个null // stream 放入一个null值报错

            iterate // 迭代 iterate(0, x -> x + 1) 原先
            // iterate(0, x -> x < 100, x -> x + 1) 类似 for循环

            此外 Optional 和 Stream 结合得到改进 Optional新方法 stream() 将Optional对象转换成Stream对象

         */
    }



}
