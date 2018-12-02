package com.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_roles")
public class UserRole implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_role_id", nullable = false)
    private int userRoleId;

    @ManyToOne(targetEntity = com.entity.User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User user;
    //private User userRoleByUserName;

    @Basic
    @Column(name = "role", nullable = false, length = 45)
    private String role;

    public UserRole(){

    }

    public UserRole(User user, String role) {
        this.user  = user ;
        this.role = role;
    }

    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    /*@ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    public User getUserRoleByUserName() {
        return userRoleByUserName;
    }

    public void setUserRoleByUserName(User userRoleByUserName) {
        this.userRoleByUserName = userRoleByUserName;
    }*/

    public User getUserRole() {
        return user;
    }

    public void setUserRole(User user) {
        this.user = user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
