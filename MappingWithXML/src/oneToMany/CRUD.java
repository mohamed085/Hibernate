package oneToMany;

import first.NewHibernateUtil;
import org.hibernate.Session;

public class CRUD {
    public void insertCenter() {
        Session se = NewHibernateUtil.getSessionFactory().openSession();
        try {
            se.beginTransaction();
            Center c = new Center();
            c.setCenterName("HBM");
            Courses c1 = new Courses();
            Courses c2 = new Courses();
            Courses c3 = new Courses();
            c1.setCourseName("Java");
            c2.setCourseName("C++");
            c3.setCourseName("Javascript");
            c.getCourses().add(c1);
            c.getCourses().add(c2);
            c.getCourses().add(c3);
            c1.setCenter(c);
            c3.setCenter(c);
            c2.setCenter(c);
            se.save(c1);
            se.getTransaction().commit();
        } catch (Exception e) {
        }
    }
}
