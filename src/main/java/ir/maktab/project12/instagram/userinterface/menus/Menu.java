package ir.maktab.project12.instagram.userinterface.menus;

import java.util.Set;

public abstract class Menu {

    public abstract void execute();

    protected abstract Set<String> availableCommands();

    protected void exit() {
        System.out.println("\n bye bye!");
        System.exit(0);
    }

}
