package com.example.demo.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import java.math.BigDecimal;
import java.util.List;
import java.time.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Embeddable
public class UserInformation {

    @Column(name="user_information_name")
    private String name;

    @Column(name="user_information_email")
    private String email;

    @Column(name="user_information_address")
    private String address;

    @Column(name="user_information_phone_number")
    private String phoneNumber;

}
