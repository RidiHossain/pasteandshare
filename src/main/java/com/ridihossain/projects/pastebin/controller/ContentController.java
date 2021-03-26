package com.ridihossain.projects.pastebin.controller;


import com.ridihossain.projects.pastebin.api.model.ApiContent;
import com.ridihossain.projects.pastebin.data.entity.POST;
import com.ridihossain.projects.pastebin.data.repository.PostRepository;
import com.ridihossain.projects.pastebin.service.UrlGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContentController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UrlGeneratorService urlGeneratorService;

    @GetMapping("/pastebinpost")
    @ResponseBody
    public Iterable<POST> greeting() {
        return this.postRepository.findAll();
    }

    @GetMapping("/pastebinpost/{id}")
    @ResponseBody
    public POST greeting(@PathVariable String id) {
        return this.postRepository.findById(id).get();
    }

    @PostMapping("/pastebinpost")
    @ResponseBody
    public POST newGreeting(@RequestBody ApiContent apiContent) {
        POST newPost = new POST();
        newPost.setUrl(urlGeneratorService.generateUrl());
        newPost.setContent(apiContent.getContent());
        return this.postRepository.save(newPost);
    }
}
