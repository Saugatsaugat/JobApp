package com.saugat.jobapp.service;

import com.saugat.jobapp.model.JobPost;
import com.saugat.jobapp.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository repository;

    public void addJob(JobPost jobPost){
        repository.add(jobPost);
    }

    public List<JobPost> getAllJobs(){
        return repository.getAllJobs();
    }
}
