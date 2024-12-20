package com.arun.sims.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String username;

    private String password;

    @Email
    private String email;

    @Size( min = 10 , max = 10)
    private String phoneNumber;

    @Min(18)
    @Max(60)
    @Positive
    private int age;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> roles;
}
