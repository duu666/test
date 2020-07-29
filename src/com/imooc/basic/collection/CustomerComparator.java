package com.imooc.basic.collection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class CustomerComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {
        if (o1.getName().compareTo(o2.getName()) > 0) return -1;
        if (o1.getName().compareTo(o2.getName()) < 0) return 1;
        return 0;
    }

    public static void main(String[] args) {
        Set<Customer> set = new TreeSet<>(new CustomerComparator());

        Customer customer1 = new Customer("tom",5);
        Customer customer2 = new Customer("tom",9);
        Customer customer3 = new Customer("tom",7);
        set.add(customer1);
        set.add(customer2);
        set.add(customer3);
        Iterator<Customer> it = set.iterator();
        while (it.hasNext()) {
            Customer customer = it.next();
            System.out.println(customer.getName() + " " +customer.getAge());
        }
    }
}
