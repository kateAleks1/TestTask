package com.example.TestTask.spring_boot.entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;
import java.util.List;
import com.example.TestTask.spring_boot.entity.SalesTrafficStatisticByDate;
@Document(collection = "reports")
public class Report {
    @Id
    private String id;
    private ReportSpecification reportSpecification;
    private List<SalesTrafficStatisticByDate> salesAndTrafficByDate;
}