package com.imooc.basic.collection;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Customer implements Comparable {

    private String  name;

    private int age;

    public Customer(String name,int age) {
        this.age=age;
        this.name=name;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return age == customer.age &&
                Objects.equals(name, customer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(Object o) {
        Customer other = (Customer) o;

        //先按照name属性排序
        if (this.name.compareTo(other.getName()) > 0)
            return 1;
        if (this.name.compareTo(other.getName()) < 0)
            return -1;

        //在按照age属性排序
        if (this.age > other.getAge())
            return 1;
        if (this.age < other.getAge())
            return -1;
        return 0;
    }

    public static void main(String[] args) {
        Set<Customer> set = new TreeSet<>();
        Customer customer1 = new Customer("tom",16);
        Customer customer2 = new Customer("tom",15);
        set.add(customer1);
        set.add(customer2);
        for (Customer c:set) {
            System.out.println(c.name + " " + c.age);
        }
    }
}
