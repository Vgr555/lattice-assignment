package com.internshala.lattice.controller;

import com.internshala.lattice.entity.Doctor;
import com.internshala.lattice.service.DoctorService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/register")
    @Operation(summary = "Add/Register new doctor")
    public ResponseEntity<Doctor> registerDoctor(@RequestBody Doctor doctor){
        Doctor registeredDoctor = doctorService.registerDoctor(doctor);
        return new ResponseEntity<>(registeredDoctor, HttpStatus.CREATED);
    }

    @GetMapping("/doctors")
    @Operation(summary = "List all doctors")
    public ResponseEntity<List<Doctor>> getAllDoctors(){
        List<Doctor> allDoctors = doctorService.getAllDoctors();
        return new ResponseEntity<>(allDoctors, HttpStatus.OK);
    }

    @GetMapping("/id")
    @Operation(summary = "Get doctor by doctor-id")
    public ResponseEntity<Doctor> getDoctorById(@PathParam("doctorId") Integer doctorId){
        Doctor doctor = doctorService.getDoctorById(doctorId);
        return new ResponseEntity<>(doctor, HttpStatus.OK);
    }

    @PutMapping("/update/{doctorId}")
    @Operation(summary = "Update doctor details")
    public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor doctor, @PathVariable Integer doctorId){
        Doctor updatedDoctor = doctorService.updateDoctor(doctor, doctorId);
        return new ResponseEntity<>(updatedDoctor, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete doctor")
    public ResponseEntity<String> deleteDoctor(@PathParam("doctorId") Integer doctorId){
        String s = doctorService.deleteDoctor(doctorId);
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

}
