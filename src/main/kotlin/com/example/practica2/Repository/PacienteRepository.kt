package com.example.practica2.Repository

import com.example.practica2.Model.Paciente
import org.springframework.data.jpa.repository.JpaRepository

interface PacienteRepository: JpaRepository<Paciente, Long> {
    fun findById (id: Long?): Paciente?
}