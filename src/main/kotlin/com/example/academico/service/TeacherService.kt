package com.example.academico.service
import com.example.academico.dto.SubjectDto
import com.example.academico.model.Teacher
import com.example.academico.repository.TeacherRepository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.server.ResponseStatusException
//I tried to kill the pain
//But only brought more (so much more)
//I lay dying
//And I'm pouring crimson regret and betrayal
//I'm dying, praying, bleeding and screaming
//Am I too lost to be saved?
//Am I too lost?
//My God, my Tourniquet
//Return to me salvation
//My God, my Tourniquet
//Return to me salvation
//Do you remember me?
//Lost for so long
//Will you be on the other side?
//Or will you forget me?
//I'm dying, praying, bleeding and screaming
//Am I too lost to be saved?
//Am I too lost?
//My God, my Tourniquet
//Return to me salvation
//My God, my Tourniquet
//Return to me salvation
//I want to die
//My God, my Tourniquet
//Return to me salvation
//My God, my Tourniquet
//Return to me salvation
//My wounds cry for the grave
//My soul cries for deliverance
//Will I be denied Christ?
//Tourniquet
//My suicide
//Return to me salvation
//Return to me salvation

@Service
class TeacherService {


    @Autowired
    lateinit var teacherRepository: TeacherRepository
    fun list():List<Teacher> {
        return  teacherRepository.findAll()

    }
    fun getByAge (age: Long?):List<Teacher>? {
        return teacherRepository.getListAge (age)
    }
    fun getById (id: Long?):Teacher? {
        return teacherRepository.findById(id)
    }
    fun save (teacher: Teacher): Teacher {
        try {
            teacher.name?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("nombre no debe ser vacio")
            return teacherRepository.save(teacher)
        }catch (ex : Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    fun update (teacher: Teacher):Teacher {
        teacherRepository.findById(teacher.id) ?: throw Exception()

        return teacherRepository.save(teacher)


    }


    fun updateName(teacher: Teacher):Teacher {
        val response = teacherRepository.findById(teacher.id)
            ?: throw Exception()
        response.apply {
            name = teacher.name
            subject = teacher.subject
            classNumber = teacher.classNumber
            schedule = teacher.schedule
            age = teacher.age
        }
        return teacherRepository.save(response)
    }

    fun delete (@PathVariable("id") id: Long):Boolean {
        teacherRepository.deleteById(id)
        return true
    }
    fun updateDescription (teacher: Teacher):Teacher {
        try {
            if (teacher.name.equals("")){
                throw Exception("description no puede ser vacio")
            }
            val response = teacherRepository.findById(teacher.id)
                ?: throw Exception("El id ${teacher.id} en dieta no existe")
            response.apply {
                this.name = teacher.name
            }
            return teacherRepository.save(teacher)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }
    fun updateDescripcion1 (teacher: Teacher):Teacher {
        try {
            val response = teacherRepository.findById(teacher.id) ?: throw Exception()
            response.apply {
                this.name = teacher.name

            }
            return teacherRepository.save(response)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Dieta No Encontrada")
        }
    }

    fun updateOtherName (SubjectDto: SubjectDto): List<Teacher>?{
        return teacherRepository.setOtherName(SubjectDto.subject, SubjectDto.newSubject)
    }


}