package inheritance;

import first.NewHibernateUtil;
import org.hibernate.Session;


public class CRUD {
    public void insetBook() {
        Session se = NewHibernateUtil.getSessionFactory().openSession();
        try {
            se.beginTransaction();
            Book b = new Book();
            b.setIsb(1568);
            ProBooks pb = new ProBooks();
            pb.setIsb(89489);
            pb.setLang("en");
            HeadSer hs = new HeadSer();
            hs.setIsb(4648);
            hs.setLang("en");
            hs.setPic("yes");
            se.save(b);
            se.save(hs);
            se.save(pb);
            se.getTransaction().commit();
        } catch (Exception e) {
            se.getTransaction().rollback();
            NewHibernateUtil.shutdown();
            System.out.println("Error: " + e);
        }
    }
}
