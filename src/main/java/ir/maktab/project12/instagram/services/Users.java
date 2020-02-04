package ir.maktab.project12.instagram.services;


import ir.maktab.project12.instagram.core.share.AuthenticationService;
import ir.maktab.project12.instagram.core.share.Colors;
import ir.maktab.project12.instagram.model.Post;
import ir.maktab.project12.instagram.model.User;
import ir.maktab.project12.instagram.repositories.PostRepository;
import ir.maktab.project12.instagram.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class Users {

    private static Scanner scanner = new Scanner(System.in);

    public static void displayAllShortVersion(User loginUser, List<User> users) {
        if (users.isEmpty() || loginUser == null) return;
        System.out.println("------------------------------------------------------------------------------------");
        users.forEach(user -> {
            String followingState = (loginUser.getFollowing().contains(user)) ? "Following" : "Not Following";
            System.out.println(Colors.getAnsiYellow()
                    + "------------------------------------------------------------------------------------"
                    + "\nID= " + user.getId()
                    + " , Username= '" + user.getUsername()
                    + " , Following Status= '" + followingState
                    + "'\n------------------------------------------------------------------------------------"
                    + Colors.getAnsiReset());
        });
    }

    public static void displayShortVersion(User loginUser, User user) {
        if (user == null || loginUser == null) return;

        String followingState = (loginUser.getFollowing().contains(user)) ? "Following" : "Not Following";
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println(Colors.getAnsiYellow()
                + "------------------------------------------------------------------------------------"
                + "\nID= " + user.getId()
                + " , Username= '" + user.getUsername()
                + " , Email= '" + user.getEmail()
                + " , First Name= '" + user.getFirstName()
                + " , Last Name= '" + user.getLastName()
                + " , Following Status= '" + followingState
                + "'\n------------------------------------------------------------------------------------"
                + Colors.getAnsiReset());
    }

    public static void displayProfile(User loginUser) {
        if (loginUser == null) return;

        System.out.println("------------------------------------------------------------------------------------");
        System.out.println(Colors.getAnsiYellow()
                + "------------------------------------------------------------------------------------"
                + "\nID= " + loginUser.getId()
                + " , Username= '" + loginUser.getUsername()
                + " , Email= '" + loginUser.getEmail()
                + " , First Name= '" + loginUser.getFirstName()
                + " , Last Name= '" + loginUser.getLastName()
                + "'\n------------------------------------------------------------------------------------"
                + Colors.getAnsiReset());
    }

    public static User select(List<User> users) {
        if (users.isEmpty()) return null;

        Long id;
        Scanner scanner = new Scanner(System.in);
        id = scanner.nextLong();
        for (User user : users)
            if (user.getId().equals(id))
                return user;
        System.out.println(Colors.getAnsiRed() + "\t\u274c Invalid ID!" + Colors.getAnsiReset());
        return null;
    }

    public static List<User> searchUserByUsername(String username) {
        if (username == null) return new ArrayList<>();
        UserRepository userRepository = UserRepository.getUserRepositoryDb();
        List<User> users = userRepository.findAll();
        List<User> foundUser = new ArrayList<>();
        for (User user : users)
            if (user.getUsername().contains(username))
                foundUser.add(user);

        if (!foundUser.isEmpty())
            return foundUser;

        System.out.println(Colors.getAnsiYellow() + "\t\u274c User Not Found!" + Colors.getAnsiReset());
        return new ArrayList<>();
    }

    public static void follow(User loginUser, User chosenUser) {
        if (loginUser == null || chosenUser == null) return;

        Set<User> followings = loginUser.getFollowing();
        followings.add(chosenUser);
        loginUser.setFollowing(followings);
        UserRepository userRepository = UserRepository.getUserRepositoryDb();
        userRepository.update(loginUser);
    }

    public static void unFollow(User loginUser, User chosenUser) {
        if (loginUser == null || chosenUser == null) return;

        Set<User> followings = loginUser.getFollowing();
        followings.remove(chosenUser);
        loginUser.setFollowing(followings);
        UserRepository userRepository = UserRepository.getUserRepositoryDb();
        userRepository.update(loginUser);
    }

    public static void editUsername(User loginUser, String username) {
        if (username == null || loginUser == null) return;
        UserRepository userRepository = UserRepository.getUserRepositoryDb();
        List<User> users = userRepository.findAll();
        if (users.stream().anyMatch(user -> user.getUsername().equals(username))) {
            System.out.println(Colors.getAnsiRed() + "\t\u274c Failed to Sign Up! Not a valid Username." + Colors.getAnsiReset());
            return;
        }
        loginUser.setUsername(username);
        userRepository.update(loginUser);
    }

    public static void editPassword(User loginUser, String password) {
        if (password == null || loginUser == null) return;
        loginUser.setPassword(password);
        UserRepository userRepository = UserRepository.getUserRepositoryDb();
        userRepository.update(loginUser);
    }

    public static void editEmail(User loginUser, String email) {
        if (email == null || loginUser == null) return;
        loginUser.setPassword(email);
        UserRepository userRepository = UserRepository.getUserRepositoryDb();
        userRepository.update(loginUser);
    }

    public static void editFirstName(User loginUser, String firstName) {
        if (firstName == null || loginUser == null) return;
        loginUser.setFirstName(firstName);
        UserRepository userRepository = UserRepository.getUserRepositoryDb();
        userRepository.update(loginUser);
    }

    public static void editLastName(User loginUser, String lastName) {
        if (lastName == null || loginUser == null) return;
        loginUser.setLastName(lastName);
        UserRepository userRepository = UserRepository.getUserRepositoryDb();
        userRepository.update(loginUser);
    }

    public static void SignIn(String username, String password) {
        UserRepository userDAO = UserRepository.getUserRepositoryDb();
        List<User> users = userDAO.findAll();

        if (users.isEmpty() || username == null || password == null) {
            System.out.println(Colors.getAnsiRed() + "\t\u274c Username or Password is Incorrect!" + Colors.getAnsiReset());
            return;
        }
        for (User user : users)
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                AuthenticationService.getInstance().setLoginUser(user);
                System.out.println(Colors.getAnsiGreen() + "\t\u2714 User Successfully Signed In." + Colors.getAnsiReset());
                return;
            }
        System.out.println(Colors.getAnsiRed() + "\t\u274c Username or Password is Incorrect!" + Colors.getAnsiReset());
    }

    public static void SignUp(String username, String password, String firstName, String lastName, String email) {
        if (firstName == null || lastName == null || username == null || email == null || password == null) {
            System.out.println(Colors.getAnsiRed() + "\t\u274c Failed to Sign Up!" + Colors.getAnsiReset());
            return;
        }
        UserRepository userRepositoryDb = UserRepository.getUserRepositoryDb();
        List<User> users = userRepositoryDb.findAll();
        if (users.stream().anyMatch(user -> user.getUsername().equals(username))) {
            System.out.println(Colors.getAnsiRed() + "\t\u274c Failed to Sign Up! Not a valid Username." + Colors.getAnsiReset());
            return;
        }
        if (users.stream().anyMatch(user -> user.getEmail().equals(email))) {
            System.out.println(Colors.getAnsiRed() + "\t\u274c Failed to Sign Up! Not a valid Email." + Colors.getAnsiReset());
            return;
        }
        User user = new User(username, password, email, firstName, lastName);
        userRepositoryDb.save(user);
        if (userRepositoryDb.findById(user.getId()) != null)
            System.out.println(Colors.getAnsiGreen() + "\t\u2714 User Successfully Signed Up." + Colors.getAnsiReset());
    }

    public static void signOut() {
        AuthenticationService.getInstance().setLoginUser(null);
        if (AuthenticationService.getInstance().getLoginUser() == null)
            System.out.println(Colors.getAnsiGreen() + "\t\u2714 User Successfully Signed Out." + Colors.getAnsiReset());
    }

    public static void deleteAccount(User user) {
        if (user == null) return;
        UserRepository userRepository = UserRepository.getUserRepositoryDb();
        userRepository.remove(user);
        AuthenticationService.getInstance().setLoginUser(null);
    }

    public static String getUsername() {
        System.out.print("\t\u29bf Username: ");
        return scanner.next();
    }

    public static String getPassword() {
        System.out.print("\t\u29bf Password: ");
        return scanner.next();
    }

    public static String getFirstName() {
        System.out.print("\t\u29bf First Name: ");
        return scanner.next();
    }

    public static String getLastName() {
        System.out.print("\t\u29bf Last Name: ");
        return scanner.next();
    }

    public static String getEmail() {
        System.out.print("\t\u29bf email: ");
        return scanner.next();
    }

    public static String getNewUsername() {
        System.out.print("\t\u29bf Username: ");
        return scanner.next();
    }

    public static String getNewPassword() {
        System.out.print("\t\u29bf Password: ");
        return scanner.next();
    }

    public static String getNewEmail() {
        System.out.print("\t\u29bf email: ");
        return scanner.next();
    }
}
