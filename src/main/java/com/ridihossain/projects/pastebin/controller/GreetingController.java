package com.ridihossain.projects.pastebin.controller;

import com.ridihossain.projects.pastebin.api.model.ApiContent;
import com.ridihossain.projects.pastebin.data.entity.POST;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class GreetingController {

    @Autowired
    RestTemplateBuilder builder;

    @GetMapping("/pastebin")
    public String index(Model model) {
        model.addAttribute("apiContent", new ApiContent());
        return "postForm";
    }

    @PostMapping("/pastebinpostfromform")
    public String index(@ModelAttribute ApiContent apiContent, Model model) {
        RestTemplate restTemplate = builder.build();
        POST newPost = restTemplate.postForObject("http://localhost:80/pastebinpost", apiContent, POST.class );
        model.addAttribute("url", newPost.getUrl());
        model.addAttribute("content", newPost.getContent());

        return "successForm";
    }


}
