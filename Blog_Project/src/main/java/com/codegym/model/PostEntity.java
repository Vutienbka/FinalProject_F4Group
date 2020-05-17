package com.codegym.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "post", schema = "project", catalog = "")
public class PostEntity {
    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "publishedStatus")
    private byte publishedStatus;
    @Column(name = "publishTime")
    private Timestamp publishTime;
    @Column(name = "createdAt")
    private Timestamp createdAt;
    @Column(name = "updatedAt")
    private Timestamp updatedAt;
    @Column(name = "content")
    private String content;
    @OneToMany(mappedBy = "postByPostId")
    private List<CommentEntity> commentsById;
    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id", nullable = false)
    private UserEntity userByUserId;
    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    @JoinTable(name = "post_category",joinColumns = @JoinColumn(name = "postId"),inverseJoinColumns = @JoinColumn(name="categoryId"))
    private List<CategoryEntity> categoryEntityList;
    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    @JoinTable(name = "post_tag",joinColumns = @JoinColumn(name = "postId"),inverseJoinColumns = @JoinColumn(name="tagId"))
    private List<TagEntity> tagEntityList;
    private List<PostLikeEntity> postLikesById;
    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    @JoinTable(name = "media_post",joinColumns = @JoinColumn(name = "postId"),inverseJoinColumns = @JoinColumn(name="mediaId"))
    private List<MediaEntity> mediaEntityList;

    public List<TagEntity> getTagEntityList() {
        return tagEntityList;
    }

    public void setTagEntityList(List<TagEntity> tagEntityList) {
        this.tagEntityList = tagEntityList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public byte getPublishedStatus() {
        return publishedStatus;
    }

    public void setPublishedStatus(byte publishedStatus) {
        this.publishedStatus = publishedStatus;
    }

    public Timestamp getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Timestamp publishTime) {
        this.publishTime = publishTime;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<CommentEntity> getCommentsById() {
        return commentsById;
    }

    public void setCommentsById(List<CommentEntity> commentsById) {
        this.commentsById = commentsById;
    }

    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }

    public List<CategoryEntity> getCategoryEntityList() {
        return categoryEntityList;
    }

    public void setCategoryEntityList(List<CategoryEntity> categoryEntityList) {
        this.categoryEntityList = categoryEntityList;
    }

    @OneToMany(mappedBy = "postByPostId")
    public List<PostLikeEntity> getPostLikesById() {
        return postLikesById;
    }

    public void setPostLikesById(List<PostLikeEntity> postLikesById) {
        this.postLikesById = postLikesById;
    }
}
