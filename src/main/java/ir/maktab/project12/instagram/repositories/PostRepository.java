package ir.maktab.project12.instagram.repositories;

import ir.maktab.project12.instagram.entities.Post;

public class PostRepository extends CrudRepository<Post,Long> {
    @Override
    protected Class<Post> getEntityClass() {
        return Post.class;
    }
}
