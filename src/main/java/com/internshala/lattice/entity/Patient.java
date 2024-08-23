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
public class Patient {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private String patientId;

    @Size(min = 3)
    @Column(name = "name", nullable = false)
    private String name;

    @Size(max = 20)
    @Column(name = "city", nullable = false)
    private String city;

    @Email
    @Column(name = "email")
    private String email;

    @Size(min = 10, max = 10)
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Pattern(regexp = "(^Arthritis|Back pain|Tissue injuries|Dysmenorrhea|Skin infection|Skin burn|Ear pain)$")
    @Column(name = "symptom", nullable = false)
    private String symptom;

}
