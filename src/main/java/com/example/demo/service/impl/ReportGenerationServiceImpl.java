package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Service;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.ReportGenerationService;
import java.math.BigDecimal;
import java.time.*;
import java.util.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.TrustEvaluation;
import com.example.demo.entity.ProfitRate;
import com.example.demo.entity.PeriodicReport;
import com.example.demo.entity.LegalReport;
import com.example.demo.repository.TrustEvaluationRepository;
import com.example.demo.repository.ProfitRateRepository;
import com.example.demo.repository.PeriodicReportRepository;
import com.example.demo.repository.LegalReportRepository;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import com.example.demo.service.ReportGenerationService.GenerateTrustEvaluationRequest;
import com.example.demo.service.ReportGenerationService.GenerateProfitRateRequest;
import com.example.demo.service.ReportGenerationService.GeneratePeriodicReportRequest;
import com.example.demo.service.ReportGenerationService.GenerateLegalReportRequest;

@Service
public class ReportGenerationServiceImpl implements ReportGenerationService {

    @Autowired
    private TrustEvaluationRepository trustEvaluationRepository;

    @Autowired
    private ProfitRateRepository profitRateRepository;

    @Autowired
    private PeriodicReportRepository periodicReportRepository;

    @Autowired
    private LegalReportRepository legalReportRepository;

    @Override
    public TrustEvaluation generateTrustEvaluation(GenerateTrustEvaluationRequest requestBody) {
            TrustEvaluation trustEvaluation = TrustEvaluation.builder()
                    .userAccountId(requestBody.getUserAccountId())
                    .investmentTrustId(requestBody.getInvestmentTrustId())
                    .evaluationAmount(BigDecimal.valueOf(requestBody.getEvaluationAmount()))
                    .date(requestBody.getDate())
                    .build();
            return trustEvaluationRepository.save(trustEvaluation);
    }

    @Override
    public ProfitRate generateProfitRate(GenerateProfitRateRequest requestBody) {
            ProfitRate profitRate = ProfitRate.builder()
                    .userAccountId(requestBody.getUserAccountId())
                    .investmentTrustId(requestBody.getInvestmentTrustId())
                    .rate(BigDecimal.valueOf(requestBody.getRate()))
                    .date(requestBody.getDate())
                    .build();
            return profitRateRepository.save(profitRate);
    }

    @Override
    public PeriodicReport generatePeriodicReport(GeneratePeriodicReportRequest requestBody) {
            PeriodicReport.ReportContent reportContent = PeriodicReport.ReportContent.builder()
                    .title(requestBody.getReportContent().getTitle())
                    .content(requestBody.getReportContent().getContent())
                    .date(requestBody.getReportContent().getDate())
                    .build();
            PeriodicReport periodicReport = PeriodicReport.builder()
                    .userAccountId(requestBody.getUserAccountId())
                    .reportContent(reportContent)
                    .date(requestBody.getDate())
                    .build();
            return periodicReportRepository.save(periodicReport);
    }

    @Override
    public LegalReport generateLegalReport(GenerateLegalReportRequest requestBody) {
            LegalReport.ReportContent reportContent = LegalReport.ReportContent.builder()
                    .title(requestBody.getReportContent().getTitle())
                    .content(requestBody.getReportContent().getContent())
                    .date(requestBody.getReportContent().getDate())
                    .build();
            LegalReport legalReport = LegalReport.builder()
                    .userAccountId(requestBody.getUserAccountId())
                    .reportContent(reportContent)
                    .date(requestBody.getDate())
                    .build();
            return legalReportRepository.save(legalReport);
    }

}
