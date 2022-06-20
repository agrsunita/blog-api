package com.example.blogapi.service;

import com.example.blogapi.Dto.PostDto;
import com.example.blogapi.entity.PostsData;
import com.example.blogapi.exception.BlogNotFoundException;
import com.example.blogapi.exception.GlobalControllerExceptions;
import com.example.blogapi.exception.ResourceNotFound;
import com.example.blogapi.repository.PostsRepository;
import com.fasterxml.jackson.core.JsonParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PostsService implements IPostsService{

    @Autowired
    PostsRepository postsRepository;

    @Autowired
    PostDto postDto;
//    private HttpInputMessage httpInputMessage;

    @Override
    public PostDto addPosts(PostDto postDto){
        //    convert DTO to Entrity
        PostsData postsData = new PostsData();
        PostsData postData = postsRepository.save(convertToData(postDto));
        return convertToDto(postData);


//        postsData.setPostContent(postDto.getPostContent());
//        postsData.setPostTitle(postDto.getPostTitle());
//        postsData.setPostDescription(postDto.getPostDescription());

//        PostsData postData = postsRepository.save(convertToData(postDto));
//        return convertToDto(postData);
//        try {
//            PostsData postData = postsRepository.save(convertToData(postDto));
//            return convertToDto(postData);
//        }catch (Exception ex){
//            throw new HttpMessageNotReadableException("error", (HttpInputMessage) postDto);
//        }
//        log.info(postDto.toString());
//        return convertToDto(postData);


        //    convert Entity to DTO
//        postDto.setPostTitle(postData.getPostTitle());
//        postDto.setPostContent(postData.getPostContent());
//        postDto.setPostDescription(postData.getPostDescription());
//        log.info(postDto.toString());

//        throw new HttpMessageNotReadableException("Blog ID is not found",httpInputMessage);
//        return convertToDto(postData);
//        return postDto;

    }



//    how can I copy this list to another one-one ? also why all the items are showing same in get call ? butin DB,all are different.
    @Override
    public List<PostDto> getPosts() {
       List<PostsData> postsData = postsRepository.findAll();
//       List<PostDto> postDtos = new ArrayList<>();
//        for (PostsData postData: postsData) {
//            System.out.println(postData);
//            postDtos.add(convertToDto(postData));
//        }
//        return postDtos;
      return postsData.stream().map(postsData1 -> convertToDto(postsData1)).collect(Collectors.toList());

    }

//    Service layer is throwing an exception to controller layer but controller layer is throwing and handling a proper message.
    @Override
    public PostDto getPostsById(int postId) {
//        PostsData postsData = postsRepository.findById(postId).orElseThrow(() -> new ResourceNotFound("Post","postId",postId));
//        PostsData postsData = postsRepository.findById(postId).orElseThrow(() -> new ResourceNotFound("Exception"));
//        return convertToDto(postsData);
        Optional<PostsData> postsData = postsRepository.findById(postId);
        if(postsData.isPresent()){
            return convertToDto(postsRepository.findById(postId).get());
        }
        throw new EntityNotFoundException("Blog is not found - " + postId );
//        throw new BlogNotFoundException("Blog is not found - " , postId  );


    }

    private PostDto convertToDto(PostsData postsData){

       postDto.setPostDescription(postsData.getPostDescription());
       postDto.setPostTitle(postsData.getPostTitle());
       postDto.setPostContent(postsData.getPostContent());
       return postDto;

    }

    private PostsData convertToData(PostDto postDto){
        PostsData postsData = new PostsData();
        postsData.setPostDescription(postDto.getPostDescription());
        postsData.setPostTitle(postDto.getPostTitle());
        postsData.setPostContent(postDto.getPostContent());
        return postsData;

    }
}
