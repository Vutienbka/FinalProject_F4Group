package com.codegym.Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "user", schema = "project")
public class UserEntity {
    private long id;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String mobile;
    private String email;
    private Timestamp registeredAt;
    private Timestamp lastLogin;
    private String srcAvatar;
    private List<CommentEntity> commentsById;
    private List<MediaEntity> mediaById;

    private List<PostEntity> postsById;


    private List<RoleEntity> roleEntityList;
    private List<PostLikeEntity> postLikesById;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "userName")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "lastName")
    public String getLastName() {
        return lastName;
    }
    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "userEntityList",cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    public List<RoleEntity> getRoleEntityList() {
        return roleEntityList;
    }

    public void setRoleEntityList(List<RoleEntity> roleEntityList) {
        this.roleEntityList = roleEntityList;
    }

    @OneToMany(mappedBy = "userByUserId")
    public List<PostEntity> getPostsById() {
        return postsById;
    }

    public void setPostsById(List<PostEntity> postsById) {
        this.postsById = postsById;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "mobile")
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "registeredAt")
    public Timestamp getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(Timestamp registeredAt) {
        this.registeredAt = registeredAt;
    }

    @Column(name = "lastLogin")
    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Column(name = "srcAvatar")
    public String getSrcAvatar() {
        return srcAvatar;
    }

    public void setSrcAvatar(String srcAvatar) {
        this.srcAvatar = srcAvatar;
    }

    @OneToMany(mappedBy = "userByUserId")
    public List<CommentEntity> getCommentsById() {
        return commentsById;
    }

    public void setCommentsById(List<CommentEntity> commentsById) {
        this.commentsById = commentsById;
    }
//
    @OneToMany(mappedBy = "userByUserId")
    public List<MediaEntity> getMediaById() {
        return mediaById;
    }

    public void setMediaById(List<MediaEntity> mediaById) {
        this.mediaById = mediaById;
    }


    @OneToMany(mappedBy = "userByUserId")
    public List<PostLikeEntity> getPostLikesById() {
        return postLikesById;
    }

    public void setPostLikesById(List<PostLikeEntity> postLikesById) {
        this.postLikesById = postLikesById;
    }
}
