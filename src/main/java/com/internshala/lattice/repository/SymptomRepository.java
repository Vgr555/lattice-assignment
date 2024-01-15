package com.internshala.lattice.repository;

import com.internshala.lattice.entity.Speciality;
import com.internshala.lattice.entity.Symptom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SymptomRepository extends JpaRepository<Symptom, Integer> {

    @Query(value = "SELECT speciality_name FROM speciality WHERE id=" +
            "(SELECT speciality_id FROM speciality_symptoms WHERE symptoms_id=" +
            "(SELECT id FROM symptom WHERE symptom_name=?1))", nativeQuery = true)
    String findSpecialityBySymptomName(String symptom);
}
