package com.bloggish.springbloggish.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bloggish.springbloggish.entities.Category;
import com.bloggish.springbloggish.entities.Post;
import com.bloggish.springbloggish.entities.User;
import com.bloggish.springbloggish.exceptions.ResourceNotFoundException;
import com.bloggish.springbloggish.payloads.PostDto;
import com.bloggish.springbloggish.repositories.CategoryRepo;
import com.bloggish.springbloggish.repositories.PostRepo;
import com.bloggish.springbloggish.repositories.UserRepo;

@Service
public class PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    // create
    public PostDto createPost(PostDto postDto, Integer categoryId, Integer userId) {
        Category category = this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "Id", categoryId));
        User user = this.userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        Post post = this.modelMapper.map(postDto, Post.class);
        post.setCategory(category);
        post.setUser(user);
        Post savePost = this.postRepo.save(post);
        return this.postToDto(savePost);
    }

    // get all
    public List<PostDto> getPostByCategory(Integer categoryId) {
        Category category = this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "Id", categoryId));

        List<Post> posts = this.postRepo.findByCategory(category);

        List<PostDto> postDtos = posts.stream().map(post -> this.postToDto(post)).collect(Collectors.toList());

        return postDtos;
    }

    // get all
    public PostDto getPostById(Integer postId) {
        Post post = this.postRepo.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "Id", postId));
        return this.postToDto(post);
    }

    // get all
    public List<PostDto> getAllPost() {
        List<Post> posts = this.postRepo.findAll();
        List<PostDto> uPostDtos = posts.stream().map(c -> this.postToDto(c))
                .collect(Collectors.toList());
        return uPostDtos;
    }

    private Post dtoToPost(PostDto postDto) {
        Post post = this.modelMapper.map(postDto, Post.class);
        return post;
    }

    private PostDto postToDto(Post category) {
        PostDto postDto = this.modelMapper.map(category, PostDto.class);
        return postDto;
    }
}
