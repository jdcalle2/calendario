package com.example.academico.model

import javax.persistence.*

@Entity
@Table(name= "futball" )
class Futball {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? =null
    var nombre: String? = null
    var hora: Long? = null
    var cancha: Long? = null

}