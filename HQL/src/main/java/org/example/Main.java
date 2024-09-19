package org.example;

import Config.FactoryConfiguration;
import Entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        //all data from customer
        /*Query query = session.createQuery("from  Customer");
        List<Customer> customerList=query.list();
        for (Customer customer:customerList){
            System.out.println(customer.getId());
        }*/

        //unique one data from customer
       /* Query query1 = session.createQuery("from Customer where id = ?1");
        query1.setParameter(1,"1");
        Customer customer= (Customer) query1.uniqueResult();
            System.out.println(customer.getId());*/


        //load only one column
       /* Query query = session.createQuery("select id from Customer where id = ?1");
        query.setParameter(1,"1");
        Customer customer= (Customer) query.uniqueResult();
        System.out.println(customer.getId());*/



       /* Query query = session.createQuery("from Customer where id in (1,2)");
        List<Customer> customerList = query.list();
        for (Customer customer:customerList){
            System.out.println(customer.getName());
        }*/


        Query query = session.createQuery("insert into Customer values(?, ?)");
        query.setParameter(1,2);
        query.setParameter(2,"praween");
        query.executeUpdate();

        //Update
        Query query2 = session.createQuery("update Customer set name=? where id=?");
        query2.setParameter(1,"imalsha");
        query2.setParameter(2,4);
        query2.executeUpdate();





        transaction.commit();
        session.close();
    }
}