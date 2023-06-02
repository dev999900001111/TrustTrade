package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Service;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.ProductManagementService;
import java.math.BigDecimal;
import java.time.*;
import java.util.*;
import lombok.Data;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.demo.base.exception.ResourceNotFoundException;
import com.example.demo.service.ProductManagementService.CreateInvestmentTrustRequest;
import com.example.demo.service.ProductManagementService.UpdateInvestmentTrustRequest;
import com.example.demo.service.ProductManagementService.UpdateTrustPriceRequest;
import com.example.demo.service.ProductManagementService.UpdateTrustFeeRequest;

@Service
public class ProductManagementServiceImpl implements ProductManagementService {

    @Autowired
    private InvestmentTrustRepository investmentTrustRepository;

    @Autowired
    private TrustPriceRepository trustPriceRepository;

    @Autowired
    private TrustFeeRepository trustFeeRepository;

    @Override
    public InvestmentTrust createInvestmentTrust(CreateInvestmentTrustRequest requestBody) {
            InvestmentTrust investmentTrust = InvestmentTrust.builder()
                    .name(requestBody.getName())
                    .trustDetails(requestBody.getTrustDetails())
                    .trustPrice(requestBody.getTrustPrice())
                    .trustFee(requestBody.getTrustFee())
                    .build();
            return investmentTrustRepository.save(investmentTrust);
    }

    @Override
    public InvestmentTrust updateInvestmentTrust(Integer id, UpdateInvestmentTrustRequest requestBody) {
            InvestmentTrust investmentTrust = investmentTrustRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("InvestmentTrust", "id", id));
            investmentTrust.setName(requestBody.getName());
            investmentTrust.setTrustDetails(requestBody.getTrustDetails());
            investmentTrust.setTrustPrice(requestBody.getTrustPrice());
            investmentTrust.setTrustFee(requestBody.getTrustFee());
            return investmentTrustRepository.save(investmentTrust);
    }

    @Override
    public void deleteInvestmentTrust(Integer id) {
            investmentTrustRepository.deleteById(id);
    }

    @Override
    public List<InvestmentTrust> getInvestmentTrusts() {
            return investmentTrustRepository.findAll();
    }

    @Override
    public TrustPrice updateTrustPrice(Integer id, UpdateTrustPriceRequest requestBody) {
            TrustPrice trustPrice = trustPriceRepository.findByInvestmentTrustIdAndDate(id, requestBody.getDate())
                    .orElseThrow(() -> new ResourceNotFoundException("TrustPrice", "id", id));
            trustPrice.setPrice(requestBody.getPrice());
            return trustPriceRepository.save(trustPrice);
    }

    @Override
    public TrustFee updateTrustFee(Integer id, UpdateTrustFeeRequest requestBody) {
            TrustFee trustFee = trustFeeRepository.findByInvestmentTrustIdAndFeeType(id, requestBody.getFeeType())
                    .orElseThrow(() -> new ResourceNotFoundException("TrustFee", "id", id));
            trustFee.setFeeAmount(requestBody.getFeeAmount());
            return trustFeeRepository.save(trustFee);
    }

}
