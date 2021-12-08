package com.example.practica2.Repository

import com.example.practica2.Model.Doctor
import org.springframework.data.jpa.repository.JpaRepository

interface DoctorRepository: JpaRepository<Doctor, Long> {
    fun findById (id: Long?): Doctor?
}