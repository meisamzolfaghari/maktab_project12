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

public class EditPostMenu extends Menu {

    private Post chosenPost;

    public EditPostMenu(Post chosenPost) {
        this.chosenPost = chosenPost;
    }

    @Override
    public void execute() {
        if (chosenPost == null)
            return;
        String command = "";
        while (!command.equals(Commands.back.name())) {
            Posts.displayFullVersion(chosenPost);

            command = Functions.getCommand(availableCommands());
            if (command.equals(Commands.exit.name())) {
                exit();
            } else if (command.equals(Commands.title.name())) {
                Posts.editTitle(Posts.getNewTitle(), chosenPost);
            } else if (command.equals(Commands.content.name())) {
                Posts.editContent(Posts.getNewContent(), chosenPost);
            } else if (command.equals(Commands.delete.name())) {
                Posts.delete(chosenPost);
                break;
            } else if (command.equals(Commands.signout.name())) {
                Users.signOut();
                new FirstMenu().execute();
            }
        }
    }

    @Override
    protected Set<String> availableCommands() {
        return new HashSet<>(Arrays.asList(
                Commands.title.name()
                , Commands.content.name()
                , Commands.delete.name()
                , Commands.back.name()
                , Commands.signout.name()
                , Commands.exit.name()));
    }
}
