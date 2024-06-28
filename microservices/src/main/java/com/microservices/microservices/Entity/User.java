package com.microservices.microservices.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    private String userId;
    private  String name;
    private String email;
    private  String about;

  @Transient
    private List<Rating> ratings=new ArrayList<>();

    @Transient
    private List<Role> roles=new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "User_Role",joinColumns = {@JoinColumn(name = "userId")},inverseJoinColumns = {@JoinColumn(name = "roleId")})
    private List<Role> role;
}
