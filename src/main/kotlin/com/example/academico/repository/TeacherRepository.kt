package com.example.academico.repository
import com.example.academico.model.Teacher
import org.springframework.data.jpa.repository.JpaRepository

interface TeacherRepository: JpaRepository<Teacher, Long> {
    fun findById(id:Long?): Teacher?
}
