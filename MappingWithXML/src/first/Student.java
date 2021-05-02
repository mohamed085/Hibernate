package first;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
    private String name;
    private Compke  compke;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    public Compke getCompke() {
        return compke;
    }

    public void setCompke(Compke compke) {
        this.compke = compke;
    }
    
    
    
}
