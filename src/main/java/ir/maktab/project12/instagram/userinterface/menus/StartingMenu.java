package ir.maktab.project12.instagram.userinterface.menus;

import ir.maktab.project12.instagram.core.share.Commands;
import ir.maktab.project12.instagram.userinterface.functions.Users;

import java.util.ArrayList;


public class StartingMenu extends Menu {
    public StartingMenu() {
        setActions();
    }

    @Override
    public void execute(){
        while (true) {

            displayMenu();
            command = Users.getCommand(actions);

            if (command.equalsIgnoreCase(Commands.exit.name()))
                exit();
            else if (command.equalsIgnoreCase(Commands.signin.name())) {
                Users.SignIn(Users.getUsername(), Users.getPassword());
            }
            else if (command.equalsIgnoreCase(Commands.signup.name()))
                Users.SignUp(Users.getFirstName(), Users.getLastName(), Users.getUsername(), Users.getPassword(), Users.getEmail());
        }
    }

    @Override
    protected void displayMenu() {
        System.out.println("\t+---------------------------------------------------------------+");
        System.out.println("\t|                   Starting Menu                               |");
        System.out.println("\t+---------------------------------------------------------------+");
        System.out.println("\t|  SignIn          ---->    Sign In To Your Account.            |");
        System.out.println("\t|  SignUp          ---->    Create An Account.                  |");
        System.out.println("\t|  Exit            ---->    Exit.                               |");
        System.out.println("\t+---------------------------------------------------------------+");
    }

    @Override
    protected void setActions() {
        actions = new ArrayList<>();
        actions.add(Commands.signin.name());
        actions.add(Commands.signup.name());
        actions.add(Commands.exit.name());
    }
}
