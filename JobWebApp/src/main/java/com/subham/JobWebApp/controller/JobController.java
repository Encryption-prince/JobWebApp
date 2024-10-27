package com.subham.JobWebApp.controller;

import com.subham.JobWebApp.model.JobPost;
import com.subham.JobWebApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class JobController {

    @Autowired
    private JobService service;

    @GetMapping({"/","home"})
    public String home(){
        return "home";
    }

    @GetMapping("/viewalljobs")
    public String viewallJobs(Model model){
        List<JobPost> jobPosts = service.returnAllJobPosts();
        model.addAttribute("jobPosts",jobPosts);
        return "viewalljobs";
    }

    @GetMapping("/addjob")
    public String addJob(){
        return "addjob";
    }

    @PostMapping("/handleForm")
    public String handleAddJobForm(JobPost jobPost,Model model) {
        model.addAttribute("jobPost", jobPost);
        service.addJobPost(jobPost);
        //System.out.println(jobPost);
        return "success";

    }
}
