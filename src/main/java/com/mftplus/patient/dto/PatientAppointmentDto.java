package com.mftplus.patient.dto;


import com.mftplus.visitDateAndTime.model.Appointment;
import com.mftplus.visitDateAndTime.model.Patient;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Component
public class PatientAppointmentDto {

    private String firstName;
    private String lastName;

    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;




    public Appointment getAppointment() {
        return Appointment.builder().startDateTime(startDateTime).endDateTime(endDateTime).build();
    }
    public Patient getPatient() {
        return Patient.builder().appointments(List.of(getAppointment())).firstName(firstName).lastName(lastName).build();
    }
}
