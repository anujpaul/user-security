package com.paul.security.user_security.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserData {

    @Id
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate doj;
    private String workerTypeCode;
    private String workerStatus;
    private String workerGroup;

}
