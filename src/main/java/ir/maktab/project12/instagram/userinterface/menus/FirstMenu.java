package ir.maktab.project12.instagram.userinterface.menus;

import ir.maktab.project12.instagram.core.share.Commands;
import ir.maktab.project12.instagram.core.share.AuthenticationService;
import ir.maktab.project12.instagram.model.User;
import ir.maktab.project12.instagram.services.Functions;
import ir.maktab.project12.instagram.services.Users;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FirstMenu extends Menu {


    @Override
    public void execute() {
        String command = "";
        while (!command.equals(Commands.exit.name())) {

            command = Functions.getCommand(availableCommands());

            if (command.equals(Commands.exit.name())) {
                exit();
            } else if (command.equals(Commands.signin.name())) {
                Users.SignIn(Users.getUsername(), Users.getPassword());
                User loginUser = AuthenticationService.getInstance().getLoginUser();

                if (loginUser != null)
                    new UserMenu().execute();////------------->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

            } else if (command.equals(Commands.signup.name())) {
                Users.SignUp(Users.getUsername(), Users.getPassword(), Users.getFirstName(), Users.getLastName()
                        , Users.getEmail());
            }
        }
    }

    @Override
    protected Set<String> availableCommands() {
        return new HashSet<>(Arrays.asList(
                Commands.signin.name()
                , Commands.signup.name()
                , Commands.exit.name()));
    }
}
