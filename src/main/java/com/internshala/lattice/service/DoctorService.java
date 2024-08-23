package com.internshala.lattice.service;

import com.internshala.lattice.entity.Doctor;
import com.internshala.lattice.exceptionalHandling.NoSuchDoctorException;
import com.internshala.lattice.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor registerDoctor(Doctor doctor) {
        doctor.setDoctorId(UUID.randomUUID().toString());
        return doctorRepository.save(doctor);
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(String doctorId) {
        Optional<Doctor> doctor = doctorRepository.findByDoctorId(doctorId);
        if(doctor.isEmpty()){
            throw new NoSuchDoctorException("Doctor with id : "+doctorId+" not found!");
        }
        return doctor.get();
    }

    public String deleteDoctor(String doctorId) {
        Optional<Doctor> doctor = doctorRepository.findByDoctorId(doctorId);
        if(doctor.isEmpty()){
            throw new NoSuchDoctorException("Doctor with id : "+doctorId+" not found!");
        }
        doctorRepository.delete(doctor.get());
        return "Doctor deleted successfully!";
    }

    public Doctor updateDoctor(Doctor doctor, String doctorId) {
        Optional<Doctor> doctor1 = doctorRepository.findByDoctorId(doctorId);
        if(doctor1.isEmpty()){
            throw new NoSuchDoctorException("Doctor with id : "+doctorId+" not found!");
        }
        Doctor doctor2 = doctor1.get();
        doctor2.setName(doctor.getName());
        doctor2.setCity(doctor.getCity());
        doctor2.setEmail(doctor.getEmail());
        doctor2.setPhoneNumber(doctor.getPhoneNumber());
        doctor2.setSpeciality(doctor.getSpeciality());
        return doctorRepository.save(doctor2);
    }
}
