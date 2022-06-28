package com.i2p.employeemanagementsystem.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;

import javax.persistence.*;

/**
 * @author yakubabdi
 *
 */
@Entity
@Table(name = "user_details")
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userDescription;

    private String userStatus;

     @ManyToOne(cascade = CascadeType.ALL)
     @JsonIgnore
     @JoinColumn(name = "fk_user")
     private User user;
  
     // Setters and Getters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public User getUser() {
        return user;
    }
    
    

    public void setUser(User user) {
        this.user = user;
    }
}
