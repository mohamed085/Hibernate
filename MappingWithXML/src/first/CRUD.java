package first;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class CRUD {
    public void insert() {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Person user;
        try {
            session.beginTransaction();
            for (int i = 0; i < 10; i++){
                 user = new Person();
                user.setName("Mohamed" + i);
                user.setHireDate(new Date());
                user.setTime(new Date()); 
                user.setCal(200);
                user.setPostion("Instructor");
                user.setJobTitle("Senior Developer");
                session.save(user);
            }
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }        
    }
    
    public void insertEmployee() {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        
        try {
            session.beginTransaction();
            Employee employee = new Employee();
            Address address = new Address();
            Address homeAddress = new Address();
            address.setCity("Cairo");
            address.setStreet("14 st");
            address.setState("Ben");
            homeAddress.setCity("Octobar");
            homeAddress.setStreet("18 st");
            homeAddress.setState("ASD");
            employee.setAddress(address);
            employee.setAddressHome(homeAddress);
            employee.setName("Ahmed");
            session.save(employee);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }  
    }
    
    public void insertEmployeeWithListOfAddresses() {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        List<Address> addresses = new ArrayList<>();
        try {
            session.beginTransaction();
            Employee employee = new Employee();
            Address address = new Address();
            Address address1 = new Address();
            Address homeAddress = new Address();
            address.setCity("Cairo");
            address.setStreet("14 st");
            address.setState("Ben");
            address1.setCity("Cairo");
            address1.setStreet("14 st");
            address1.setState("Ben");
            homeAddress.setCity("Octobar");
            homeAddress.setStreet("18 st");
            homeAddress.setState("ASD");
            employee.setAddress(address);
            employee.setAddressHome(homeAddress);
            employee.setName("Ahmed");
            addresses.add(address);
            addresses.add(address1  );
            addresses.add(homeAddress);
            employee.setAddresses(addresses);
            session.save(employee);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }  
    }
    
    public void insertStudent() {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Student s = new Student();
            Compke c = new Compke(1, 10);
            s.setName("Omda");
            s.setCompke(c);
            session.save(s);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }        
    }
    
    public void select(int id) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Person p = new Person();
            p = (Person) session.get(Person.class, id);
            System.out.println(p.toString());
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    
    public void update(int id) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Person p = new Person();
            p = (Person) session.get(Person.class, id);
            p.setName("Ahmed");
            session.update(p);
            System.out.println(p.toString());
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    
    public void delete(int id) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Person p = new Person();
            p = (Person) session.get(Person.class, id);
            session.delete(p);
            System.out.println(p.toString());
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    
}
