package com.codingshuttle.youtube.hospitalManagement.service;

import com.codingshuttle.youtube.hospitalManagement.entity.Insurance;
import com.codingshuttle.youtube.hospitalManagement.entity.Patient;
import com.codingshuttle.youtube.hospitalManagement.repository.InsuranceRepository;
import com.codingshuttle.youtube.hospitalManagement.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor    // So that I don't need to make any constructor after injection (automatic constructor creation from lombok)
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;  // final keyword is required because of
    private final PatientRepository patientRepository;      // RequiredArgsConstructor

    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance, Long patientId){
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(()-> new EntityNotFoundException("Patient not found with id: "+ patientId));

        patient.setInsurance(insurance);    // Patient has been dirtied. Dirty checking is done

        insurance.setPatient(patient);      // Bidirectional consistency maintenance

        return patient;
    }

    @Transactional
    public Patient disassociateInsuranceFromPatient(Long patientId){
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(()-> new EntityNotFoundException("Patient not found with ID: " + patientId));

        patient.setInsurance(null);
        return patient;
    }

    // HW-> Create 3 appointments for a patient and then delete patient

}
