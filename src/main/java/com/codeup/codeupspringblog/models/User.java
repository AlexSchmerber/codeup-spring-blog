package com.codeup.codeupspringblog.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(nullable = false, length = 100)
    String username;

    @Column(nullable = false)
    String email;

    @Column(nullable = false)
    String password;

    @ToString.Exclude
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Post> posts;


    public User(long l, String user1, String s, String password) {
        this.id = l;
        this.username = user1;
        this.email = s;
        this.password = password;
    }
}
