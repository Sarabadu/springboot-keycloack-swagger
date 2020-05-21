package com.sarabadu.blog.restapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/users")
public class UsersController {

    @GetMapping("/{username}/")
    public ResponseEntity<String> getUserbyUsername(@PathVariable() String username){
        return ResponseEntity.ok(String.format("hi user %s", username));
    }

    @GetMapping("/{username}/posts")
    public ResponseEntity<String> getUserPosts(@PathVariable() String username){
        return ResponseEntity.ok(String.format("user %s posts granted", username));
    }

    @PostMapping("/{username}/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createUserPost(@RequestBody String post , @PathVariable() String username) {
        return ResponseEntity.ok(String.format("user %s, created post: %s granted", username, post));
    }

    @GetMapping("/{username}/posts/{postId}")
    public ResponseEntity<String> getUserPosts(@PathVariable() String username,@PathVariable() String postId){
        return ResponseEntity.ok(String.format("user %s post %s granted", username,postId));
    }
}
