package ir.maktab.project12.instagram.repositories;

import ir.maktab.project12.instagram.entities.Post;

public class PostRepository extends CrudRepository<Post,Long> {

    PostRepository postRepository;

    private PostRepository() {
    }

    public PostRepository getPostRepository() {
        if(postRepository==null){
            postRepository = new PostRepository();
        }
        return postRepository;
    }

    @Override
    protected Class<Post> getEntityClass() {
        return Post.class;
    }
}
