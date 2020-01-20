package ir.maktab.project12.instagram.userinterface.menus;

import ir.maktab.project12.instagram.entities.Post;
import ir.maktab.project12.instagram.entities.exceptions.InvalidCommandException;
import ir.maktab.project12.instagram.entities.exceptions.UserNotFoundException;

public class PostMenu extends Menu {
    private Post selectedPost;
    public PostMenu(Post selectedPost) {
        this.selectedPost = selectedPost;
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
