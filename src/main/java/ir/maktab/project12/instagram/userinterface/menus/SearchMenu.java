package ir.maktab.project12.instagram.userinterface.menus;

import ir.maktab.project12.instagram.entities.User;

import java.util.Set;

public class SearchMenu extends Menu {
    private Set<User> foundedUser;
    public SearchMenu(Set<User> foundedUser) {
        this.foundedUser = foundedUser;
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
