package ir.maktab.project12.instagram.services;

import ir.maktab.project12.instagram.core.config.hibernate.HibernateUtil;
import ir.maktab.project12.instagram.model.Post;
import ir.maktab.project12.instagram.model.User;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

class PostsTest {

    private Session session = HibernateUtil.getSessionH2();

    @Test
    void seeAllFollowingPosts() {
        User myUser = new User("user1", "123");
        myUser.setPosts(new HashSet<>(Arrays.asList(
                new Post("t1", "c1", new Date(System.currentTimeMillis()))
                , new Post("t2", "c2", new Date(System.currentTimeMillis()))
                , new Post("t3", "c3", new Date(System.currentTimeMillis()))
        )));
        User expected = myUser;
        session.save(myUser);
        User actual = session.get(User.class , myUser.getId());
        assertEquals(expected,actual);
    }
}