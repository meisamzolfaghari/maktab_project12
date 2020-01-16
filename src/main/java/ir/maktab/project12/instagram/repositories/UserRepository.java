package ir.maktab.project12.instagram.repositories;

import ir.maktab.project12.instagram.entities.User;

public class UserRepository extends CrudRepository<User,Long> {
    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }
}
