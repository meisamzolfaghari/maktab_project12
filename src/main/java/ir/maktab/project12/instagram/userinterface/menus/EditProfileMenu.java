package ir.maktab.project12.instagram.userinterface.menus;

import ir.maktab.project12.instagram.core.share.AuthenticationService;
import ir.maktab.project12.instagram.core.share.Commands;
import ir.maktab.project12.instagram.model.User;
import ir.maktab.project12.instagram.services.Functions;
import ir.maktab.project12.instagram.services.Posts;
import ir.maktab.project12.instagram.services.Users;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class EditProfileMenu extends Menu {
    @Override
    public void execute() {

        String command = "";
        while (!command.equals(Commands.back.name())) {
            User loginUser = AuthenticationService.getInstance().getLoginUser();
            if (loginUser == null)
                break;
            Users.displayProfile(loginUser);

            command = Functions.getCommand(availableCommands());
            if (command.equals(Commands.exit.name())) {
                exit();
            } else if (command.equals(Commands.username.name())) {
                Users.editUsername(loginUser, Users.getNewUsername());
            } else if (command.equals(Commands.password.name())) {
                Users.editPassword(loginUser, Users.getNewPassword());
            } else if (command.equals(Commands.email.name())) {
                Users.editEmail(loginUser, Users.getNewEmail());
            } else if (command.equals(Commands.firstname.name())) {
                Users.editFirstName(loginUser, Users.getFirstName());
            } else if (command.equals(Commands.lastname.name())) {
                Users.editLastName(loginUser, Users.getLastName());
            } else if (command.equals(Commands.signout.name())) {
                Users.signOut();
                new FirstMenu().execute();
            } else if (command.equals(Commands.deleteaccount.name())) {
                Users.deleteAccount(loginUser);
                new FirstMenu().execute();
            }
        }
    }

    @Override
    protected Set<String> availableCommands() {
        return new HashSet<>(Arrays.asList(
                Commands.username.name()
                , Commands.password.name()
                , Commands.email.name()
                , Commands.firstname.name()
                , Commands.lastname.name()
                , Commands.signout.name()
                , Commands.deleteaccount.name()
                , Commands.exit.name()));
    }
}
