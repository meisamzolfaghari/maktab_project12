package ir.maktab.project12.instagram.userinterface.menus;

import ir.maktab.project12.instagram.core.share.Commands;
import ir.maktab.project12.instagram.entities.exceptions.InvalidCommandException;
import ir.maktab.project12.instagram.userinterface.functions.Users;

import java.util.ArrayList;


public class StartingMenu extends Menu {
    public StartingMenu() {
        setActions();
    }

    @Override
    public void execute() throws InvalidCommandException {
        while (true) {
            command = Users.getCommand(actions);
            if (command.equalsIgnoreCase(Commands.Exit.name()))
                exit();
            else if (command.equalsIgnoreCase(Commands.SignIn.name()))
                Users.SignIn(Users.getUsername(), Users.getPassword());
            else if (command.equalsIgnoreCase(Commands.SignUp.name()))
                Users.SignUp(Users.getFirstName(), Users.getLastName(), Users.getUsername(), Users.getPassword(), Users.getEmail());
        }
    }

    @Override
    protected void displayMenu() {}

    @Override
    protected void setActions() {
        actions = new ArrayList<>();
        actions.add(Commands.SignIn.name());
        actions.add(Commands.SignUp.name());
        actions.add(Commands.Exit.name());
    }
}
