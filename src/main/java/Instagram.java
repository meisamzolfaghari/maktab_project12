import ir.maktab.project12.instagram.core.config.DatabaseInit;
import ir.maktab.project12.instagram.userinterface.menus.FirstMenu;

public class Instagram {
    public static void main(String[] args) {
        DatabaseInit.userInit();
        new FirstMenu().execute();
    }
}
