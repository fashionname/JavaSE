package com.cowbaby.java.Util;

import com.cowbaby.java.Reflect.Human;

import java.util.Objects;

public class User implements Human {


    private String name = "张三";

    private int age = 23;

    private String pwd = "52556";


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        if (!Objects.equals(name, user.name)) return false;
        return Objects.equals(pwd, user.pwd);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + (pwd != null ? pwd.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    @Override
    public void doSome() {
        System.out.println("我是human - user");
    }

    @Override
    public void otherDo() {
        System.out.println("other do");
    }


}


