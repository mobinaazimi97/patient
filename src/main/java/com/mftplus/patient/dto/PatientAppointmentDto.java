package com.mftplus.patient.dto;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mftplus.patient.model.Appointment;
import com.mftplus.patient.model.Patient;
import com.mftplus.patient.service.AppointmentServiceMicro;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
//@Component
public class PatientAppointmentDto {
    private Long patientId;
    private String firstName;
    private String lastName;
    private int age;
    private String phone;

    private Long appointmentId;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    private final AppointmentServiceMicro appointmentService;

    public PatientAppointmentDto(AppointmentServiceMicro appointmentService) {
        this.appointmentService = appointmentService;
    }


//    public List<Appointment> getAppointments() throws JsonProcessingException {
//        ObjectMapper mapper = new ObjectMapper();
//        return mapper.readValue(
//                appointmentService.getAppointmentByPatientId(patientId).getBody(),
//                new TypeReference<List<Appointment>>() {}
//        );
//    }

//    public Patient getPatient() throws JsonProcessingException {
//        return Patient.builder().patientId(patientId).firstName(firstName).lastName(lastName).appointments(getAppointments()).build();
//    }
}
