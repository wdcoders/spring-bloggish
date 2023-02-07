package com.bloggish.springbloggish.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bloggish.springbloggish.payloads.PostDto;
import com.bloggish.springbloggish.services.PostService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    // POST:: CREATE CATEGORY
    @PostMapping("/{categoryId}/{userId}")
    private ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto,
            @PathVariable Integer categoryId, @PathVariable Integer userId) {
        PostDto pDto = this.postService.createPost(postDto, categoryId, userId);
        return new ResponseEntity<PostDto>(pDto, HttpStatus.CREATED);
    }

    // GET: SINGLE CATEGORY
    @GetMapping("/{postId}")
    private ResponseEntity<PostDto> getPostById(@PathVariable Integer postId) {
        PostDto postDto = this.postService.getPostById(postId);
        return ResponseEntity.ok(postDto);
    }

    // GET: SINGLE CATEGORY
    @GetMapping("/by-category/{categoryId}")
    private ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Integer categoryId) {
        List<PostDto> postDto = this.postService.getPostByCategory(categoryId);
        return ResponseEntity.ok(postDto);
    }
}
