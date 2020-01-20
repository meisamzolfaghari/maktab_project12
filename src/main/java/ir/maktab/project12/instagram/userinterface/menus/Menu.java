package ir.maktab.project12.instagram.userinterface.menus;

import ir.maktab.project12.instagram.core.share.AuthenticationService;
import ir.maktab.project12.instagram.entities.User;
import ir.maktab.project12.instagram.entities.exceptions.InvalidCommandException;
import ir.maktab.project12.instagram.entities.exceptions.UserNotFoundException;

import java.util.List;


public abstract class Menu {
    protected User loginUser;
    protected String command;
    protected List<String> actions;

    public Menu() {
        loginUser = AuthenticationService.getInstance().getLoginUser();
    }

    public abstract void execute();

    protected abstract void displayMenu();

    protected abstract void setActions();

    protected void exit() {
        System.out.println("Exit from system");
    }
}
