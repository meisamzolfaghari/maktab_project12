package ir.maktab.project12.instagram.core.config.hibernate;

import ir.maktab.project12.instagram.model.Comment;
import ir.maktab.project12.instagram.model.Post;
import ir.maktab.project12.instagram.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactoryDb;
    private static Session sessionDb;

    private static SessionFactory sessionFactoryH2;
    private static Session sessionH2;

    static {
        sessionFactoryDb = new Configuration()
                .configure("hibernate.db.cfg.xml")
                .addAnnotatedClass(Post.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Comment.class)
                .buildSessionFactory();

        sessionDb = sessionFactoryDb.openSession();

        sessionFactoryH2 = new Configuration()
                .configure("hibernate.h2.cfg.xml")
                .addAnnotatedClass(Post.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Comment.class)
                .buildSessionFactory();

        sessionH2 = sessionFactoryH2.openSession();
    }

    public static Session getSessionDb(){ return sessionDb; }

    public static Session getSessionH2(){ return sessionH2; }

}
