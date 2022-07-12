package com.example.eva3m.repository

import com.example.eva3m.modelo.Pago
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PagoRepository : JpaRepository<Pago, Long?> {

    fun findById (id: Long?): Pago?
}
