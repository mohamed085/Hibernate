package manyToMany;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Centerr {
    private int id;
    private String centerName;
    private List<Course> Courses = new ArrayList<>();

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

    @ManyToMany(cascade = CascadeType.ALL, targetEntity = Course.class)
    @JoinTable(name = "Cen_Cou", 
            joinColumns = {@JoinColumn(name = "ce_id")},
            inverseJoinColumns = {@JoinColumn(name = "co_id")})
    public List<Course> getCourses() {
        return Courses;
    }

    public void setCourses(List<Course> Courses) {
        this.Courses = Courses;
    }
    

    
}
