package com.example.TestTask.spring_boot.Dao;


import com.example.TestTask.spring_boot.entity.SalesTrafficStatisticByDate;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;


import com.example.TestTask.spring_boot.entity.SalesTrafficStatisticByDate;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesTrafficStatisticByDateRepository extends MongoRepository<SalesTrafficStatisticByDate, String> {
    List<SalesTrafficStatisticByDate> findByDateBetween(LocalDate startDate, LocalDate endDate);
}