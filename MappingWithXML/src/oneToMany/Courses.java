package oneToMany;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.ManyToAny;

@Entity
public class Courses {
    private int id;
    private String CourseName;
    private Center center;
    
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
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ce_id")
    public Center getCenter() {
        return center;
    }

    public void setCenter(Center center) {
        this.center = center;
    }


    
}
