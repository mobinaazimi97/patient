package com.mftplus.patient.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
@SuperBuilder
@Entity(name = "appointmentEntity")
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "appointment_id")
    private Long appointmentId;

//    @JsonIgnore
    @Column(name = "deleted")
    private boolean deleted;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_info")
    private Patient patient;

    @Column(name = "start_time")
    private LocalDateTime startDateTime;

    @Column(name = "end_time")
    private LocalDateTime endDateTime;


}