package com.example.practica2.Model

import javax.persistence.*

@Entity
@Table(name = "paciente")

class Paciente {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null

    var nombre: String? = null
    var edad: Int? = null

    @Column(name="iddoctor")
    var iddoctor: Long? = null
}