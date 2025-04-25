package com.mftplus.patient.model;

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
public class Appointment {
    private Long appointmentId;
    private boolean deleted;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
}