package ir.maktab.project12.instagram.userinterface.menus;

import ir.maktab.project12.instagram.entities.User;
import ir.maktab.project12.instagram.entities.exceptions.InvalidCommandException;
import ir.maktab.project12.instagram.entities.exceptions.UserNotFoundException;

import java.util.Set;

public class FollowersMenu extends Menu {
    private Set<User> followers;
    public FollowersMenu(Set<User> followers) {
        this.followers = followers;
        setActions();
    }

    @Override
    public void execute(){

    }

    @Override
    protected void displayMenu() {

    }

    @Override
    protected void setActions() {

    }
}
