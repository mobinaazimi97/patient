package com.mftplus.patient.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@NoArgsConstructor
@ToString
@SuperBuilder

@Cacheable
@Entity(name = "doctorEntity")
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "doctorName",length = 30)
    private String doctorName;

    @Column(name = "experience_years")
    private int experienceYears;

    @Column(name = "contact_info",length = 50)
    private String contactInfo;

    @ManyToOne
    @JoinColumn(name = "specialization_info",foreignKey = @ForeignKey(name = "doctor_specializeKey"))
    private Specialization specialization;

//    @OneToOne
//    @JoinTable(name = "doctor_user",foreignKey = @ForeignKey(name = "fk_doctor_user"))
//    private User user;


}