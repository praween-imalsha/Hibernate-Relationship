package Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {

    @Id
    private int id;
    private String name;
    @OneToMany(mappedBy = "customer")//inverse End Side
   // @ManyToMany(fetch = FetchType.EAGER)
    private List<Address> address;

    public Customer(int id, String name, List<Address> address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

}
