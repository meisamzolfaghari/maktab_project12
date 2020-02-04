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

public class UserPostMenu extends Menu {
    @Override
    public void execute() {
        User loginUser = AuthenticationService.getInstance().getLoginUser();
        if (loginUser == null || loginUser.getPosts().isEmpty())
            return;
        String command = "";
        while (!command.equals(Commands.back.name())) {
            List<Post> posts = (List<Post>) loginUser.getPosts();
            Posts.displayAllShortVersion(posts);

            command = Functions.getCommand(availableCommands());
            if (command.equals(Commands.exit.name())) {
                exit();
            } else if (command.equals(Commands.select.name())) {
                Post chosenPost = Posts.select(posts);
                if (chosenPost != null)
                    new UserChoosePostMenu(chosenPost).execute();
            } else if (command.equals(Commands.like.name())) {
                Post chosenPost = Posts.select(posts);
                if (chosenPost != null)
                    Posts.like(loginUser, chosenPost);
            } else if (command.equals(Commands.unlike.name())) {
                Post chosenPost = Posts.select(posts);
                if (chosenPost != null)
                    Posts.unLike(loginUser, chosenPost);
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
                , Commands.like.name()
                , Commands.unlike.name()
                , Commands.back.name()
                , Commands.signout.name()
                , Commands.exit.name()));
    }
}
