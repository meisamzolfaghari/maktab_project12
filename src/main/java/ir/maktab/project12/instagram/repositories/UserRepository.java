package ir.maktab.project12.instagram.repositories;

import ir.maktab.project12.instagram.core.config.hibernate.HibernateUtil;
import ir.maktab.project12.instagram.model.User;
import org.hibernate.Session;

public class UserRepository extends CrudRepository<User, Long> {
    private static UserRepository userRepositoryDb;
    private static UserRepository userRepositoryH2;

    private UserRepository(Session session) {
        super(session);
    }

    public static UserRepository getUserRepositoryDb() {
        if (userRepositoryDb == null)
            userRepositoryDb = new UserRepository(HibernateUtil.getSessionDb());
        return userRepositoryDb;
    }

    public static UserRepository getUserRepositoryH2() {
        if (userRepositoryH2 == null)
            userRepositoryH2 = new UserRepository(HibernateUtil.getSessionH2());
        return userRepositoryH2;
    }

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

}
