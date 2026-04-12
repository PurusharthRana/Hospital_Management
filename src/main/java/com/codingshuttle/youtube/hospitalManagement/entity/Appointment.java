package com.codingshuttle.youtube.hospitalManagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    @Column(length = 40)
    private String reason;

    // Owning Side & Child
    // We are not defining any cascade here because we don't want that whatever operation happens with the appointment (child) to affect the patient (parent)
    @ManyToOne  // Many appointment to One patient
    @JoinColumn(name = "patient_id", nullable = false)  // Patient is required for booking an appointment
    @ToString.Exclude   // To prevent stack overflow
    private Patient patient;

    // Owning Side & Child
    // We are not defining any cascade here because we don't want that whatever operation happens with the appointment (child) to affect the doctor (parent)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)   // // Doctor is required for booking an appointment
    @ToString.Exclude   // To prevent stack overflow
    private Doctor doctor;

}
