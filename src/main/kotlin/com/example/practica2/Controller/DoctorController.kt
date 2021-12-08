package com.example.practica2.Controller

import com.example.practica2.Model.Doctor
import com.example.practica2.Service.DoctorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/doctor")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])

class DoctorController {
    @Autowired
    lateinit var doctorservice: DoctorService

    @GetMapping
    fun list(): List<Doctor>{
        return doctorservice.list()
    }

    @PostMapping
    fun save (@RequestBody doctor: Doctor): Doctor{
        return doctorservice.save(doctor)
    }

    @PutMapping
    fun update (@RequestBody doctor: Doctor): Doctor{
        return doctorservice.update(doctor)
    }

    @PatchMapping
    fun updateNombre (@RequestBody doctor: Doctor): Doctor{
        return doctorservice.updateNombre(doctor)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long): Boolean {
        return doctorservice.delete(id)
    }
}