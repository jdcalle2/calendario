package com.example.academico.service


import com.example.academico.dto.NameDto
import com.example.academico.model.Student
import com.example.academico.repository.StudentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.server.ResponseStatusException
import javax.transaction.Transactional


@Service
class StudentService {


    @Autowired
    lateinit var studentRepository: StudentRepository
    fun list():List<Student> {
        return studentRepository.findAll()

    }
    fun getById (id: Long?):Student?  {
        return studentRepository.findById(id)
    }
    fun getByAge (age: Long?):List<Student>? {
        return studentRepository.getListAge (age)
    }

    fun save (student: Student): Student {
        try {
            student.name?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("nombre no debe ser vacio")
            return studentRepository.save(student)
        }catch (ex : Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }
    fun update (student:Student):Student {
        studentRepository.findById(student.id) ?: throw Exception()

        return studentRepository.save(student)


    }


    fun updateName(student: Student):Student {
        val response = studentRepository.findById(student.id)
            ?: throw Exception()
        response.apply {
            name = student.name
            lastname = student.lastname
            gender = student.gender
            age  = student.age
        }
        return studentRepository.save(response)
    }

    fun delete (@PathVariable("id") id: Long):Boolean {
        studentRepository.deleteById(id)
        return true
    }
    fun updateDescripcion (student: Student):Student {
        try {
            if (student.name.equals("")){
                throw Exception("description no puede ser vacio")
            }
            val response = studentRepository.findById(student.id)
                ?: throw Exception("El id ${student.id} en dieta no existe")
            response.apply {
                this.name = student.name
            }
            return studentRepository.save(student)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }
    fun updateDescripcion1 (student: Student):Student {
        try {
            val response = studentRepository.findById(student.id) ?: throw Exception()
            response.apply {
                this.name = student.name

            }
            return studentRepository.save(response)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Dieta No Encontrada")
        }
    }
    //import org.springframework.transaction.annotation.Transactional
    @Transactional
    fun updateOtherName (nameDto:NameDto): String?{
        val rowsUpdate=studentRepository.setOtherName(nameDto.name, nameDto.newName)
        return "${rowsUpdate} rows updated"
    }

}
