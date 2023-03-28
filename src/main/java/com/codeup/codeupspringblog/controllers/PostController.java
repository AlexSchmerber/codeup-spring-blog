package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.Post;
import com.codeup.codeupspringblog.repositories.PostRepository;
import lombok.AllArgsConstructor;
import org.apache.coyote.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
class PostController {

    private final PostRepository postDao;


//    @GetMapping("/posts")
//    public String postPage() {
//        return "/posts/show";
//    }
//
//    @GetMapping("/posts{id}")
//    public String postPageWithId(@PathVariable int id) {
//        return "Post With Id: " + id;
//    }

    @GetMapping("/posts/create")
    public String getCreatePost(Model model) {
        model.addAttribute("post", new Post());
        return "/posts/create";
    }

    @PostMapping("/posts/create")
    public String postCreatePost(@ModelAttribute Post post) {
        postDao.save(post);
        return "redirect:/show-post";
    }

    @GetMapping("/index-posts/{postId}")
    public String indexPost(Model model, @PathVariable long postId){
//        create new post using just id
        model.addAttribute("post", new Post(postId, "New Title 1", "New body 1"));
        return "/posts/index";
    }
    @GetMapping("/show-post")
    public String showPosts(Model model){
        model.addAttribute("postList", postDao.findAll());
        return "/posts/show";
    }
}

//    @GetMapping("/roll-dice")
//    public String rollDice(){
//        return "dice";
//    }
//    @GetMapping("/roll-dice/{number}")
//    public String rollDice(@PathVariable int number, Model model){
//        int randomDiceRoll = (int) Math.floor(Math.random() * (6 - 1) + 1);
//        String response;
//        if(number == randomDiceRoll){
//            response = "GOOD GUESS!";
//        } else {
//            response = "bad guess :(";
//        }
//        model.addAttribute("response", "You guessed: " + number + "\nThe correct answer was " + randomDiceRoll + "\n" + response);
//        return "result";
//    }