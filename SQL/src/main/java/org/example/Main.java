package org.example;

import Config.FactoryConfiguration;
import Entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.List;


public class Main {
    public static void main(String[] args) {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        NativeQuery query=session.createNativeQuery("select * from customer");
        //insert,update,delete,SearchBy
        query.addEntity(Customer.class);
        List<Customer> customerList=query.list();
        for (Customer customer:customerList){
            System.out.println(customer);
        }

        //insert
        NativeQuery  query1 = session.createNativeQuery("insert into customer values(?1,?2)");
        query1.setParameter(1,2);
        query1.setParameter(2,"praween");
        query1.executeUpdate();


        //update,
       NativeQuery query2 = session.createNativeQuery("update customer set name=? where id=?");
        query2.setParameter(1,"kamal");
        query2.setParameter(2,2);
        query2.executeUpdate();

        // delete
        NativeQuery query3 = session.createNativeQuery("delete from customer where cid=?1");
        query3.setParameter(1,2);
        query3.executeUpdate();

        //searchByName
        NativeQuery query4 = session.createNativeQuery("select * from customer where name=?1");
        query4.addEntity(Customer.class);
        query4.setParameter(1,"praween");
        Customer customer = (Customer) query4.uniqueResult();
        System.out.println(customer);
        transaction.commit();
        session.close();
    }
}