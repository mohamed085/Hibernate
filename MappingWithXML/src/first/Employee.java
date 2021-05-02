package first;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
public class Employee{
    private int id;
    private String name;
    private Address address;
    private Address addressHome;
    private List<Address> addresses = new ArrayList<>();


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @Embedded
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "state", column = @Column(name = "homeState")),
            @AttributeOverride(name = "city", column = @Column(name = "homeCity")),    
            @AttributeOverride(name = "street", column = @Column(name = "homeStreet"))
    })
    public Address getAddressHome() {
        return addressHome;
    }

    public void setAddressHome(Address addressHome) {
        this.addressHome = addressHome;
    }

    @ElementCollection
    @JoinTable(name = "ad_em", joinColumns = @JoinColumn(name = "em_ad_id"))
    @GenericGenerator(name = "increment", strategy = "increment")
    @CollectionId(columns = {@Column(name = "id")}, generator = "increment", type = @Type(type = "int"))
    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
    
    
    
    
}
