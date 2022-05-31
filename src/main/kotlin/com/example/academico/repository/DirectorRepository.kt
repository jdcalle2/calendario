package com.example.academico.repository

import com.example.academico.model.Director

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface DirectorRepository: JpaRepository<Director, Long> {

    fun findById(id:Long?): Director?
    @Query(nativeQuery = true)
    fun getListAge(@Param("age") age: Long?) : List <Director>?

}

