package com.example.academico.model

import javax.persistence.*

@Entity
@Table(name= "director" )
class Director {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? =null
    var name: String? = null
    var office: String? = null
    @Column(name="office_hour")
    var officeHour: String? = null
    var age: Long? = null

}