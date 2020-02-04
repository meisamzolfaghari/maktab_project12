package ir.maktab.project12.instagram.repositories;

import ir.maktab.project12.instagram.core.config.hibernate.HibernateUtil;
import ir.maktab.project12.instagram.model.Comment;
import org.hibernate.Session;

public class CommentRepository extends CrudRepository<Comment,Long> {

    private static CommentRepository commentRepositoryDb;
    private static CommentRepository commentRepositoryH2;

    private CommentRepository(Session session) {
        super(session);
    }

    public static CommentRepository getPostRepositoryDb() {
        if(commentRepositoryDb ==null){
            commentRepositoryDb = new CommentRepository(HibernateUtil.getSessionDb());
        }
        return commentRepositoryDb;
    }

    public static CommentRepository getPostRepositoryH2() {
        if(commentRepositoryH2 ==null){
            commentRepositoryH2 = new CommentRepository(HibernateUtil.getSessionH2());
        }
        return commentRepositoryH2;
    }

    @Override
    protected Class<Comment> getEntityClass() {
        return Comment.class;
    }
}