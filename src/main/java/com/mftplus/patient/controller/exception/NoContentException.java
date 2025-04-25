package com.mftplus.patient.controller.exception;

public class NoContentException extends Exception {
    public NoContentException() {
        super("Appointment Not Found !!!");
    }
}
