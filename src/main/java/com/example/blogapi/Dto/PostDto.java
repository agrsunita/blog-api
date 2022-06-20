package com.example.blogapi.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class PostDto {
    private int postId;
    private String postDescription;
    private String postTitle;
    private String postContent;
}
