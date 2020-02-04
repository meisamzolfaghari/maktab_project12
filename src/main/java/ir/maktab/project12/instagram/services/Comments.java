package ir.maktab.project12.instagram.services;

import ir.maktab.project12.instagram.model.Comment;
import ir.maktab.project12.instagram.model.Post;
import ir.maktab.project12.instagram.model.User;
import ir.maktab.project12.instagram.repositories.CommentRepository;

import java.util.Date;
import java.util.Scanner;

public class Comments {

    public static void add(String content, Date creationDate, Post post, User user) {
        Comment comment = new Comment(content, creationDate, post, user);
        CommentRepository commentRepository = CommentRepository.getPostRepositoryDb();
        commentRepository.save(comment);
    }

    public static String getContent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\t\u29bf Content: ");
        return scanner.nextLine();

    }

    public static Date getCreationDate() {
        return new Date(System.currentTimeMillis());
    }
}
