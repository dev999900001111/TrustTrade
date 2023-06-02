package com.example.demo.service;

import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.*;
import java.util.*;

public interface ProductManagementService {

    @Data
    public static class CreateInvestmentTrustRequest {
        @NotBlank
        private String name;
        @NotNull
        private TrustDetails trustDetails;
        @NotNull
        private TrustPrice trustPrice;
        @NotNull
        private TrustFee trustFee;
    }
    public InvestmentTrust createInvestmentTrust(CreateInvestmentTrustRequest requestBody) ;

    @Data
    public static class UpdateInvestmentTrustRequest {
        @NotBlank
        private String name;
        @NotNull
        private TrustDetails trustDetails;
        @NotNull
        private TrustPrice trustPrice;
        @NotNull
        private TrustFee trustFee;
    }
    public InvestmentTrust updateInvestmentTrust(Integer id, UpdateInvestmentTrustRequest requestBody) ;

    public void deleteInvestmentTrust(Integer id) ;

    public List<InvestmentTrust> getInvestmentTrusts() ;

    @Data
    public static class UpdateTrustPriceRequest {
        @NotNull
        private LocalDate date;
        @NotNull
        private Double price;
    }
    public TrustPrice updateTrustPrice(Integer id, UpdateTrustPriceRequest requestBody) ;

    @Data
    public static class UpdateTrustFeeRequest {
        @NotNull
        private FeeType feeType;
        @NotNull
        private Double feeAmount;
    }
    public TrustFee updateTrustFee(Integer id, UpdateTrustFeeRequest requestBody) ;

}
