package ir.maktab.project12.instagram.repositories;

import ir.maktab.project12.instagram.core.config.hibernate.HibernateUtil;
import ir.maktab.project12.instagram.model.Post;
import org.hibernate.Session;

public class PostRepository extends CrudRepository<Post,Long> {

    private static PostRepository postRepositoryDb;
    private static PostRepository postRepositoryH2;

    private PostRepository(Session session) {
        super(session);
    }

    public static PostRepository getPostRepositoryDb() {
        if(postRepositoryDb ==null){
            postRepositoryDb = new PostRepository(HibernateUtil.getSessionH2());
        }
        return postRepositoryDb;
    }

    public static PostRepository getPostRepositoryH2() {
        if(postRepositoryH2 ==null){
            postRepositoryH2 = new PostRepository(HibernateUtil.getSessionH2());
        }
        return postRepositoryH2;
    }

    @Override
    protected Class<Post> getEntityClass() {
        return Post.class;
    }
}
