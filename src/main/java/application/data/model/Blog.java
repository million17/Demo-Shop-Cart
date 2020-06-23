package application.data.model;

import javax.persistence.*;
import java.util.Date;

@Table
@Entity(name = "dbo_blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "blog_id")
    private int blogId;

    @Column(name = "title")
    private String title;

    @Column(name = "image_blog")
    private String imageBlog;

    @Column(name = "content")
    private String content;

    //Fetch Type = EAGER Sẽ không bị show hết 1 list các blog
    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "created_date")
    private Date createdDate;

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getImageBlog() {
        return imageBlog;
    }

    public void setImageBlog(String imageBlog) {
        this.imageBlog = imageBlog;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
