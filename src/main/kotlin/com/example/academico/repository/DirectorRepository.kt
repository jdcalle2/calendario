package com.example.academico.repository

import com.example.academico.model.Director

import org.springframework.data.jpa.repository.JpaRepository

interface DirectorRepository: JpaRepository<Director, Long> {

    fun findById(id:Long?): Director?

}

