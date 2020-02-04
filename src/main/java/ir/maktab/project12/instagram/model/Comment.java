package ir.maktab.project12.instagram.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false , length = 100)
    private String content;

    @Column(name = "creation_date")
    private Date creationDate;

    @ManyToOne
    private Post post;

    @ManyToOne
    private User user;

    public Comment() {
        this.content = "";
        this.creationDate = new Date();
        this.post = new Post();
        this.user = new User();
    }

    public Comment(String content , Date creationDate) {
        this.content = content;
        this.creationDate = creationDate;
        this.post = new Post();
        this.user = new User();
    }

    public Comment(String content, Date creationDate, Post post, User user) {
        this.content = content;
        this.creationDate = creationDate;
        this.post = post;
        this.user = user;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", creationDate=" + creationDate +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(id, comment.id) &&
                Objects.equals(content, comment.content) &&
                Objects.equals(post, comment.post) &&
                Objects.equals(user, comment.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, post, user);
    }
}
