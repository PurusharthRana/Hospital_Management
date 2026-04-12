package com.codingshuttle.youtube.hospitalManagement;

import com.codingshuttle.youtube.hospitalManagement.entity.Appointment;
import com.codingshuttle.youtube.hospitalManagement.entity.Insurance;
import com.codingshuttle.youtube.hospitalManagement.entity.Patient;
import com.codingshuttle.youtube.hospitalManagement.repository.InsuranceRepository;
import com.codingshuttle.youtube.hospitalManagement.repository.PatientRepository;
import com.codingshuttle.youtube.hospitalManagement.service.AppointmentService;
import com.codingshuttle.youtube.hospitalManagement.service.InsuranceService;
import com.codingshuttle.youtube.hospitalManagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@SpringBootTest
public class InsuranceTests {

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private PatientService patientService;

    @Test
    public void testInsurance() {
        Insurance insurance = Insurance.builder()
                .policyNumber("HDFC12345")
                .provider("HDFC Bank")
                .validUntil(LocalDate.of(2030, 12, 12))
                .build();

        Patient patient = insuranceService.assignInsuranceToPatient(insurance, 1L);
        System.out.println("Patient is: " + patient);

        var newPatient = insuranceService.disassociateInsuranceFromPatient(patient.getId());
        System.out.println(newPatient);

    }

    @Test
    public void testCreateAppointment(){
        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2026, 6, 12, 14, 30, 0))
                .reason("Fever")
                .build();

        var newAppointment = appointmentService.createNewAppointment(appointment, 1L, 2L);
        System.out.println(newAppointment);

        var updatedAppointment = appointmentService.reassignAppointmentToNewDoctor(newAppointment.getId(), 3L);
        System.out.println(updatedAppointment);
    }

    @Test
    public void testCreateThreeAppointmentsAndDeletePatient(){
        Appointment a1 = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2027, 8, 24, 14, 0, 0))
                .reason("Anxiety")
                .build();

        Appointment a2 = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2027, 8, 24, 14, 0, 0))
                .reason("Typhoid")
                .build();

        Appointment a3 = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2027, 8, 24, 14, 0, 0))
                .reason("Depression")
                .build();

        var newAppointment1 = appointmentService.createNewAppointment(a1, 1L, 4L);
        System.out.println(newAppointment1);

        var newAppointment2 = appointmentService.createNewAppointment(a2, 2L, 4L);
        System.out.println(newAppointment2);

        var newAppointment3 = appointmentService.createNewAppointment(a3, 3L, 4L);
        System.out.println(newAppointment3);

        patientService.deletePatient(4L);

    }

}
