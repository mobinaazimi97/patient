package com.mftplus.patient;

import com.mftplus.patient.model.Patient;
import com.mftplus.patient.service.AppointmentServiceMicro;
import com.mftplus.patient.service.PatientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
//@Component
public class PatientApplication implements CommandLineRunner {
    private final PatientService patientService;
//    private final AppointmentServiceMicro appointmentServiceMicro;


    public PatientApplication(PatientService patientService) {
        this.patientService = patientService;

//        this.appointmentServiceMicro = appointmentServiceMicro;
    }


    public static void main(String[] args) {
        SpringApplication.run(PatientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Appointment appointment = Appointment.builder().startDateTime(LocalDateTime.now()).endDateTime(LocalDateTime.now().plusDays(2)).build();
//        appointmentServiceMicro.postAppointment(appointment);

        Patient patient = Patient.builder().firstName("ali").lastName("alipour").age(20).phone("0912").deleted(false).build();
        patientService.save(patient);


        System.out.println(patientService.findAll());
        System.out.println(patientService.findAll());
    }
}
