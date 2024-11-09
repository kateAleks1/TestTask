package com.example.TestTask.spring_boot.Dao;

import com.example.TestTask.spring_boot.entity.SalesTrafficStatisticByAsin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SalesTrafficStatisticByAsinRepository extends MongoRepository<SalesTrafficStatisticByAsin, String> {
    List<SalesTrafficStatisticByAsin> findByAsin(String asin);
}