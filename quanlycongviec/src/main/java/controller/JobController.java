package com.example.demo.controller;

import com.example.demo.entity.Job;
import com.example.demo.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {
    @Autowired
    private JobRepository jobRepository;

    @GetMapping("/top10-working-hours")
    public List<Job> getTop10JobsByWorkingHours() {
        return jobRepository.findTop10ByWorkingHours();
    }

    @GetMapping("/recent")
    public List<Job> getRecentJobs() {
        LocalDateTime date = LocalDateTime.now().minusDays(7);
        return jobRepository.findTop10ByCreatedAtAfter(date);
    }
}