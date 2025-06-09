package com.saugat.jobapp.service;

import com.saugat.jobapp.model.JobPost;
import com.saugat.jobapp.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository repository;

    public void addJob(JobPost jobPost){
        repository.save(jobPost);
    }

    public List<JobPost> getAllJobs(){
        return repository.findAll();
    }

    public JobPost getJob(int jobId){
        return repository.findById(jobId).orElse(null);
    }

    public void updateJob(JobPost jobPost){
        repository.save(jobPost);
    }

    public void deleteJob(int jobId){
        repository.deleteById(jobId);
    }

    public void loadData(){
            List<JobPost> jobs = new ArrayList<>(Arrays.asList(
            new JobPost(1, "Java Developer", "Full Stack Java Developer", 3, Arrays.asList("Java", "Angular", "VueJs")),
            new JobPost(2, "Python Developer", "Full Stack Python Developer", 3, Arrays.asList("Python", "React", "VueJs")),
            new JobPost(3, "Frontend Developer", "We are looking for frontend Developer", 3, Arrays.asList("React", "Angular", "VueJs")),
            new JobPost(4, "BackendDeveloper", "We are looking for backend Developer", 3, Arrays.asList("Java", "Python", "Angular", "VueJs"))
    ));
           repository.saveAll(jobs);
           System.out.println("Data loaded successfully");
    }

    public List<JobPost> searchJob(String keyword) {
        return repository.findByPostDescContainingIgnoreCaseOrPostProfileContaining(keyword, keyword);
    }
}
