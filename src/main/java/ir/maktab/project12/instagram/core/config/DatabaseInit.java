package ir.maktab.project12.instagram.core.config;

import ir.maktab.project12.instagram.model.User;
import ir.maktab.project12.instagram.repositories.UserRepository;

public class DatabaseInit {
    public static void userInit(){
        UserRepository userDAO = UserRepository.getUserRepositoryDb();
        if (userDAO.findAll().isEmpty())
            userDAO.save(new User("admin" , "123"));
    }
}
