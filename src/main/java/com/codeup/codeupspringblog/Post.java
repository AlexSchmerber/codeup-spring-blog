package com.codeup.codeupspringblog;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    long id;
    String title;
    String body;
}
