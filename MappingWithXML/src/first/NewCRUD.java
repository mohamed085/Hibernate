package first;

import javax.persistence.Entity;
import org.hibernate.Session;

public class NewCRUD {
    public void insertStudent() {
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        try {
            s.beginTransaction();
            NewStudent st = new NewStudent();
            NewBook b = new NewBook();
            st.setName("Adam");
            b.setBookName("JAVA");
            st.setB(b);
            s.save(st);
            s.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void getStudent() {
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        try {
            s.beginTransaction();
            NewStudent st = new NewStudent();
            st = (NewStudent) s.get(NewStudent.class, 1);
            System.out.println("Student: "+st.toString());
            s.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
