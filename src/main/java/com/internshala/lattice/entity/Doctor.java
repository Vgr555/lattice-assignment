package com.internshala.lattice.entity;

import jakarta.persistence.*;
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
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id", nullable = false)
    private String doctorId;

    @Size(min = 3)
    @Column(name = "name", nullable = false)
    private String name;

    @Size(max = 20)
    @Column(name = "city", nullable = false)
    @Pattern(regexp = "^(Delhi|Noida|Faridabad)$", message = "City cannot be other than Delhi or Noida or Faridabad")
    private String city;

    @Email
    @Column(name = "email")
    private String email;

    @Size(min = 10, max = 10, message = "Phone number must be 10 digits")
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Pattern(regexp = "^(Orthopedic|Gynecology|Dermatology|ENT)$", message = "Speciality cannot be other than Orthopedic or Gynecology or Dermatology or ENT")
    @Column(name = "speciality", nullable = false)
    private String speciality;

}
