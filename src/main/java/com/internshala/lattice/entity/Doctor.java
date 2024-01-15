package com.internshala.lattice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer doctorId;

    @Size(min = 3)
    private String name;

    @Size(max = 20)
    @Pattern(regexp = "^(Delhi|Noida|Faridabad)$", message = "City cannot be other than Delhi or Noida or Faridabad")
    private String city;

    @Email
    private String email;

    @Size(min = 10, max = 10, message = "Phone number must be 10 digits")
    private String phoneNumber;

    @Pattern(regexp = "^(Orthopedic|Gynecology|Dermatology|ENT)$", message = "Speciality cannot be other than Orthopedic or Gynecology or Dermatology or ENT")
    private String speciality;

}
