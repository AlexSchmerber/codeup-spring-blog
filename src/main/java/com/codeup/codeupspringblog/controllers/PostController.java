package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.Post;
import org.apache.coyote.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
class PostController {
    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    @ResponseBody
    public String postPage() {
        return "Post Index Page";
    }

    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String postPageWithId(@PathVariable int id) {
        return "Post With Id: " + id;
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.GET)
    @ResponseBody
    public String getCreatePost() {
        return "Create Post";
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
    @ResponseBody
    public String postCreatePost() {
        return "Create Post";
    }

    @GetMapping("/roll-dice")
    public String rollDice(){
        return "dice";
    }
    @GetMapping("/roll-dice/{number}")
    public String rollDice(@PathVariable int number, Model model){
        int randomDiceRoll = (int) Math.floor(Math.random() * (6 - 1) + 1);
        String response;
        if(number == randomDiceRoll){
            response = "GOOD GUESS!";
        } else {
            response = "bad guess :(";
        }
        model.addAttribute("response", "You guessed: " + number + "\nThe correct answer was " + randomDiceRoll + "\n" + response);
        return "result";
    }
    @GetMapping("/index-posts/{postId}")
    public String indexPost(Model model, @PathVariable long postId){
//        create new post using just id
        model.addAttribute("post", new Post(postId, "New Title 1", "New body 1"));
        return "/posts/index";
    }
    @GetMapping("/show-post")
    public String showPosts(Model model){
//        create list of posts
        List<Post> postList = new ArrayList<>();
        postList.add(new Post(1, "Example Title 1", "Body text"));
        postList.add(new Post(2, "Example Title 2", "Body text"));
        postList.add(new Post(3, "Example Title 3", "Body text"));
        model.addAttribute("postList", postList);
        return "/posts/show";
    }
}