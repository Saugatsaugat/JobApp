package com.saugat.jobapp.controller;

import com.saugat.jobapp.model.JobPost;
import com.saugat.jobapp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
public class JobRestController {

    @Autowired
    private JobService service;

    @GetMapping("jobs")
    public List<JobPost> getJobs(){
        return service.getAllJobs();
    }

    @GetMapping("job/{jobId}")
    public JobPost getJob(@PathVariable int jobId){
        return service.getJob(jobId);
    }

    @PostMapping("job")
    public JobPost addJob(@RequestBody JobPost jobPost){
        service.addJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @PutMapping("job")
    public JobPost updateJob(@RequestBody JobPost jobPost){
        service.updateJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @DeleteMapping("job/{jobId}")
    public void deleteJob(@PathVariable int jobId){
        service.deleteJob(jobId);
    }

    @GetMapping("loadData")
    public String loadData(){
        service.loadData();
        return "Success";
    }

}
