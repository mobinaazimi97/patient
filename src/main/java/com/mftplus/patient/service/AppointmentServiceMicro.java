package com.mftplus.patient.service;

import com.mftplus.patient.model.Appointment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "appointmentClient", url = "http://192.168.36.55:8081")
public interface AppointmentServiceMicro {

    @PostMapping("/appointments")
    ResponseEntity<String> postAppointment(@RequestBody Appointment appointment);

    @GetMapping("/appointments")
    ResponseEntity<String> getAppointments();
}
