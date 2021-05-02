package first;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class NewStudent {
    private NewBook b;
    private int id;
    private String name;

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

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public NewBook getB() {
        return b;
    }

    public void setB(NewBook b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "NewStudent{" + "b=" + b + ", id=" + id + ", name=" + name + '}';
    }
    
    
}
