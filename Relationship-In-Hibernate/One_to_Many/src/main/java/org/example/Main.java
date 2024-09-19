package org.example;

import Config.FactoryConfiguration;
import Entity.Address;
import Entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {



        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction= session.beginTransaction();

        Address address1=new Address();
        address1.setAid(1);
        address1.setNo("283/6");
        address1.setRoad("Thanthirimulla");
        address1.setCity("Panadura");

        Address address2=new Address();
        address2.setAid(2);
        address2.setNo("283/6");
        address2.setRoad("Thanthirimulla");
        address2.setCity("Panadura");


        List<Address> addresses=new ArrayList<>();
        addresses.add(address1);
        addresses.add(address2);

        Customer customer=new Customer();
        customer.setId(1);
        customer.setName("praween");
        customer.setAddress(addresses);


        session.save(address1);
        session.save(address2);
        session.save(customer);

        transaction.commit();
        session.close();

    }
}