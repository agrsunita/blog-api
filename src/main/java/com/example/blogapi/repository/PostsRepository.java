package com.example.blogapi.repository;

import com.example.blogapi.entity.PostsData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface PostsRepository extends JpaRepository<PostsData,Integer> {

}
