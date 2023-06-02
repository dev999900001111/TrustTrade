package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Service;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.SecurityAndAuthenticationService;
import java.math.BigDecimal;
import java.time.*;
import java.util.*;
import lombok.Data;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import java.math.BigDecimal;
import java.time.*;
import java.util.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import com.example.demo.service.SecurityAndAuthenticationService.CreateAccessControlRequest;
import com.example.demo.service.SecurityAndAuthenticationService.UpdateAccessControlRequest;
import com.example.demo.service.SecurityAndAuthenticationService.CreateStaffAccountRequest;
import com.example.demo.service.SecurityAndAuthenticationService.UpdateStaffAccountRequest;
import com.example.demo.service.SecurityAndAuthenticationService.CreateAgencyAccountRequest;
import com.example.demo.service.SecurityAndAuthenticationService.UpdateAgencyAccountRequest;
import com.example.demo.service.SecurityAndAuthenticationService.AuthenticateUserRequest;

@Service
public class SecurityAndAuthenticationServiceImpl implements SecurityAndAuthenticationService {

    @Autowired
    private AccessControlRepository accessControlRepository;

    @Autowired
    private StaffAccountRepository staffAccountRepository;

    @Autowired
    private AgencyAccountRepository agencyAccountRepository;

    @Autowired
    private AuthenticationMethodRepository authenticationMethodRepository;

    @Override
    public AccessControl createAccessControl(CreateAccessControlRequest requestBody) {
            AccessControl accessControl = AccessControl.builder()
                    .targetType(requestBody.getTargetType())
                    .targetId(requestBody.getTargetId())
                    .permissions(requestBody.getPermissions())
                    .build();
            return accessControlRepository.save(accessControl);
    }

    @Override
    public AccessControl updateAccessControl(Integer id, UpdateAccessControlRequest requestBody) {
            AccessControl accessControl = accessControlRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Access control not found"));
            accessControl.setTargetType(requestBody.getTargetType());
            accessControl.setTargetId(requestBody.getTargetId());
            accessControl.setPermissions(requestBody.getPermissions());
            return accessControlRepository.save(accessControl);
    }

    @Override
    public void deleteAccessControl(Integer id) {
            accessControlRepository.deleteById(id);
    }

    @Override
    public StaffAccount createStaffAccount(CreateStaffAccountRequest requestBody) {
            StaffAccount staffAccount = StaffAccount.builder()
                    .name(requestBody.getName())
                    .email(requestBody.getEmail())
                    .password(requestBody.getPassword())
                    .role(requestBody.getRole())
                    .build();
            return staffAccountRepository.save(staffAccount);
    }

    @Override
    public StaffAccount updateStaffAccount(Integer id, UpdateStaffAccountRequest requestBody) {
            StaffAccount staffAccount = staffAccountRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Staff account not found"));
            staffAccount.setName(requestBody.getName());
            staffAccount.setEmail(requestBody.getEmail());
            staffAccount.setPassword(requestBody.getPassword());
            staffAccount.setRole(requestBody.getRole());
            return staffAccountRepository.save(staffAccount);
    }

    @Override
    public void deleteStaffAccount(Integer id) {
            staffAccountRepository.deleteById(id);
    }

    @Override
    public AgencyAccount createAgencyAccount(CreateAgencyAccountRequest requestBody) {
            AgencyAccount agencyAccount = AgencyAccount.builder()
                    .name(requestBody.getName())
                    .email(requestBody.getEmail())
                    .password(requestBody.getPassword())
                    .role(requestBody.getRole())
                    .build();
            return agencyAccountRepository.save(agencyAccount);
    }

    @Override
    public AgencyAccount updateAgencyAccount(Integer id, UpdateAgencyAccountRequest requestBody) {
            AgencyAccount agencyAccount = agencyAccountRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Agency account not found"));
            agencyAccount.setName(requestBody.getName());
            agencyAccount.setEmail(requestBody.getEmail());
            agencyAccount.setPassword(requestBody.getPassword());
            agencyAccount.setRole(requestBody.getRole());
            return agencyAccountRepository.save(agencyAccount);
    }

    @Override
    public void deleteAgencyAccount(Integer id) {
            agencyAccountRepository.deleteById(id);
    }

    @Override
    public AuthenticationMethod authenticateUser(AuthenticateUserRequest requestBody) {
//            AuthenticationMethod authenticationMethod = authenticationMethodRepository.findByUsername(requestBody.getUsername())
//                    .orElseThrow(() -> new RuntimeException("User not found"));
//            if (!authenticationMethod.getPassword().equals(requestBody.getPassword())) {
//                throw new RuntimeException("Invalid password");
//            }
//            if (authenticationMethod.getTwoFactorAuthentication() != requestBody.getTwoFactorAuthentication()) {
//                throw new RuntimeException("Invalid two-factor authentication");
//            }
//            return authenticationMethod;
        return null;
    }

}
