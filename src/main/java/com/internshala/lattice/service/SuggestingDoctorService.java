package com.internshala.lattice.service;

import com.internshala.lattice.entity.Doctor;
import com.internshala.lattice.entity.Patient;
import com.internshala.lattice.exceptionalHandling.DoctorNotAvailableException;
import com.internshala.lattice.exceptionalHandling.LocationUnAvailable;
import com.internshala.lattice.exceptionalHandling.NoSuchPatientException;
import com.internshala.lattice.repository.DoctorRepository;
import com.internshala.lattice.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuggestingDoctorService {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private DoctorRepository doctorRepository;

    private List<Doctor> doctors;

    public List<Doctor> getDoctorsByPatientSymptom(Integer patientId){

        Optional<Patient> patient = patientRepository.findById(patientId);
        if(patient.isEmpty()){
            throw new NoSuchPatientException("Patient with id : " + patientId + " not found!");
        }
        String symptom = patient.get().getSymptom();
        String city = patient.get().getCity();

        switch (symptom) {
            case "Arthritis":
            case "Back Pain":
            case "Tissue injuries":
                doctors = doctorRepository.findBySpecialityAndCity("Orthopedic", city);
                break;
            case "Dysmenorrhea":
                doctors = doctorRepository.findBySpecialityAndCity("Gynecology", city);
                break;
            case "Skin infection":
            case "Skin burn":
                doctors = doctorRepository.findBySpecialityAndCity("Dermatology", city);
                break;
            case "Ear pain":
                doctors = doctorRepository.findBySpecialityAndCity("ENT", city);
                break;
        }

        boolean flag = city.equals("Delhi") || city.equals("Noida") || city.equals("Faridabad");
        if(flag && doctors.isEmpty()){
            throw new DoctorNotAvailableException("There isn’t any doctor present at your location for your symptom");
        }
        else if(!flag){
            throw new LocationUnAvailable("We are still waiting to expand to your location");
        }

        return doctors;
    }

}
