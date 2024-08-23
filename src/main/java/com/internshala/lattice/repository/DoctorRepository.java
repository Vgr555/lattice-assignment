package com.internshala.lattice.repository;

import com.internshala.lattice.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    List<Doctor> findBySpecialityAndCity(String speciality, String city);

    Optional<Doctor> findByDoctorId(String doctorId);
}
