package com.example.blogapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PostsData {

    @Id
    @GeneratedValue
    private int postId;

    @NotBlank(message = "Desciption is mandatory !")
    private String postDescription;
//    @Column(name = "Title",nullable = false)
    private String postTitle;
//    @Column(name = "Content",nullable = false)
    private String postContent;

}
