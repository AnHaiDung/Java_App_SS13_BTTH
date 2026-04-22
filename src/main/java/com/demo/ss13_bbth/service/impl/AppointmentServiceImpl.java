package com.demo.ss13_bbth.service.impl;

import com.demo.ss13_bbth.model.entity.Appointment;
import com.demo.ss13_bbth.repository.AppointmentRepository;
import com.demo.ss13_bbth.service.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class AppointmentServiceImpl implements IAppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public List<Appointment> findAllWaiting() {
        return appointmentRepository.getWaitingList();
    }

    @Override
    public void save(Appointment appointment) {
        appointment.setStatus(0);
        appointmentRepository.save(appointment);
    }

    @Override
    public void callPatient(Long id) {
        appointmentRepository.updateStatus(id);
    }
}
