package manyToMany;

import first.NewHibernateUtil;
import org.hibernate.Session;

public class CRUD {
        public void insertCenter() {
        Session se = NewHibernateUtil.getSessionFactory().openSession();
        try {
            se.beginTransaction();
            System.out.println("A");
            Centerr ce1 = new Centerr();
            Centerr ce2 = new Centerr();
            
            ce1.setCenterName("IBM");
            ce2.setCenterName("SUN");
            
            Course c1 = new Course();
            Course c2 = new Course();
            
            c1.setCourseName("JAVA");
            c2.setCourseName("SAP");
            
            ce1.getCourses().add(c1);
            ce2.getCourses().add(c2);
            
            
            System.out.println("Save");
            se.save(ce1);
            se.save(ce2);
            se.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
