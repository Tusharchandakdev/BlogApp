package com.BlogApp.repositories;

import com.BlogApp.entities.Category;
import com.BlogApp.entities.Post;
import com.BlogApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post,Integer> {

    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);

    List<Post> findByTitleContaining(String title);



}
