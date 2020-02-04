package ir.maktab.project12.instagram.userinterface.menus;

import ir.maktab.project12.instagram.core.share.AuthenticationService;
import ir.maktab.project12.instagram.core.share.Commands;
import ir.maktab.project12.instagram.model.User;
import ir.maktab.project12.instagram.services.Functions;
import ir.maktab.project12.instagram.services.Users;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SearchMenu extends Menu {

    private List<User> foundUsers;

    public SearchMenu(List<User> foundUsers) {
        this.foundUsers = foundUsers;
    }

    @Override
    public void execute() {
        if (foundUsers.isEmpty())
            return;

        String command = "";
        while (!command.equals(Commands.back.name())) {
            User loginUser = AuthenticationService.getInstance().getLoginUser();
            Users.displayAllShortVersion(loginUser,foundUsers);

            command = Functions.getCommand(availableCommands());
            if (command.equals(Commands.exit.name())) {
                exit();
            } else if (command.equals(Commands.select.name())) {
                User chosenUser = Users.select(foundUsers);
                if (chosenUser != null) {
                    new OtherUserProfileMenu(chosenUser).execute();
                }
            } else if (command.equals(Commands.follow.name())) {
                User chosenUser = Users.select(foundUsers);
                if (chosenUser != null)
                    Users.follow(loginUser, chosenUser);
            } else if (command.equals(Commands.unFollow.name())) {
                User chosenUser = Users.select(foundUsers);
                if (chosenUser != null)
                    Users.unFollow(loginUser, chosenUser);
            } else if (command.equals(Commands.signout.name())) {
                Users.signOut();
                new FirstMenu().execute();
            }
        }
    }

    @Override
    protected Set<String> availableCommands() {
        return new HashSet<>(Arrays.asList(
                Commands.select.name()
                , Commands.follow.name()
                , Commands.unFollow.name()
                , Commands.back.name()
                , Commands.signout.name()
                , Commands.exit.name()));
    }
}
