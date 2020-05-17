package com.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category", schema = "project")
public class CategoryEntity {
    private long id;
    @Column(name = "name")
    private String name;
    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "categoryEntityList",cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    private List<PostEntity> postEntityList;
    @ManyToOne
    @JoinColumn(name = "parentId", referencedColumnName = "id")
    private CategoryEntity categoryByParentId;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<PostEntity> getPostEntityList() {
        return postEntityList;
    }

    public void setPostEntityList(List<PostEntity> postEntityList) {
        this.postEntityList = postEntityList;
    }

    public CategoryEntity getCategoryByParentId() {
        return categoryByParentId;
    }

    public void setCategoryByParentId(CategoryEntity categoryByParentId) {
        this.categoryByParentId = categoryByParentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
