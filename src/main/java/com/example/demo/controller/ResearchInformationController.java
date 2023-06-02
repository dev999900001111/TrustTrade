package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import com.example.demo.entity.*;
import com.example.demo.service.ResearchInformationService;
import jakarta.validation.Valid;
import java.math.BigDecimal;
import java.util.*;
import java.time.*;

@RestController
public class ResearchInformationController {

    @Autowired
    private ResearchInformationService researchInformationService;

    @PostMapping("/research-reports")
    public ResearchReport createResearchReport(@Valid @RequestBody ResearchInformationService.CreateResearchReportRequest requestBody) {
        return researchInformationService.createResearchReport(requestBody);
    }

    @PutMapping("/research-reports/{id}")
    public ResearchReport updateResearchReport(@PathVariable Integer id, @Valid @RequestBody ResearchInformationService.UpdateResearchReportRequest requestBody) {
        return researchInformationService.updateResearchReport(id, requestBody);
    }

    @DeleteMapping("/research-reports/{id}")
    public void deleteResearchReport(@PathVariable Integer id) {
        researchInformationService.deleteResearchReport(id);
    }

    @GetMapping("/research-reports")
    public List<ResearchReport> getResearchReports() {
        return researchInformationService.getResearchReports();
    }

    @PostMapping("/investment-advice")
    public InvestmentAdvice provideInvestmentAdvice(@Valid @RequestBody ResearchInformationService.ProvideInvestmentAdviceRequest requestBody) {
        return researchInformationService.provideInvestmentAdvice(requestBody);
    }

}
