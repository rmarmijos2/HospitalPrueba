package com.example.practica2.Repository

import com.example.practica2.Model.Tratamiento
import org.springframework.data.jpa.repository.JpaRepository

interface TratamientoRepository: JpaRepository<Tratamiento, Long> {
    fun findById (id: Long?): Tratamiento?
}