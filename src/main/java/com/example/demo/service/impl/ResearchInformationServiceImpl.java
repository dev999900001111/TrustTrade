package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Service;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.ResearchInformationService;
import java.math.BigDecimal;
import java.time.*;
import java.util.*;
import lombok.Data;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import java.math.BigDecimal;
import java.time.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import com.example.demo.service.ResearchInformationService.CreateResearchReportRequest;
import com.example.demo.service.ResearchInformationService.UpdateResearchReportRequest;
import com.example.demo.service.ResearchInformationService.ProvideInvestmentAdviceRequest;

@Service
public class ResearchInformationServiceImpl implements ResearchInformationService {

    @Autowired
    private ResearchReportRepository researchReportRepository;

    @Autowired
    private InvestmentAdviceRepository investmentAdviceRepository;

    @Override
    public ResearchReport createResearchReport(CreateResearchReportRequest requestBody) {
            ResearchReport researchReport = ResearchReport.builder()
                    .investmentTrustId(requestBody.getInvestmentTrustId())
                    .title(requestBody.getTitle())
                    .content(requestBody.getContent())
                    .date(requestBody.getDate())
                    .build();
            return researchReportRepository.save(researchReport);
    }

    @Override
    public ResearchReport updateResearchReport(Integer id, UpdateResearchReportRequest requestBody) {
            ResearchReport researchReport = researchReportRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Research report not found"));
            researchReport.setTitle(requestBody.getTitle());
            researchReport.setContent(requestBody.getContent());
            researchReport.setDate(requestBody.getDate());
            return researchReportRepository.save(researchReport);
    }

    @Override
    public void deleteResearchReport(Integer id) {
            ResearchReport researchReport = researchReportRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Research report not found"));
            researchReportRepository.delete(researchReport);
    }

    @Override
    public List<ResearchReport> getResearchReports() {
            return researchReportRepository.findAll();
    }

    @Override
    public InvestmentAdvice provideInvestmentAdvice(ProvideInvestmentAdviceRequest requestBody) {
            UserAccount userAccount = userAccountRepository.findById(requestBody.getUserAccountId())
                    .orElseThrow(() -> new RuntimeException("User account not found"));
            ResearchReport researchReport = researchReportRepository.findById(requestBody.getResearchReportId())
                    .orElseThrow(() -> new RuntimeException("Research report not found"));
            InvestmentAdvice investmentAdvice = InvestmentAdvice.builder()
                    .userAccount(userAccount)
                    .researchReport(researchReport)
                    .advice(requestBody.getAdvice())
                    .build();
            return investmentAdviceRepository.save(investmentAdvice);
    }

}
