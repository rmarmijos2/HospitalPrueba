package com.example.practica2.Model

import javax.persistence.*

@Entity
@Table(name = "tratamiento")

class Tratamiento {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null

    var descripcion: String? = null

    @Column(name="idpaciente")
    var idpaciente: Long? = null
}