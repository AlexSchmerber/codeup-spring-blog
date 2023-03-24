package com.codeup.codeupspringblog.controllers;

import org.apache.coyote.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
}