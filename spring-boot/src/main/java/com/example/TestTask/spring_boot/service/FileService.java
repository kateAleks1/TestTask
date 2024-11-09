package com.example.TestTask.spring_boot.service;
import com.example.TestTask.spring_boot.entity.SalesTrafficStatisticByAsin;
import com.google.gson.Gson;

import com.example.TestTask.spring_boot.entity.Statistic;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.util.List;

@Service
public class FileService {


    public List<SalesTrafficStatisticByAsin> parseStatisticsFile(String fileName) {
        try {
            FileReader reader = new FileReader(fileName);
            Gson gson = new Gson();
            return gson.fromJson(reader, new TypeToken<List<Statistic>>(){}.getType());
        } catch (Exception e) {
            throw new RuntimeException("Error reading file", e);
        }
    }
}