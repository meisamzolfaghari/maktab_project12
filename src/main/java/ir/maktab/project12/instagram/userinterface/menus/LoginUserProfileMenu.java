package ir.maktab.project12.instagram.userinterface.menus;

import ir.maktab.project12.instagram.core.share.AuthenticationService;
import ir.maktab.project12.instagram.core.share.Commands;
import ir.maktab.project12.instagram.model.Post;
import ir.maktab.project12.instagram.model.User;
import ir.maktab.project12.instagram.services.Functions;
import ir.maktab.project12.instagram.services.Posts;
import ir.maktab.project12.instagram.services.Users;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LoginUserProfileMenu extends Menu {
    @Override
    public void execute() {
        String command = "";
        while (!command.equals(Commands.back.name())) {
            User loginUser = AuthenticationService.getInstance().getLoginUser();
            Users.displayProfile(loginUser);

            command = Functions.getCommand(availableCommands());
            if (command.equals(Commands.exit.name())) {
                exit();
            } else if (command.equals(Commands.edit.name())) {
                new EditProfileMenu().execute();
            } else if (command.equals(Commands.posts.name())) {
                new UserPostMenu().execute();
            } else if (command.equals(Commands.followers.name())) {
                Users.displayAllShortVersion(loginUser, (List<User>) loginUser.getFollowers());
                new FinalMenu().execute();
            } else if (command.equals(Commands.followings.name())) {
                Users.displayAllShortVersion(loginUser, (List<User>) loginUser.getFollowing());
                new FinalMenu().execute();
            } else if (command.equals(Commands.signout.name())) {
                Users.signOut();
                new FirstMenu().execute();
            }
        }

    }

    @Override
    protected Set<String> availableCommands() {
        return new HashSet<>(Arrays.asList(
                Commands.edit.name()
                , Commands.posts.name()
                , Commands.followers.name()
                , Commands.followings.name()
                , Commands.back.name()
                , Commands.signout.name()
                , Commands.exit.name()));
    }
}
