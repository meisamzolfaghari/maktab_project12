package ir.maktab.project12.instagram.userinterface.menus;

import ir.maktab.project12.instagram.entities.Post;

public class EditPostMenu extends Menu {
    private Post ChosenPost;
    public EditPostMenu(Post chosenPost) {
        this.ChosenPost = chosenPost;
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
