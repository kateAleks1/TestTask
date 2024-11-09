package com.example.TestTask.spring_boot.Dao;

import com.example.TestTask.spring_boot.entity.Report;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends MongoRepository<Report, String> {
    List<Report> findByDate(String date);
    List<Report> findByAsin(String asin);
}