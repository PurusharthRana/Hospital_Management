package com.codingshuttle.youtube.hospitalManagement;

import com.codingshuttle.youtube.hospitalManagement.dto.BloodGroupCountResponseEntity;
import com.codingshuttle.youtube.hospitalManagement.entity.Patient;
import com.codingshuttle.youtube.hospitalManagement.entity.type.BloodGroupType;
import com.codingshuttle.youtube.hospitalManagement.repository.PatientRepository;
import com.codingshuttle.youtube.hospitalManagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientTests {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatientRepository(){
    List<Patient> patientList = patientRepository.findAllPatientWithAppointment();
        System.out.println(patientList);
    }

    @Test
    public void testTransactionMethod(){
//        Patient patient = patientService.getPatientById(1L);    // L for Long
//        System.out.println(patient);

//        Patient patient = patientRepository.findByName("Divya");
//        System.out.println(patient);

//        List<Patient> patientList = patientRepository.findByBirthDateOrGender(LocalDate.of(2005, 03, 13), "Female");
//        for(Patient patient: patientList){
//            System.out.println(patient);
//        }

//        List<Patient> patientList = patientRepository.findByNameContaining("ivy");
//        for(Patient patient: patientList){
//            System.out.println(patient);
//        }

//        List<Patient> patientList = patientRepository.findByNameContainingOrderByIdDesc("a");
//        for(Patient patient: patientList){
//            System.out.println(patient);
//        }

//        List<Patient> patientList = patientRepository.findByBloodGroup(BloodGroupType.O_Positive);
//        for(Patient patient: patientList){
//            System.out.println(patient);
//        }

//        List<Patient> patientList = patientRepository.findByBornAfterDate(LocalDate.of(2000, 05, 15));
//        for(Patient patient: patientList){
//            System.out.println(patient);
//        }

//        // GroupBy clause
//        List<Object[]> bloodGroupList = patientRepository.countEachBloodGroupType();
//        for(Object[] object: bloodGroupList){
//            System.out.println(object[0] + " " + object[1]);
//        }
//
//        // Native Query -> Pure SQL
//        List<Patient> patientList = patientRepository.findAllPatientsNatively();
//        for(Patient patient: patientList){
//            System.out.println(patient);
//        }

        // Update Query
//        int rowsUpdated = patientRepository.updateNameWithId("Purusharth", 2L);
//        System.out.println("After updation, no. of rows affected = " + rowsUpdated);

        // Projection
//        List<BloodGroupCountResponseEntity> bloodGroupList = patientRepository.countEachBloodGroupType();
//        for(BloodGroupCountResponseEntity bloodGroupCountResponse: bloodGroupList){
//            System.out.println(bloodGroupCountResponse);
//        }

        // Pagination -> NOTE: Pagination always works on the sorted result, not original data order
        Page<Patient> patientList = patientRepository.findAllPatients(PageRequest.of(1, 2, Sort.by("name")));
        for(Patient patient: patientList){
            System.out.println(patient);
        }

    }

}
