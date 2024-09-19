package Entity;

import Config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();


//select
        Query query = session.createQuery("select c from Customer c");
        List<Customer> customers = query.list();
        for (Customer customer : customers) {
            System.out.println(customer);

            //update,
        Query query1 = session.createQuery("update Customer c set c.name = :name where c.id = :id");
        query1.setParameter("name", "Nimal");
        query1.setParameter("id", 1);
        query1.executeUpdate();

            transaction.commit();
            session.close();
        }
    }
}

