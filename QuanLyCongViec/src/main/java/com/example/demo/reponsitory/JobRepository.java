package com.example.demo.reponsitory;

import com.example.demo.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findByCategoryId(Long categoryId);

    @Query("SELECT j FROM Job j ORDER BY j.workingHours DESC LIMIT 10")
    List<Job> findTop10ByWorkingHours();

    @Query("SELECT j FROM Job j WHERE j.createdAt >= :date ORDER BY j.createdAt DESC")
    List<Job> findTop10ByCreatedAtAfter(LocalDateTime date);
}