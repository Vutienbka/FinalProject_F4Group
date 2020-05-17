package com.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "media", schema = "project")
public class MediaEntity {
    private long id;
    private String srcMedia;
    private UserEntity userByUserId;
    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "mediaEntityList",cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    private List<PostEntity> postEntityList;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "srcMedia")
    public String getSrcMedia() {
        return srcMedia;
    }

    public void setSrcMedia(String srcMedia) {
        this.srcMedia = srcMedia;
    }

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id", nullable = false)
    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }

    public List<PostEntity> getPostEntityList() {
        return postEntityList;
    }

    public void setPostEntityList(List<PostEntity> postEntityList) {
        this.postEntityList = postEntityList;
    }
}
