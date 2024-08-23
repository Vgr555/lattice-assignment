package com.internshala.lattice.controller;

import com.internshala.lattice.entity.Doctor;
import com.internshala.lattice.service.SuggestingDoctorService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SuggestingDoctorController {

    @Autowired
    private SuggestingDoctorService suggestingDoctorService;

    @GetMapping("/suggest-me-doctors")
    @Operation(summary = "Suggest Doctors based on Patient symptom and location")
    public ResponseEntity<List<Doctor>> getDoctorsByPatientSymptom(@RequestParam("patientId") String patientId){
        List<Doctor> doctors = suggestingDoctorService.getDoctorsByPatientSymptom(patientId);
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }

}
