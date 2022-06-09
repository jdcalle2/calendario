package com.example.academico.service


import com.example.academico.dto.CanchaDto
import com.example.academico.model.Futball

import com.example.academico.repository.FutballRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.server.ResponseStatusException
import javax.transaction.Transactional

class FutballService {
    @Autowired
    lateinit var futballRepository: FutballRepository
    fun list():List<Futball> {
        return futballRepository.findAll()

    }

    fun getByAge (age: Long?):List<Futball>? {
        return futballRepository.getListAge (age)
    }

    fun getById (id: Long?): Futball? {
        return futballRepository.findById(id)
    }

    fun save (futball: Futball): Futball {
        try {
            futball.nombre?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("nombre no debe ser vacio")
            return futballRepository.save(futball)
        }catch (ex : Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }
    fun update (futball: Futball): Futball {
        futballRepository.findById(futball.id) ?: throw Exception()

        return futballRepository.save(futball)


    }


    fun updateName(futball: Futball): Futball {
        val response = futballRepository.findById(futball.id)
            ?: throw Exception()
        response.apply {
            nombre = futball.nombre
            hora = futball.hora
            cancha = futball.cancha
        }
        return futballRepository.save(response)
    }

    fun delete (@PathVariable("id") id: Long):Boolean {
        futballRepository.deleteById(id)
        return true
    }

    fun updateDescription (futball: Futball): Futball {
        try {
            if (futball.nombre.equals("")){
                throw Exception("description no puede ser vacio")
            }
            val response = futballRepository.findById(futball.id)
                ?: throw Exception("El id ${futball.id} en director no existe")
            response.apply {
                this.nombre = futball.nombre
            }
            return futballRepository.save(futball)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }
    fun updateDescripcion1 (futball: Futball): Futball {
        try {
            val response = futballRepository.findById(futball.id) ?: throw Exception()
            response.apply {
                this.nombre = futball.nombre

            }
            return futballRepository.save(response)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Dieta No Encontrada")
        }
    }
    //import org.springframework.transaction.annotation.Transactional

}