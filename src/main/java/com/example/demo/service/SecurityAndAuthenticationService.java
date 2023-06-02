package com.example.demo.service;

import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.*;
import java.util.*;

public interface SecurityAndAuthenticationService {

    @Data
    public static class CreateAccessControlRequest {
        @NotBlank
        private String targetType;
        @NotNull
        private Integer targetId;
        @NotEmpty
        private Set<Permissions> permissions;
    }
    public AccessControl createAccessControl(CreateAccessControlRequest requestBody) ;

    @Data
    public static class UpdateAccessControlRequest {
        @NotBlank
        private String targetType;
        @NotNull
        private Integer targetId;
        @NotEmpty
        private Set<Permissions> permissions;
    }
    public AccessControl updateAccessControl(Integer id, UpdateAccessControlRequest requestBody) ;

    public void deleteAccessControl(Integer id) ;

    @Data
    public static class CreateStaffAccountRequest {
        @NotBlank
        private String name;
        @Email
        private String email;
        @NotBlank
        private String password;
        @NotBlank
        private String role;
    }
    public StaffAccount createStaffAccount(CreateStaffAccountRequest requestBody) ;

    @Data
    public static class UpdateStaffAccountRequest {
        @NotBlank
        private String name;
        @Email
        private String email;
        @NotBlank
        private String password;
        @NotBlank
        private String role;
    }
    public StaffAccount updateStaffAccount(Integer id, UpdateStaffAccountRequest requestBody) ;

    public void deleteStaffAccount(Integer id) ;

    @Data
    public static class CreateAgencyAccountRequest {
        @NotBlank
        private String name;
        @Email
        private String email;
        @NotBlank
        private String password;
        @NotBlank
        private String role;
    }
    public AgencyAccount createAgencyAccount(CreateAgencyAccountRequest requestBody) ;

    @Data
    public static class UpdateAgencyAccountRequest {
        @NotBlank
        private String name;
        @Email
        private String email;
        @NotBlank
        private String password;
        @NotBlank
        private String role;
    }
    public AgencyAccount updateAgencyAccount(Integer id, UpdateAgencyAccountRequest requestBody) ;

    public void deleteAgencyAccount(Integer id) ;

    @Data
    public static class AuthenticateUserRequest {
        @NotBlank
        private String username;
        @NotBlank
        private String password;
        @NotNull
        private Boolean twoFactorAuthentication;
    }
    public AuthenticationMethod authenticateUser(AuthenticateUserRequest requestBody) ;

}
