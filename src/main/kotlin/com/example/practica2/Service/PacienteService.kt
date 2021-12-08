package com.example.practica2.Service

import com.example.practica2.Model.Paciente
import com.example.practica2.Repository.DoctorRepository
import com.example.practica2.Repository.PacienteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.server.ResponseStatusException

@Service

class PacienteService {
    @Autowired
    lateinit var pacienteRepository: PacienteRepository
    @Autowired
    lateinit var doctorRepository: DoctorRepository


    fun list(): List<Paciente> {
        return pacienteRepository.findAll()
    }

    fun save(@RequestBody paciente: Paciente): Paciente {
        try{
            val response = doctorRepository.findById(paciente.iddoctor)
                ?: throw Exception("El ID ${paciente.iddoctor} en la tabla doctores no existe")

            if (paciente.nombre.equals("") || paciente.edad!! > 0){
                throw Exception("Los campos no cumplen las condiciones")
            }
            else {
                return pacienteRepository.save(paciente)
            }
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    fun update(@RequestBody paciente: Paciente): Paciente {
        try {

            val response = pacienteRepository.findById(paciente.id)
                ?: throw Exception("El ID ${paciente.id} en la tabla pacientes no existe")

            val response1 = doctorRepository.findById(paciente.iddoctor)
                ?: throw Exception("El ID ${paciente.iddoctor} en la tabla doctores no existe")

            if (paciente.nombre.equals("") || paciente.edad!! < 0){
                throw Exception("Los campos no cumplen las condiciones")
            }
            else {
                return pacienteRepository.save(paciente)
            }
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    fun updateNombre (@RequestBody paciente: Paciente): Paciente {
        try {
            if(paciente.nombre.equals("")){
                throw Exception("El campo 'nombre' no puede estar vacio")
            }
            val response = pacienteRepository.findById(paciente.id)
                ?: throw Exception("El ID ${paciente.id} en la tabla pacientes no existe")
            response.apply {
                this.nombre = paciente.nombre
            }
            return pacienteRepository.save(response)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    fun delete (id:Long): Boolean{
        pacienteRepository.deleteById(id)
        return true
    }
}