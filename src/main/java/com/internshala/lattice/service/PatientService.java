package com.internshala.lattice.service;

import com.internshala.lattice.entity.Patient;
import com.internshala.lattice.exceptionalHandling.NoSuchPatientException;
import com.internshala.lattice.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient registerPatient(Patient patient) {
        patient.setPatientId(UUID.randomUUID().toString());
        return patientRepository.save(patient);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(String patientId) {
        Optional<Patient> patient = patientRepository.findByPatientId(patientId);
        if(patient.isEmpty()){
            throw new NoSuchPatientException("Patient with id : "+patientId+" not found!");
        }
        return patient.get();
    }

    public Patient updatePatient(Patient patient, String patientId) {
        Optional<Patient> patient1 = patientRepository.findByPatientId(patientId);
        if(patient1.isEmpty()){
            throw new NoSuchPatientException("Patient with id : "+patientId+" not found!");
        }
        Patient patient2 = patient1.get();
        patient2.setName(patient.getName());
        patient2.setCity(patient.getCity());
        patient2.setEmail(patient.getEmail());
        patient2.setPhoneNumber(patient.getPhoneNumber());
        patient2.setSymptom(patient.getSymptom());
        return patientRepository.save(patient2);
    }

    public String deletePatient(String patientId) {
        Optional<Patient> patient = patientRepository.findByPatientId(patientId);
        if(patient.isEmpty()){
            throw new NoSuchPatientException("Patient with id : "+patientId+" not found!");
        }
        patientRepository.delete(patient.get());
        return "Patient deleted successfully!";
    }
}
