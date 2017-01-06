package com.medicare.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.medicare.models.Post;
import com.medicare.services.NotificationService;
import com.medicare.services.PostService;

@Controller
public class PostsController {
        @Autowired
        private PostService postService;

        @Autowired
        private NotificationService notifyService;

        @RequestMapping("/posts/view/{id}")
        public String view(@PathVariable("id") Long id, Model model) {
            Post post = postService.findById(id);
            if (post == null) {
                notifyService.addErrorMessage("Cannot find post #" + id);
                return "redirect:/";
            }
            model.addAttribute("post", post);
            return "posts/view";
        }
}