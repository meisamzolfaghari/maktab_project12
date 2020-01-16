package ir.maktab.project12.instagram.repositories;

import ir.maktab.project12.instagram.entities.User;

public class UserRepository extends CrudRepository<User, Long> {

    UserRepository userRepository;

    private UserRepository() {
    }

    public UserRepository getUserRepository() {
        if(userRepository == null){
            userRepository = new UserRepository();
        }
        return userRepository;
    }

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }
}
