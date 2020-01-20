package ir.maktab.project12.instagram.userinterface.menus;

import ir.maktab.project12.instagram.entities.Post;

import java.util.Set;

public class UserPostMenu extends Menu {
    private Set<Post> UsersPosts;
    public UserPostMenu(Set<Post> UsersPosts) {
        this.UsersPosts = UsersPosts;
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
