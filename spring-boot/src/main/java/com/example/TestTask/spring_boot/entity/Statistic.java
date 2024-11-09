package com.example.TestTask.spring_boot.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "statistics")
public class Statistic {

    @Id
    private String id;
    private String asin;
    private Date date;
    private int sales;
    private double traffic;

}