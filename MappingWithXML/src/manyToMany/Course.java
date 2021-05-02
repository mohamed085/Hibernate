package manyToMany;

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
public class Course {
    private int id;
    private String CourseName;
    private List<Centerr> centerr;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String CourseName) {
        this.CourseName = CourseName;
    }

    @ManyToMany(cascade = CascadeType.ALL, targetEntity = Course.class)
    @JoinTable(name = "Cen_Cou", 
            joinColumns = {@JoinColumn(name = "co_id")},
            inverseJoinColumns = {@JoinColumn(name = "ce_id")})
    public List<Centerr> getCenterr() {
        return centerr;
    }

    public void setCenterr(List<Centerr> centerr) {
        this.centerr = centerr;
    }
    
}
