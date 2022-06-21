package com.example.blogapi.service;

import com.example.blogapi.Dto.PostDto;
import com.example.blogapi.exception.BlogNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IPostsService {

    PostDto addPosts(PostDto postDto);

    List<PostDto> getPosts();

    PostDto getPostsById(int postId) throws BlogNotFoundException;

    String deleteByPostId(int postId);


    List<PostDto> getAllPostsWithPagination(int pageNo, int pageSize);
}
