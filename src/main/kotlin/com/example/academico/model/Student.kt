package com.example.academico.model

import javax.persistence.*


@Entity
@Table(name="student")
class Student {
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Id
     @Column(updatable = false)
     var id: Long? =null
     var name: String? = null
     var lastname: String? = null
     var semester: String? = null
     var gender: String? = null
     var age: Long? = null
}

