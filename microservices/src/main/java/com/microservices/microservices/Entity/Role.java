package com.microservices.microservices.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Builder
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int roleId;
    private String userId;
    private String role;

    @ManyToMany(mappedBy = "role")
    private List<User> users;
}
