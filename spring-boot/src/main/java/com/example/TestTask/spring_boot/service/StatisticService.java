package com.example.TestTask.spring_boot.service;


import com.example.TestTask.spring_boot.Dao.StatisticRepository;
import com.example.TestTask.spring_boot.entity.SalesTrafficStatisticByAsin;
import com.example.TestTask.spring_boot.entity.Statistic;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
@Service
public class StatisticService {

    private final StatisticRepository statisticRepository;
    private final RedisService redisService;
    private final FileService fileService;

    @Autowired
    public StatisticService(StatisticRepository statisticRepository, RedisService redisService, FileService fileService) {
        this.statisticRepository = statisticRepository;
        this.redisService = redisService;
        this.fileService = fileService;
    }

    @Cacheable(value = "statisticsByDate", key = "#startDate.toString() + '-' + #endDate.toString()", unless = "#result == null")
    public List<Statistic> getStatisticsByDate(LocalDate startDate, LocalDate endDate) {
        return statisticRepository.findByDateBetween(startDate, endDate);
    }

    @Cacheable(value = "statisticsByAsin", key = "#asins.toString()", unless = "#result == null")
    public List<Statistic> getStatisticsByAsin(List<String> asins) {
        return statisticRepository.findByAsinIn(asins);
    }

    @Cacheable(value = "totalStatistics", unless = "#result == null")
    public List<Statistic> getTotalStatistics() {
        return statisticRepository.findAll();
    }

    @Cacheable(value = "totalStatisticsByAsin", unless = "#result == null")
    public List<Statistic> getTotalStatisticsByAsin() {
        return statisticRepository.findAll();
    }

    @Scheduled(fixedRate = 60000)
    public void updateStatisticsFromJsonFile() {

        try {
            File file = new File("test_report.json");
            ObjectMapper objectMapper = new ObjectMapper();
            List<Statistic> statistics = objectMapper.readValue(file, new TypeReference<List<Statistic>>(){});

            statisticRepository.saveAll(statistics);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}