package com.saugat.jobapp.repository;

import com.saugat.jobapp.model.JobPost;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class JobRepository {

    List<JobPost> jobs = new ArrayList<>(Arrays.asList(
            new JobPost(1, "Java Developer", "Full Stack Java Developer", 3, Arrays.asList("Java", "Angular", "VueJs")),
            new JobPost(2, "Python Developer", "Full Stack Python Developer", 3, Arrays.asList("Python", "React", "VueJs")),
            new JobPost(3, "Frontend Developer", "We are looking for frontend Developer", 3, Arrays.asList("React", "Angular", "VueJs")),
            new JobPost(4, "BackendDeveloper", "We are looking for backend Developer", 3, Arrays.asList("Java", "Python", "Angular", "VueJs"))
    ));

    public void add(JobPost jobPost){
        jobs.add(jobPost);
        System.out.println("New job added successfully.");
    }

    public List<JobPost> getAllJobs(){
        return jobs;
    }
}
