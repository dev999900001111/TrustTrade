package com.example.demo.service;

import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.*;
import java.util.*;

public interface ResearchInformationService {

    @Data
    public static class CreateResearchReportRequest {
        @NotNull
        private Integer investmentTrustId;
        @NotBlank
        private String title;
        @NotBlank
        private String content;
        @NotNull
        private LocalDate date;
    }
    public ResearchReport createResearchReport(CreateResearchReportRequest requestBody) ;

    @Data
    public static class UpdateResearchReportRequest {
        @NotBlank
        private String title;
        @NotBlank
        private String content;
        @NotNull
        private LocalDate date;
    }
    public ResearchReport updateResearchReport(Integer id, UpdateResearchReportRequest requestBody) ;

    public void deleteResearchReport(Integer id) ;

    public List<ResearchReport> getResearchReports() ;

    @Data
    public static class ProvideInvestmentAdviceRequest {
        @NotNull
        private Integer userAccountId;
        @NotNull
        private Integer researchReportId;
        @NotBlank
        private String advice;
    }
    public InvestmentAdvice provideInvestmentAdvice(ProvideInvestmentAdviceRequest requestBody) ;

}
