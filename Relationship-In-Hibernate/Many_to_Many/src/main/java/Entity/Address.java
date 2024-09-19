package Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

import java.util.List;

@Entity
public class Address {

    @Id
    private int aid;

    private String no;

    private String road;

    private String city;
    @ManyToMany(mappedBy = "address")//inverse End Side
    private List<Customer> customer;

    public Address(int aid, String no, String road, String city, List<Customer> customer) {
        this.aid = aid;
        this.no = no;
        this.road = road;
        this.city = city;
        this.customer = customer;
    }

    public Address() {
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(List<Customer> customer) {
        this.customer = customer;
    }
}