package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import com.example.demo.entity.*;
import com.example.demo.service.ProductManagementService;
import jakarta.validation.Valid;
import java.math.BigDecimal;
import java.util.*;
import java.time.*;

@RestController
public class ProductManagementController {

    @Autowired
    private ProductManagementService productManagementService;

    @PostMapping("/investment-trusts")
    public InvestmentTrust createInvestmentTrust(@Valid @RequestBody ProductManagementService.CreateInvestmentTrustRequest requestBody) {
        return productManagementService.createInvestmentTrust(requestBody);
    }

    @PutMapping("/investment-trusts/{id}")
    public InvestmentTrust updateInvestmentTrust(@PathVariable Integer id, @Valid @RequestBody ProductManagementService.UpdateInvestmentTrustRequest requestBody) {
        return productManagementService.updateInvestmentTrust(id, requestBody);
    }

    @DeleteMapping("/investment-trusts/{id}")
    public void deleteInvestmentTrust(@PathVariable Integer id) {
        productManagementService.deleteInvestmentTrust(id);
    }

    @GetMapping("/investment-trusts")
    public List<InvestmentTrust> getInvestmentTrusts() {
        return productManagementService.getInvestmentTrusts();
    }

    @PutMapping("/investment-trusts/{id}/price")
    public TrustPrice updateTrustPrice(@PathVariable Integer id, @Valid @RequestBody ProductManagementService.UpdateTrustPriceRequest requestBody) {
        return productManagementService.updateTrustPrice(id, requestBody);
    }

    @PutMapping("/investment-trusts/{id}/fee")
    public TrustFee updateTrustFee(@PathVariable Integer id, @Valid @RequestBody ProductManagementService.UpdateTrustFeeRequest requestBody) {
        return productManagementService.updateTrustFee(id, requestBody);
    }

}
