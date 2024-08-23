package com.internshala.lattice.controller;

import com.internshala.lattice.entity.Patient;
import com.internshala.lattice.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/register")
    @Operation(summary = "Add/Register new patient")
    public ResponseEntity<Patient> registerPatient(@RequestBody Patient patient){
        Patient registeredPatient = patientService.registerPatient(patient);
        return new ResponseEntity<>(registeredPatient, HttpStatus.CREATED);
    }

    @GetMapping("/patients")
    @Operation(summary = "List all patients")
    public ResponseEntity<List<Patient>> getAllPatients(){
        List<Patient> allPatients = patientService.getAllPatients();
        return new ResponseEntity<>(allPatients, HttpStatus.OK);
    }

    @GetMapping("/id")
    @Operation(summary = "Get patient by patient-id")
    public ResponseEntity<Patient> getPatientById(@RequestParam("patientId") String patientId){
        Patient patient = patientService.getPatientById(patientId);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    @PutMapping("/update")
    @Operation(summary = "Update patient details")
    public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient, @RequestParam("patientId") String patientId){
        Patient updatedPatient = patientService.updatePatient(patient, patientId);
        return new ResponseEntity<>(updatedPatient, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete patient")
    public ResponseEntity<String> deletePatient(@RequestParam("patientId") String patientId){
        String s = patientService.deletePatient(patientId);
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

}
