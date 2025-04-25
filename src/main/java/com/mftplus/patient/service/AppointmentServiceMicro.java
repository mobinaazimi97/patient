package com.mftplus.patient.service;

import com.mftplus.patient.model.Appointment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@FeignClient(value = "appointmentClient", url = "http://192.168.36.55:8081")
@Service
public interface AppointmentServiceMicro {

//    @PostMapping("/appointments")
//    ResponseEntity<String> postAppointment(@RequestBody Appointment appointment);

//    @GetMapping("/appointments")
//    ResponseEntity<String> getAppointments();

//    @GetMapping("/appointments/{appointmentId}")
//    ResponseEntity<String> getAppointmentById(@PathVariable("appointmentId") Long appointmentId);

//    @GetMapping("/appointments/patients/{patientId}")
//    ResponseEntity<String> getAppointmentByPatientId(@PathVariable("patientId") Long patientId);
}
