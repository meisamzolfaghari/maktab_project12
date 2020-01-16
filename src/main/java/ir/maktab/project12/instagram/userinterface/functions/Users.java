package ir.maktab.project12.instagram.userinterface.functions;


import ir.maktab.project12.instagram.core.share.AuthenticationService;
import ir.maktab.project12.instagram.entities.User;
import ir.maktab.project12.instagram.entities.exceptions.InvalidCommandException;
import ir.maktab.project12.instagram.entities.exceptions.UserNotFoundException;
import ir.maktab.project12.instagram.repositories.UserRepository;

import java.util.List;
import java.util.Scanner;


public class Users {
    public static String getCommand(List<String> actions) throws InvalidCommandException{
        Scanner scanner = new Scanner(System.in);
        String command;

        while(true) {
            System.out.print("Enter command:");
            command = scanner.next();

            if(!actions.contains(command))
                throw new InvalidCommandException("Command not found");
            else
                return command;
        }
    }

    public static void SignIn(String username, String password) throws UserNotFoundException {
        UserRepository repository = UserRepository.getUserRepository();
        List<User> users = repository.findAll();

        if(users.isEmpty())
            throw new UserNotFoundException("User isn't in database!");
        for(User user: users)
            if(user.getUsername().equals(username) && user.getPassword().equals(password))
                AuthenticationService.getInstance().setLoginUser(user);
    }

    public static void SignUp(String firstName, String lastName, String username, String password, String email) {
        User user = new User(username, password, email, firstName, lastName);
        UserRepository repository = UserRepository.getUserRepository();
        repository.save(user);
    }

    public static String getUsername() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("username:");

        return scanner.next();
    }

    public static String getPassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("password:");

        return scanner.next();
    }

    public static String getFirstName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("first name:");

        return scanner.next();
    }

    public static String getLastName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("lastName:");

        return scanner.next();
    }

    public static String getEmail() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("email:");

        return scanner.next();
    }
}
