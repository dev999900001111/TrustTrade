package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import com.example.demo.entity.*;
import com.example.demo.service.SecurityAndAuthenticationService;
import jakarta.validation.Valid;
import java.math.BigDecimal;
import java.util.*;
import java.time.*;

@RestController
public class SecurityAndAuthenticationController {

    @Autowired
    private SecurityAndAuthenticationService securityAndAuthenticationService;

    @PostMapping("/access-controls")
    public AccessControl createAccessControl(@Valid @RequestBody SecurityAndAuthenticationService.CreateAccessControlRequest requestBody) {
        return securityAndAuthenticationService.createAccessControl(requestBody);
    }

    @PutMapping("/access-controls/{id}")
    public AccessControl updateAccessControl(@PathVariable Integer id, @Valid @RequestBody SecurityAndAuthenticationService.UpdateAccessControlRequest requestBody) {
        return securityAndAuthenticationService.updateAccessControl(id, requestBody);
    }

    @DeleteMapping("/access-controls/{id}")
    public void deleteAccessControl(@PathVariable Integer id) {
        securityAndAuthenticationService.deleteAccessControl(id);
    }

    @PostMapping("/staff-accounts")
    public StaffAccount createStaffAccount(@Valid @RequestBody SecurityAndAuthenticationService.CreateStaffAccountRequest requestBody) {
        return securityAndAuthenticationService.createStaffAccount(requestBody);
    }

    @PutMapping("/staff-accounts/{id}")
    public StaffAccount updateStaffAccount(@PathVariable Integer id, @Valid @RequestBody SecurityAndAuthenticationService.UpdateStaffAccountRequest requestBody) {
        return securityAndAuthenticationService.updateStaffAccount(id, requestBody);
    }

    @DeleteMapping("/staff-accounts/{id}")
    public void deleteStaffAccount(@PathVariable Integer id) {
        securityAndAuthenticationService.deleteStaffAccount(id);
    }

    @PostMapping("/agency-accounts")
    public AgencyAccount createAgencyAccount(@Valid @RequestBody SecurityAndAuthenticationService.CreateAgencyAccountRequest requestBody) {
        return securityAndAuthenticationService.createAgencyAccount(requestBody);
    }

    @PutMapping("/agency-accounts/{id}")
    public AgencyAccount updateAgencyAccount(@PathVariable Integer id, @Valid @RequestBody SecurityAndAuthenticationService.UpdateAgencyAccountRequest requestBody) {
        return securityAndAuthenticationService.updateAgencyAccount(id, requestBody);
    }

    @DeleteMapping("/agency-accounts/{id}")
    public void deleteAgencyAccount(@PathVariable Integer id) {
        securityAndAuthenticationService.deleteAgencyAccount(id);
    }

    @PostMapping("/authenticate")
    public AuthenticationMethod authenticateUser(@Valid @RequestBody SecurityAndAuthenticationService.AuthenticateUserRequest requestBody) {
        return securityAndAuthenticationService.authenticateUser(requestBody);
    }

}
