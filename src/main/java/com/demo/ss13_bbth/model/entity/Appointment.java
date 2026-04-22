package com.demo.ss13_bbth.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.processing.Pattern;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;
import java.util.Date;
import java.util.Scanner;
@Entity
@Table(name = "appointments")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Tên không được để trống")
    @Size(min = 5, message = "Tên bệnh nhân phải từ 5 ký tự trở lên")
    @Column(name = "patient_name", nullable = false)
    private String patientName;

    @NotBlank(message = "Số điện thoại không được để trống")
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @NotNull(message = "Vui lòng chọn ngày giờ khám")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Column(name = "appointment_time")
    private Date appointmentTime;

    @NotBlank(message = "Lý do khám không được để trống")
    @Column(name = "reason")
    private String reason;

    @Column(name = "status")
    private int status = 0;
}
