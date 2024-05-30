package com.student.StudentManagement.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name="USER")
@Entity
public class User {
    @Id
    @Column(name="USER_ID")
    private String userId;

    @Column(name="USER_NAME")
    private String userName;

    @Column(name="PASSWORD")
    private String password;
    @Column(name="EMAIL")
    private String email;
    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name="LAST_NAME")
    private String lastName;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
