package com.bloggish.springbloggish.repositories;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bloggish.springbloggish.entities.Category;
import com.bloggish.springbloggish.entities.Post;
import com.bloggish.springbloggish.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer> {

    List<Post> findByUser(User user);

    List<Post> findByCategory(Category user);

}
