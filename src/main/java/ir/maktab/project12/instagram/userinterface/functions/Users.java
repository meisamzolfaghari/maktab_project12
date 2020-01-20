package ir.maktab.project12.instagram.userinterface.functions;


import ir.maktab.project12.instagram.core.share.AuthenticationService;
import ir.maktab.project12.instagram.entities.User;
import ir.maktab.project12.instagram.repositories.UserRepository;

import java.util.List;
import java.util.Scanner;


public class Users {
    public static String getCommand(List<String> actions) {
        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {
            System.out.print("\t\u29bf Enter command:");
            command = scanner.next();

            if (!actions.contains(command))
                System.out.println("\t\u274c Command not found");
            else
                return command;
        }
    }

    public static void SignIn(String username, String password) {
        UserRepository repository = UserRepository.getUserRepository();
        List<User> users = repository.findAll();

        if (users.isEmpty())
            System.out.println("\t\u274c Username or Password is Incorrect!");
        for (User user : users)
            if (user.getUsername().equals(username) && user.getPassword().equals(password))
                AuthenticationService.getInstance().setLoginUser(user);
    }

    public static void SignUp(String firstName, String lastName, String username, String password, String email) {
        User user = new User(username, password, email, firstName, lastName);
        UserRepository repository = UserRepository.getUserRepository();
        user.setId(repository.save(user));
        if (repository.findById(user.getId()) != null)
            System.out.println("\t\u2714 User Successfully Signed Up.");
    }

    public static String getUsername() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\t\u29bf username:");
        return scanner.next();
    }

    public static String getPassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\t\u29bf password:");
        return scanner.next();
    }

    public static String getFirstName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\t\u29bf first name:");
        return scanner.next();
    }

    public static String getLastName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\t\u29bf lastName:");
        return scanner.next();
    }

    public static String getEmail() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\t\u29bf email:");
        return scanner.next();
    }
}
