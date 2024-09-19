package org.example;

import Config.FactoryConfiguration;

import Entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class Main {
    public static void main(String[] args) {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Customer customer =session.get(Customer.class,1);
        System.out.println(customer.getId());
        System.out.println(customer.getAddress());


        transaction.commit();
        session.close();
    }
}