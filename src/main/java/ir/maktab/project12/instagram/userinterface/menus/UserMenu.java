package ir.maktab.project12.instagram.userinterface.menus;

import ir.maktab.project12.instagram.core.share.Commands;

import java.util.ArrayList;

public class UserMenu extends Menu {
    public UserMenu(){setActions();}

    @Override
    public void execute(){

    }

    @Override
    protected void displayMenu() {
        System.out.println("\t+---------------------------------------------------------------+");
        System.out.println("\t|                   User Menu                                   |");
        System.out.println("\t+---------------------------------------------------------------+");
        System.out.println("\t|  likepost        ---->    Like a Post.                        |");
        System.out.println("\t|  addpost         ---->    Add a Post.                         |");
        System.out.println("\t|  profile         ---->    Shows Your Profile.                 |");
        System.out.println("\t|  exit            ---->    Exit.                               |");
        System.out.println("\t+---------------------------------------------------------------+");
    }

    @Override
    protected void setActions() {
        actions = new ArrayList<>();
        actions.add(Commands.like.name());
        actions.add(Commands.add.name());
        actions.add(Commands.profile.name());
        actions.add(Commands.exit.name());
    }
}
