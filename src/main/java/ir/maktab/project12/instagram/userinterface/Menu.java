package ir.maktab.project12.instagram.userinterface;


import ir.maktab.project12.instagram.core.share.AuthenticationService;
import ir.maktab.project12.instagram.entities.User;
<<<<<<< Updated upstream:src/main/java/ir/maktab/project12/instagram/userinterface/menus/Menu.java
=======
import ir.maktab.project12.instagram.entities.exceptions.InvalidCommandException;

import java.util.List;
>>>>>>> Stashed changes:src/main/java/ir/maktab/project12/instagram/userinterface/Menu.java

import java.util.List;

public abstract class Menu {
    protected User loginUser;
    protected String command;
    protected List<String> actions;

    public Menu() {
        loginUser = AuthenticationService.getInstance().getLoginUser();
    }

    public abstract void execute() throws InvalidCommandException;

    protected abstract void displayMenu();

    protected abstract void setActions();

    protected void exit() {
        System.out.println("\n bye bye!");
        System.exit(0);
    }
}
