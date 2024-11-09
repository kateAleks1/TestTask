package com.example.TestTask.spring_boot.Controller;


import com.example.TestTask.spring_boot.entity.SalesTrafficStatisticByAsin;
import com.example.TestTask.spring_boot.entity.Statistic;
import com.example.TestTask.spring_boot.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


    @RestController
    @RequestMapping("/api/statistics")
    public class StatisticController {

        private final StatisticService statisticService;

        @Autowired
        public StatisticController(StatisticService statisticService) {
            this.statisticService = statisticService;
        }

        @GetMapping("/by-date")
        public List<Statistic> getStatisticsByDate(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
            return statisticService.getStatisticsByDate(startDate, endDate);
        }

        @GetMapping("/by-asin")
        public List<Statistic> getStatisticsByAsin(@RequestParam List<String> asins) {
            return statisticService.getStatisticsByAsin(asins);
        }

        @GetMapping("/total")
        public List<Statistic> getTotalStatistics() {
            return statisticService.getTotalStatistics();
        }

        @GetMapping("/total-by-asin")
        public List<Statistic> getTotalStatisticsByAsin() {
            return statisticService.getTotalStatisticsByAsin();
        }

        @PostMapping("/update")
        public ResponseEntity<String> updateStatistics(@AuthenticationPrincipal UserDetails userDetails) {

            if (userDetails == null) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN)
                        .body("User not authorized");
            }

            try {
                statisticService.updateStatisticsFromJsonFile();
                return ResponseEntity.ok("Statistics updated from file");
            } catch (Exception e) {

                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Failed to update statistics: " + e.getMessage());
            }
        }
    }