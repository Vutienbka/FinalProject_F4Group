package com.codegym.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role", schema = "project")
public class RoleEntity {
    private long id;
    private String roleName;
    private List<UserEntity> userEntityList;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "roleName")
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    @JoinTable(name = "user_role",joinColumns = @JoinColumn(name = "roleId"),inverseJoinColumns = @JoinColumn(name="userId"))
    public List<UserEntity> getUserEntityList() {
        return userEntityList;
    }

    public void setUserEntityList(List<UserEntity> userEntityList) {
        this.userEntityList = userEntityList;
    }
}
