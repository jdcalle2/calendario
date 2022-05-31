package com.example.academico.service

import com.example.academico.model.Director



import com.example.academico.repository.DirectorRepository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.server.ResponseStatusException

@Service
class DirectorService {
    @Autowired
    lateinit var directorRepository: DirectorRepository
    fun list():List<Director> {
        return directorRepository.findAll()

    }

    fun getByAge (age: Long?):List<Director>? {
        return directorRepository.getListAge (age)
    }

    fun getById (id: Long?): Director? {
        return directorRepository.findById(id)
    }

    fun save (director: Director): Director {
        try {
            director.name?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("nombre no debe ser vacio")
            return directorRepository.save(director)
        }catch (ex : Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }
    fun update (director: Director): Director {
        directorRepository.findById(director.id) ?: throw Exception()

        return directorRepository.save(director)


    }


    fun updateName(director: Director): Director {
        val response = directorRepository.findById(director.id)
            ?: throw Exception()
        response.apply {
            name = director.name
            office = director.office
            officeHour = director.officeHour
            age = director.age
        }
        return directorRepository.save(response)
    }

    fun delete (@PathVariable("id") id: Long):Boolean {
        directorRepository.deleteById(id)
        return true
    }

    fun updateDescription (director: Director):Director {
        try {
            if (director.name.equals("")){
                throw Exception("description no puede ser vacio")
            }
            val response = directorRepository.findById(director.id)
                ?: throw Exception("El id ${director.id} en director no existe")
            response.apply {
                this.name = director.name
            }
            return directorRepository.save(director)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }
    fun updateDescripcion1 (director: Director):Director {
        try {
            val response = directorRepository.findById(director.id) ?: throw Exception()
            response.apply {
                this.name = director.name

            }
            return directorRepository.save(response)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Dieta No Encontrada")
        }
    }



}