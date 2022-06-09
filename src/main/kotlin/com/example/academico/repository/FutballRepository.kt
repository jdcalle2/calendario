package com.example.academico.repository


import com.example.academico.model.Futball
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface FutballRepository: JpaRepository<Futball, Long> {
    fun findById(id:Long?): Futball?
    @Query(nativeQuery = true)
    fun getListAge(@Param("age") age: Long?) : List <Futball>?

    @Modifying
    @Query(nativeQuery=true)
    fun setOtherCancha (@Param("cancha")  cancha:Long?, @Param("frecuencia")  frecuencia:Long?) : Integer?
}

