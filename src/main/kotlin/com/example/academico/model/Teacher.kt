package com.example.academico.model

import javax.persistence.*

@Entity
@Table(name= "teacher" )
class Teacher {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? =null
    var name: String? = null
    var subject: String? = null
    @Column(name="class_number")
    var classNumber: String? = null
    var schedule: String? = null
    var age: Long? = null

}