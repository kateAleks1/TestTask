package com.example.TestTask.spring_boot.Dao;

import com.example.TestTask.spring_boot.entity.SalesTrafficStatisticByAsin;
import com.example.TestTask.spring_boot.entity.Statistic;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Repository
public interface StatisticRepository extends MongoRepository<Statistic, String> {
    List<Statistic> findByDateBetween(LocalDate startDate, LocalDate endDate);
    List<Statistic> findByAsinIn(List<String> asins);
    List<SalesTrafficStatisticByAsin> findByDate(LocalDate date);
}