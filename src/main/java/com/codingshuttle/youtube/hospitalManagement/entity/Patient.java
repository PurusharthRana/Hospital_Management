package com.codingshuttle.youtube.hospitalManagement.entity;

import com.codingshuttle.youtube.hospitalManagement.entity.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
@Table(
        name = "patient",
        uniqueConstraints = {
//                @UniqueConstraint(name = "unique_patient_email", columnNames = {"email"}),
                @UniqueConstraint(name = "unique_patient_name_birthDate", columnNames = {"name", "birthDate"})
        },
        indexes = {
                @Index(name = "idx_patient_birthDate", columnList = "birthDate")
        }
)
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    // Primary Key

    @Column(nullable = false, length = 40)
    private String name;

//    @ToString.Exclude
    private LocalDate birthDate;

    @Column(unique = true, nullable = false)
    private String email;

    private String gender;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroup;

    // Cascade rules needed to be defined on the parent side
    @OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = true)       // Association
    @JoinColumn(name = "patient_insurance_id")      // Owning Side
    private Insurance insurance;

    // Inverse Side
    @OneToMany(mappedBy = "patient", cascade = {CascadeType.REMOVE}, orphanRemoval = true, fetch = FetchType.EAGER)    // One patient to many appointments
//    @ToString.Exclude   // To remove this, define fetch
    private List<Appointment> appointments = new ArrayList<>();

}
