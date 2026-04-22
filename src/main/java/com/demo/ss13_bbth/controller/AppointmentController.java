package com.demo.ss13_bbth.controller;

import com.demo.ss13_bbth.model.entity.Appointment;
import com.demo.ss13_bbth.service.IAppointmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Scanner;
@Controller
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private IAppointmentService appointmentService;

    @GetMapping
    public String showList(Model model) {
        model.addAttribute("list", appointmentService.findAllWaiting());
        return "list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("appointment", new Appointment());
        return "add";
    }

    @PostMapping("/add")
    public String save(@Valid @ModelAttribute("appointment") Appointment a, BindingResult res, Model model) {
        if (res.hasErrors()) {
            return "add";
        }
        appointmentService.save(a);
        return "redirect:/appointment";
    }

    @GetMapping("/call/{id}")
    public String call(@PathVariable Long id) {
        appointmentService.callPatient(id);
        return "redirect:/appointment";
    }
}
