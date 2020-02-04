package ir.maktab.project12.instagram.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title",nullable = false,length = 100)
    private String title;

    @Column(name = "content",nullable = false,length = 100)
    private String content;

    @Column(name = "creation_date")
    private Date creationDate;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "post" , fetch = FetchType.EAGER , cascade = CascadeType.ALL , orphanRemoval = true)
    private Set<Comment> comments;

    @ManyToMany
    @JoinTable(name = "likes_table"
            , joinColumns = @JoinColumn(name = "user_id")
            , inverseJoinColumns = @JoinColumn(name = "post_id"))
    private Set<User> usersLikedPost;

    public Post() {
        this.title = "";
        this.content = "";
        this.creationDate = new Date();
        this.user = new User();
        this.usersLikedPost = new HashSet<>();
        this.comments = new HashSet<>();
    }

    public Post(String title, String content , Date creationDate) {
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
        this.user = new User();
        this.usersLikedPost = new HashSet<>();
        this.comments = new HashSet<>();
    }

    public Post(String title, String content, Date creationDate, User user) {
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
        this.user = user;
        this.usersLikedPost = new HashSet<>();
        this.comments = new HashSet<>();
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Set<User> getUsersLikedPost() {
        return usersLikedPost;
    }

    public void setUsersLikedPost(Set<User> usersLikedPost) {
        this.usersLikedPost = usersLikedPost;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id) &&
                Objects.equals(title, post.title) &&
                Objects.equals(content, post.content) &&
                Objects.equals(user, post.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, content, user);
    }
}
