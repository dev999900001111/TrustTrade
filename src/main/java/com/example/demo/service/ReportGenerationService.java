package com.example.demo.service;

import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.*;
import java.util.*;

public interface ReportGenerationService {

    @Data
    public static class GenerateTrustEvaluationRequest {
        @NotNull
        private Integer userAccountId;
        @NotNull
        private Integer investmentTrustId;
        @NotNull
        private Double evaluationAmount;
        @NotNull
        private LocalDate date;
    }
    public TrustEvaluation generateTrustEvaluation(GenerateTrustEvaluationRequest requestBody) ;

    @Data
    public static class GenerateProfitRateRequest {
        @NotNull
        private Integer userAccountId;
        @NotNull
        private Integer investmentTrustId;
        @NotNull
        private Double rate;
        @NotNull
        private LocalDate date;
    }
    public ProfitRate generateProfitRate(GenerateProfitRateRequest requestBody) ;

    @Data
    public static class GeneratePeriodicReportRequest {
        @NotNull
        private Integer userAccountId;
        @Data
        public static class ReportContent {
            private String title;
            private String content;
            @NotNull
            private LocalDate date;
        }
        private ReportContent reportContent;
        @NotNull
        private LocalDate date;
    }
    public PeriodicReport generatePeriodicReport(GeneratePeriodicReportRequest requestBody) ;

    @Data
    public static class GenerateLegalReportRequest {
        @NotNull
        private Integer userAccountId;
        @Data
        public static class ReportContent {
            private String title;
            private String content;
            @NotNull
            private LocalDate date;
        }
        private ReportContent reportContent;
        @NotNull
        private LocalDate date;
    }
    public LegalReport generateLegalReport(GenerateLegalReportRequest requestBody) ;

}
