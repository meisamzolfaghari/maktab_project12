package ir.maktab.project12.instagram.core.config.hibernate;

import ir.maktab.project12.instagram.entities.Post;
import ir.maktab.project12.instagram.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static Session session;

    static {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Post.class)
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        session = sessionFactory.openSession();
    }

    public static Session getSession(){ return session; }

}
