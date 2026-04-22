package com.demo.ss13_bbth.repository;

import com.demo.ss13_bbth.model.entity.Appointment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Scanner;

@Repository
public class AppointmentRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Appointment> getWaitingList() {
        Session session = sessionFactory.openSession();
        List<Appointment> list = session.createQuery("FROM Appointment WHERE status = 0 ORDER BY appointmentTime ASC", Appointment.class).getResultList();
        session.close();
        return list;
    }

    public void save(Appointment a) {
        Session session = sessionFactory.openSession();
        Transaction t = null;
        try {
            t = session.beginTransaction();
            session.persist(a);
            t.commit();
        } catch (Exception e) {
            if (t != null){
                t.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void updateStatus(Long id) {
        Session session = sessionFactory.openSession();
        Transaction t = null;
        try {
            t = session.beginTransaction();
            Appointment a = session.find(Appointment.class, id);
            if (a != null) {
                a.setStatus(1);
                session.merge(a);
            }
            t.commit();
        } catch (Exception e) {
            if (t != null) t.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
