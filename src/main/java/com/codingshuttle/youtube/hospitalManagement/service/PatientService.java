package com.codingshuttle.youtube.hospitalManagement.service;

import com.codingshuttle.youtube.hospitalManagement.entity.Patient;
import com.codingshuttle.youtube.hospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    @Transactional
    public Patient getPatientById(Long id){

        Patient p1 = patientRepository.findById(id).orElseThrow();
        Patient p2 = patientRepository.findById(id).orElseThrow();

        System.out.println(p1 == p2);   // true -> Since, p1 and p2 are now referring to same location

        p1.setName("Daredevil");
//        patientRepository.save(p1);   // No need to save as this is a transaction
//        After dirty checking p1 will be saved automatically in the database

        return p1;

    }

    public void deletePatient(long id) {
        patientRepository.deleteById(id);
    }
}
