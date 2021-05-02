package oneToMany;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Center {
    private int id;
    private String centerName;
    private List<Courses> Courses = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Courses.class, mappedBy = "center")
//    @JoinTable(name = "cen_cou", joinColumns = {@JoinColumn(name = "ce_id")}, inverseJoinColumns = {@JoinColumn(name = "co_id")})
    public List<Courses> getCourses() {
        return Courses;
    }

    public void setCourses(List<Courses> Courses) {
        this.Courses = Courses;
    }
    
    
    
}
