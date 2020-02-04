package ir.maktab.project12.instagram.userinterface.menus;

import ir.maktab.project12.instagram.core.share.AuthenticationService;
import ir.maktab.project12.instagram.core.share.Commands;
import ir.maktab.project12.instagram.model.Post;
import ir.maktab.project12.instagram.model.User;
import ir.maktab.project12.instagram.services.Comments;
import ir.maktab.project12.instagram.services.Functions;
import ir.maktab.project12.instagram.services.Posts;
import ir.maktab.project12.instagram.services.Users;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UserChoosePostMenu extends Menu {

    private Post chosenPost;

    public UserChoosePostMenu(Post chosenPost) {
        this.chosenPost = chosenPost;
    }

    @Override
    public void execute() {
        if (chosenPost == null)
            return;
        String command = "";
        while (!command.equals(Commands.back.name())) {
            User loginUser = AuthenticationService.getInstance().getLoginUser();
            Posts.displayFullVersion(chosenPost);

            command = Functions.getCommand(availableCommands());
            if (command.equals(Commands.exit.name())) {
                exit();
            } else if (command.equals(Commands.edit.name())) {
                new EditPostMenu(chosenPost).execute();
            } else if (command.equals(Commands.like.name())) {
                Posts.like(loginUser, chosenPost);
            } else if (command.equals(Commands.unlike.name())) {
                Posts.unLike(loginUser, chosenPost);
            } else if (command.equals(Commands.addcomment.name())) {
                Comments.add(Comments.getContent(), Comments.getCreationDate(), chosenPost, loginUser);
            } else if (command.equals(Commands.signout.name())) {
                Users.signOut();
                new FirstMenu().execute();
            }
        }
    }

    @Override
    protected Set<String> availableCommands() {
        Set<String> commands = new HashSet<>(Arrays.asList(
                Commands.edit.name()
                , Commands.addcomment.name()
                , Commands.back.name()
                , Commands.signout.name()
                , Commands.exit.name()));
        User loginUser = AuthenticationService.getInstance().getLoginUser();
        if (chosenPost.getUsersLikedPost().contains(loginUser))
            commands.add(Commands.unlike.name());
        else
            commands.add(Commands.like.name());

        return commands;
    }
}
