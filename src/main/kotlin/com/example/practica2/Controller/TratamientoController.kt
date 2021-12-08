package com.example.practica2.Controller

import com.example.practica2.Model.Paciente
import com.example.practica2.Model.Tratamiento
import com.example.practica2.Service.PacienteService
import com.example.practica2.Service.TratamientoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/tratamiento")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])

class TratamientoController {
    @Autowired
    lateinit var tratamientoService: TratamientoService

    @GetMapping
    fun list(): List<Tratamiento>{
        return tratamientoService.list()
    }

    @PostMapping
    fun save (@RequestBody tratamiento: Tratamiento): Tratamiento {
        return tratamientoService.save(tratamiento)
    }

    @PutMapping
    fun update (@RequestBody tratamiento: Tratamiento): Tratamiento {
        return tratamientoService.update(tratamiento)
    }

    @PatchMapping
    fun updateDescripcion (@RequestBody tratamiento: Tratamiento): Tratamiento {
        return tratamientoService.updateDescripcion(tratamiento)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long): Boolean {
        return tratamientoService.delete(id)
    }
}