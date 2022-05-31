package com.example.academico.repository
import com.example.academico.model.Teacher
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface TeacherRepository: JpaRepository<Teacher, Long> {
    fun findById(id:Long?): Teacher?
    @Query(nativeQuery = true)
    fun getListAge(@Param("age") age: Long?) : List <Teacher>?

    @Modifying
    @Query(nativeQuery=true)
    fun setOtherName (@Param("subject")  subject:String?, @Param("newSubject")  newSubject:String?) : List <Teacher>?
}
