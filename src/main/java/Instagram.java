import ir.maktab.project12.instagram.entities.exceptions.InvalidCommandException;
import ir.maktab.project12.instagram.userinterface.menus.StartingMenu;

public class Instagram {

    public static void main(String[] args) {
        try {
            new StartingMenu().execute();
        } catch (InvalidCommandException e) {
            e.printStackTrace();
        }
    }
}
