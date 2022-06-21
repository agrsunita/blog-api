package com.example.blogapi.controller;

import com.example.blogapi.Dto.PostDto;
import com.example.blogapi.exception.BlogNotFoundException;
import com.example.blogapi.service.IPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
//import javax.validation.Valid;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    IPostsService postsService;

    @Autowired
    PostDto postDto;

//    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<PostDto> addPosts(@RequestBody PostDto postDto){
        return new ResponseEntity<>(postsService.addPosts(postDto),HttpStatus.CREATED); //sends 201 status code
//        return ResponseEntity.ok(postsService.addPosts(postDto)); //sends default 200 status code
    }

    @GetMapping
    public List<PostDto> getPosts(){
        return postsService.getPosts();
    }

//    what is the difference if i just return a class object and a response entity ?
//    @GetMapping("/{postId}")
//    public PostDto getPostsById(@PathVariable("postId") int postId){
//        return postsService.getPostsById(postId);
//    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostDto> getPostsById(@PathVariable("postId") int postId) {
        return ResponseEntity.ok(postsService.getPostsById(postId));
//        try{
//           return new ResponseEntity(postsService.getPostsById(postId),HttpStatus.OK);
//        }catch (BlogNotFoundException blogNotFoundException){
//            return new ResponseEntity(blogNotFoundException.getMessage(),HttpStatus.NOT_FOUND);
//        }
    }

    @DeleteMapping("/{postId}")
    public String deletePostById(@PathVariable("postId") int postId){
        return postsService.deleteByPostId(postId);
    }

    @GetMapping("/postsWithPagination")
    public List<PostDto> getAllPostsWithPagination(@RequestParam(value = "pageNo",defaultValue = "0") int pageNo,
                                                             @RequestParam(value = "pageSize",defaultValue = "5") int pageSize){
        return postsService.getAllPostsWithPagination(pageNo,pageSize);
    }


}
