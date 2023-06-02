package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import com.example.demo.entity.*;
import com.example.demo.service.ReportGenerationService;
import jakarta.validation.Valid;
import java.math.BigDecimal;
import java.util.*;
import java.time.*;

@RestController
public class ReportGenerationController {

    @Autowired
    private ReportGenerationService reportGenerationService;

    @PostMapping("/reports/trust-evaluation")
    public TrustEvaluation generateTrustEvaluation(@Valid @RequestBody ReportGenerationService.GenerateTrustEvaluationRequest requestBody) {
        return reportGenerationService.generateTrustEvaluation(requestBody);
    }

    @PostMapping("/reports/profit-rate")
    public ProfitRate generateProfitRate(@Valid @RequestBody ReportGenerationService.GenerateProfitRateRequest requestBody) {
        return reportGenerationService.generateProfitRate(requestBody);
    }

    @PostMapping("/reports/periodic-report")
    public PeriodicReport generatePeriodicReport(@Valid @RequestBody ReportGenerationService.GeneratePeriodicReportRequest requestBody) {
        return reportGenerationService.generatePeriodicReport(requestBody);
    }

    @PostMapping("/reports/legal-report")
    public LegalReport generateLegalReport(@Valid @RequestBody ReportGenerationService.GenerateLegalReportRequest requestBody) {
        return reportGenerationService.generateLegalReport(requestBody);
    }

}
