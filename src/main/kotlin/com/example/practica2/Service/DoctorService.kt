package com.example.practica2.Service

import com.example.practica2.Model.Doctor
import com.example.practica2.Repository.DoctorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.server.ResponseStatusException

@Service

class DoctorService {
    @Autowired
    lateinit var doctorRepository: DoctorRepository


    fun list(): List<Doctor> {
        return doctorRepository.findAll()
    }

    fun save(@RequestBody doctor: Doctor): Doctor {
        try{
            if (doctor.nombre.equals("") || doctor.especialidad.equals("")){
                throw Exception("Los campos no deben estar vacios")
            }
            else {
                return doctorRepository.save(doctor)
            }
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    fun update(@RequestBody doctor: Doctor): Doctor {
        try {

            val response = doctorRepository.findById(doctor.id)
                ?: throw Exception("El ID ${doctor.id} en la tabla de doctores no existe")

            if (doctor.nombre.equals("") || doctor.especialidad.equals("")){
                throw Exception("Los campos no deben estar vacios")
            }
            else {
                return doctorRepository.save(doctor)
            }
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    fun updateNombre (@RequestBody doctor: Doctor): Doctor{
        try {
            val response = doctorRepository.findById(doctor.id)
                ?: throw Exception("El ID ${doctor.id} en la tabla de doctores no existe")
            response.apply {
                this.nombre = doctor.nombre
            }
            if(doctor.nombre.equals("")){
                throw Exception("El campo 'nombre' no puede estar vacio")
            }
            return doctorRepository.save(response)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    fun delete (id:Long): Boolean{
        doctorRepository.deleteById(id)
        return true
    }
}