package com.saugat.jobapp.repository;

import com.saugat.jobapp.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<JobPost, Integer> {

    List<JobPost> findJobPostByPostDesc(String keyword);
    List<JobPost> findJobPostByPostProfile(String keyword);
    List<JobPost> findByPostDescContainingIgnoreCaseOrPostProfileContaining(String keyword1, String keyword2);

}
