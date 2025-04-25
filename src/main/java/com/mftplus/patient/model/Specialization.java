package com.mftplus.patient.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@SuperBuilder
@Slf4j

@Cacheable
@Entity(name = "specializationEntity")
@Table(name = "specializations")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "specializationId")
public class Specialization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "specializationId")
    private Long id;

    @Column(name = "skillName")
    private String skillName;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "specialization", fetch = FetchType.EAGER)
//    @JoinTable(name = "specialization_doctors")
    private List<Doctor> doctorList=new ArrayList<>();



    public void addDoctor(Doctor doctor) {
        try {
            doctorList.add(doctor);
            doctor.setSpecialization(this); // ارتباط دو طرفه
        } catch (Exception e) {
            log.error("error while adding doctor: ", e);
        }
    }


//    public void addDoctor(Doctor doctor) {
//       try {
//           if (doctorList == null) {
//               doctorList = new ArrayList<>();
//           }
//           doctorList.add(doctor);
//       }catch (Exception e) {
//          // throw new RuntimeException(e.getMessage());
//           log.error("error while adding doctors{}",e.getMessage());
//       }
//       }
}