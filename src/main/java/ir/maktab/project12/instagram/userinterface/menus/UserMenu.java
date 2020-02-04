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

public class UserMenu extends Menu {
    @Override
    public void execute() {
        String command = "";
        while (!command.equals(Commands.signout.name())) {
            User loginUser = AuthenticationService.getInstance().getLoginUser();
            List<Post> posts = Posts.findAllFollowingsPosts(loginUser);
            Posts.displayAllShortVersion(posts);

            command = Functions.getCommand(availableCommands());
            if (command.equals(Commands.exit.name())) {
                exit();
            } else if (command.equals(Commands.select.name())) {
                Post chosenPost = Posts.select(posts);
                if (chosenPost != null) {
                    if (chosenPost.getUser().equals(loginUser))
                        new UserChoosePostMenu(chosenPost).execute();
                    else
                        new PostMenu(chosenPost).execute();
                }
            } else if (command.equals(Commands.like.name())) {
                Post chosenPost = Posts.select(posts);
                if (chosenPost != null)
                    Posts.like(loginUser, chosenPost);
            } else if (command.equals(Commands.unlike.name())) {
                Post chosenPost = Posts.select(posts);
                if (chosenPost != null)
                    Posts.unLike(loginUser, chosenPost);
            } else if (command.equals(Commands.search.name())) {
                List<User> foundUsers = Users.searchUserByUsername(Users.getUsername());
                if (!foundUsers.isEmpty())
                    new SearchMenu(foundUsers).execute();
            } else if (command.equals(Commands.add.name())) {
                Posts.add(Posts.getTitle(), Posts.getContent(), loginUser, Posts.getCreationDate());
            } else if (command.equals(Commands.profile.name())) {
                new LoginUserProfileMenu().execute();
            }
        }
    }

    @Override
    protected Set<String> availableCommands() {
        return new HashSet<>(Arrays.asList(
                Commands.select.name()
                , Commands.like.name()
                , Commands.unlike.name()
                , Commands.search.name()
                , Commands.add.name()
                , Commands.profile.name()
                , Commands.signout.name()
                , Commands.exit.name()));
    }
}
