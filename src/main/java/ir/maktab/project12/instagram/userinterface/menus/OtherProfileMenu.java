package ir.maktab.project12.instagram.userinterface.menus;

import ir.maktab.project12.instagram.entities.User;
import ir.maktab.project12.instagram.entities.exceptions.InvalidCommandException;
import ir.maktab.project12.instagram.entities.exceptions.UserNotFoundException;

public class OtherProfileMenu extends Menu {
    private User chosenUser;
    public OtherProfileMenu(User chosenUser) {
        this.chosenUser = chosenUser;
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
