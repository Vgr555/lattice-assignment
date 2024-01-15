package com.internshala.lattice.repository;

import com.internshala.lattice.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    List<Doctor> findBySpecialityAndCity(String orthopedic, String city);
}
