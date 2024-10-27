package com.subham.JobWebApp.service;

import com.subham.JobWebApp.model.JobPost;
import com.subham.JobWebApp.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo repo;
    public List<JobPost> returnAllJobPosts() {
        return repo.returnAllJobPosts();
    }

    public void addJobPost(JobPost jobPost) {
        repo.addJobPost(jobPost);
    }
}
