package com.example.TestTask.spring_boot.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReportOptions {
    private String dateGranularity;
    private String asinGranularity;
}
