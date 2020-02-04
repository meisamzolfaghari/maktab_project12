package ir.maktab.project12.instagram.services;

import ir.maktab.project12.instagram.core.share.Colors;
import ir.maktab.project12.instagram.model.Post;
import ir.maktab.project12.instagram.model.User;
import ir.maktab.project12.instagram.repositories.PostRepository;

import java.util.*;

public class Posts {

    public static void displayAllShortVersion(List<Post> postList) {
        if (postList.isEmpty()) return;

        System.out.println("------------------------------------------------------------------------------------");
        postList.forEach(post -> System.out.println(Colors.getAnsiYellow()
                + "------------------------------------------------------------------------------------"
                + "\nID= " + post.getId()
                + " , Title= '" + post.getTitle()
                + "' , Content= '" + post.getContent()
                + "' , User= '" + post.getUser()
                + "' , Likes= '" + post.getUsersLikedPost().size()
                + "'\n------------------------------------------------------------------------------------"
                + Colors.getAnsiReset()));
    }

    public static void displayShortVersion(Post post) {
        System.out.println(Colors.getAnsiYellow()
                + "------------------------------------------------------------------------------------"
                + "\nID= " + post.getId()
                + " , Title= '" + post.getTitle()
                + "' , Content= '" + post.getContent()
                + "' , User= '" + post.getUser()
                + "' , Likes= '" + post.getUsersLikedPost().size()
                + "' , Comments= '" + post.getComments()
                + "'\n------------------------------------------------------------------------------------"
                + Colors.getAnsiReset());
    }

    public static void displayFullVersion(Post post) {
        System.out.println(Colors.getAnsiYellow()
                + "------------------------------------------------------------------------------------"
                + "\nID= " + post.getId()
                + " , Title= '" + post.getTitle()
                + "' , Content= '" + post.getContent()
                + "' , User= '" + post.getUser()
                + "' , Likes= '" + post.getUsersLikedPost()
                + "' , Comments= '" + post.getComments()
                + "' , Creation Date= '" + post.getCreationDate()
                + "'\n------------------------------------------------------------------------------------"
                + Colors.getAnsiReset());
    }

    public static List<Post> findAllFollowingsPosts(User user) {
        PostRepository postRepository = PostRepository.getPostRepositoryDb();
        List<Post> posts = postRepository.findAll();

        List<Post> followingsPosts = (List<Post>) posts.stream()
                .filter(post -> (post.getUser().equals(user) || user.getFollowing().contains(post.getUser())));

        followingsPosts.sort(Comparator.comparing(Post::getCreationDate));
        return followingsPosts;
    }

    public static void add(String title, String content, User user, Date creationDate) {
        if (title == null || content == null || user == null || creationDate == null)
            return;
        Post post = new Post(title, content, creationDate, user);
        PostRepository postRepository = PostRepository.getPostRepositoryDb();
        postRepository.save(post);
    }

    public static Post select(List<Post> posts) {
        if (posts.isEmpty()) return null;

        Long id;
        Scanner scanner = new Scanner(System.in);
        id = scanner.nextLong();
        for (Post post : posts)
            if (post.getId().equals(id))
                return post;
        System.out.println(Colors.getAnsiRed() + "\t\u274c Invalid ID!" + Colors.getAnsiReset());
        return null;
    }

    public static void like(User user, Post chosenPost) {
        if (chosenPost == null) return;
        Set<User> usersLikedPost = chosenPost.getUsersLikedPost();
        usersLikedPost.add(user);
        chosenPost.setUsersLikedPost(usersLikedPost);
        PostRepository postRepository = PostRepository.getPostRepositoryDb();
        postRepository.update(chosenPost);
    }

    public static void unLike(User user, Post chosenPost) {
        if (chosenPost == null || user == null) return;
        Set<User> usersLikedPost = chosenPost.getUsersLikedPost();
        usersLikedPost.remove(user);
        chosenPost.setUsersLikedPost(usersLikedPost);
        PostRepository postRepository = PostRepository.getPostRepositoryDb();
        postRepository.update(chosenPost);
    }

    public static void editTitle(String newTitle, Post post) {
        if (newTitle == null || post == null) return;
        post.setTitle(newTitle);
        PostRepository postRepository = PostRepository.getPostRepositoryDb();
        postRepository.update(post);
    }

    public static void editContent(String newContent, Post post) {
        if (newContent == null || post == null) return;
        post.setContent(newContent);
        PostRepository postRepository = PostRepository.getPostRepositoryDb();
        postRepository.update(post);
    }

    public static String getTitle() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\t\u29bf Title: ");
        return scanner.nextLine();
    }


    public static String getContent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\t\u29bf Content: ");
        return scanner.nextLine();
    }

    public static Date getCreationDate() {
        return new Date(System.currentTimeMillis());
    }

    public static String getNewTitle() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\t\u29bf New Title: ");
        return scanner.nextLine();
    }


    public static String getNewContent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\t\u29bf New Content: ");
        return scanner.nextLine();
    }

    public static void delete(Post chosenPost) {
        PostRepository postRepository = PostRepository.getPostRepositoryDb();
        postRepository.remove(chosenPost);
    }
}
