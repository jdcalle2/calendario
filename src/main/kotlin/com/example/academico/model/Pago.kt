package com.example.eva3m.modelo

import javax.persistence.*

@Entity
@Table(name = "pago")
class Pago {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var placa: String? = null
    var anio: Long? = null
    var valor: Long? = null


}