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
        Customer customer1=new Customer();
        customer1.setId(1);
        customer1.setName("praween");

        Customer customer2=new Customer();
        customer2.setId(2);
        customer2.setName("imalsha");

        Address address1=new Address();
        address1.setAid(1);
        address1.setNo("287");
        address1.setRoad("panadura");
        address1.setCity("kaluthara");

        Address address2=new Address();
        address2.setAid(2);
        address2.setNo("287");
        address2.setRoad("panadura");
        address2.setCity("kaluthara");

        List<Customer> customerList=new ArrayList<>();
        customerList.add(customer1);
        customerList.add(customer2);

        List<Address> addressList=new ArrayList<>();
        addressList.add(address1);
        addressList.add(address2);

        customer1.setAddress(addressList);
        customer2.setAddress(addressList);

        address1.setCustomer(customerList);
        address2.setCustomer(customerList);

        session.save(address1);
        session.save(address2);
        session.save(customer1);
        session.save(customer2);

        transaction.commit();
        session.close();
    }
}