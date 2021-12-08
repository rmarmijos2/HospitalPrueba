package com.example.practica2.Service

import com.example.practica2.Model.Paciente
import com.example.practica2.Model.Tratamiento
import com.example.practica2.Repository.DoctorRepository
import com.example.practica2.Repository.PacienteRepository
import com.example.practica2.Repository.TratamientoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.server.ResponseStatusException

@Service
class TratamientoService {
    @Autowired
    lateinit var tratamientoRepository: TratamientoRepository
    @Autowired
    lateinit var pacienteRepository: PacienteRepository


    fun list(): List<Tratamiento> {
        return tratamientoRepository.findAll()
    }

    fun save(@RequestBody tratamiento: Tratamiento): Tratamiento {
        try{
            val response = pacienteRepository.findById(tratamiento.idpaciente)
                ?: throw Exception("El ID ${tratamiento.idpaciente} en la tabla doctores no existe")

            if (tratamiento.descripcion.equals("")){
                throw Exception("La descripcion no cumplen las condiciones")
            }
            else {
                return tratamientoRepository.save(tratamiento)
            }
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    fun update(@RequestBody tratamiento: Tratamiento): Tratamiento {
        try {

            val response = tratamientoRepository.findById(tratamiento.id)
                ?: throw Exception("El ID ${tratamiento.id} en la tabla pacientes no existe")

            val response1 = pacienteRepository.findById(tratamiento.idpaciente)
                ?: throw Exception("El ID ${tratamiento.idpaciente} en la tabla doctores no existe")

            if (tratamiento.descripcion.equals("")){
                throw Exception("La descripcion no cumplen las condiciones")
            }
            else {
                return tratamientoRepository.save(tratamiento)
            }
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    fun updateDescripcion (@RequestBody tratamiento: Tratamiento): Tratamiento {
        try {
            if (tratamiento.descripcion.equals("")){
                throw Exception("La descripcion no cumplen las condiciones")
            }
            val response = tratamientoRepository.findById(tratamiento.id)
                ?: throw Exception("El ID ${tratamiento.id} en la tabla pacientes no existe")
            response.apply {
                this.descripcion = tratamiento.descripcion
            }
            return tratamientoRepository.save(response)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    fun delete (id:Long): Boolean{
        tratamientoRepository.deleteById(id)
        return true
    }
}