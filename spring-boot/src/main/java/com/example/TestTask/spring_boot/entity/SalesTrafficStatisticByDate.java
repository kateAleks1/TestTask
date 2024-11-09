package com.example.TestTask.spring_boot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Map;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "salesAndTrafficByDate")
public class SalesTrafficStatisticByDate {
    @Id
    private String id;
    private LocalDate date;

    private double orderedProductSalesAmount;
    private String orderedProductSalesCurrency;

    private double orderedProductSalesB2BAmount;
    private String orderedProductSalesB2BCurrency;

    private int unitsOrdered;
    private int unitsOrderedB2B;

    private int totalOrderItems;
    private int totalOrderItemsB2B;

    private double averageSalesPerOrderItemAmount;
    private String averageSalesPerOrderItemCurrency;

    private double averageSalesPerOrderItemB2BAmount;
    private String averageSalesPerOrderItemB2BCurrency;

    private double averageUnitsPerOrderItem;
    private double averageUnitsPerOrderItemB2B;

    private double averageSellingPriceAmount;
    private String averageSellingPriceCurrency;

    private double averageSellingPriceB2BAmount;
    private String averageSellingPriceB2BCurrency;

    private int unitsRefunded;
    private double refundRate;

    private int claimsGranted;
    private double claimsAmount;
    private String claimsCurrency;

    private double shippedProductSalesAmount;
    private String shippedProductSalesCurrency;

    private int unitsShipped;
    private int ordersShipped;

    // Traffic data fields
    private int browserPageViews;
    private int browserPageViewsB2B;
    private int mobileAppPageViews;
    private int mobileAppPageViewsB2B;
    private int pageViews;
    private int pageViewsB2B;
    private int browserSessions;
    private int browserSessionsB2B;
    private int mobileAppSessions;
    private int mobileAppSessionsB2B;
    private int sessions;
    private int sessionsB2B;

    private double buyBoxPercentage;
    private double buyBoxPercentageB2B;
    private double orderItemSessionPercentage;
    private double orderItemSessionPercentageB2B;
    private double unitSessionPercentage;
    private double unitSessionPercentageB2B;

    private int averageOfferCount;
    private int averageParentItems;
    private int feedbackReceived;
    private int negativeFeedbackReceived;
    private double receivedNegativeFeedbackRate;

}