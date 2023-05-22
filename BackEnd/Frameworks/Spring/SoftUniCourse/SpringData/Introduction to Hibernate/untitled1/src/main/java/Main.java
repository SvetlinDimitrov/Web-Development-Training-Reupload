import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory sessionFactory =
                cfg.buildSessionFactory();

        Session session = sessionFactory.openSession();

        List<Student> list = session.createQuery("FROM Student" ,Student.class).list();
        for (Student student : list) {
            System.out.println(student);
        }


        session.close();
    }
}

