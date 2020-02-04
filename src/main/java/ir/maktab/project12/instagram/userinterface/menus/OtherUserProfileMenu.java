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

public class OtherUserProfileMenu extends Menu {

    private User chosenUser;

    public OtherUserProfileMenu(User chosenUser) {
        this.chosenUser = chosenUser;
    }


    @Override
    public void execute() {
        if (chosenUser == null)
            return;

        String command = "";
        while (!command.equals(Commands.back.name())) {
            User loginUser = AuthenticationService.getInstance().getLoginUser();
            Users.displayShortVersion(loginUser, chosenUser);

            command = Functions.getCommand(availableCommands());
            if (command.equals(Commands.exit.name())) {
                exit();
            } else if (command.equals(Commands.posts.name())) {
                Posts.displayAllShortVersion((List<Post>) chosenUser.getPosts());
                new FinalMenu().execute();
            } else if (command.equals(Commands.follow.name())) {
                Users.follow(loginUser, chosenUser);
            } else if (command.equals(Commands.unFollow.name())) {
                Users.unFollow(loginUser, chosenUser);
            } else if (command.equals(Commands.followers.name())) {
                Users.displayAllShortVersion(loginUser, (List<User>) chosenUser.getFollowers());
                new FinalMenu().execute();
            } else if (command.equals(Commands.followings.name())) {
                Users.displayAllShortVersion(loginUser, (List<User>) chosenUser.getFollowing());
                new FinalMenu().execute();
            } else if (command.equals(Commands.signout.name())) {
                Users.signOut();
                new FirstMenu().execute();
            }
        }

    }

    @Override
    protected Set<String> availableCommands() {
        Set<String> commands =
                new HashSet<>(Arrays.asList(
                        Commands.posts.name()
                        , Commands.followers.name()
                        , Commands.followings.name()
                        , Commands.back.name()
                        , Commands.signout.name()
                        , Commands.exit.name()));
        User loginUser = AuthenticationService.getInstance().getLoginUser();
        if (loginUser.getFollowing().contains(chosenUser))
            commands.add(Commands.unFollow.name());
        else
            commands.add(Commands.follow.name());

        return commands;
    }
}
