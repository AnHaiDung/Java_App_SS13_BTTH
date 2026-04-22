package com.demo.ss13_bbth.service;

import com.demo.ss13_bbth.model.entity.Appointment;

import java.util.List;

public interface IAppointmentService {
    List<Appointment> findAllWaiting();
    void save(Appointment appointment);
    void callPatient(Long id);
}
