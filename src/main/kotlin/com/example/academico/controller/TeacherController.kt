package com.example.academico.controller



import com.example.academico.dto.SubjectDto
import com.example.academico.model.Teacher
import com.example.academico.service.TeacherService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/teacher")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH,RequestMethod.DELETE])
class TeacherController {
    @Autowired
    lateinit var teacherService: TeacherService

    @GetMapping
    fun list():List<Teacher> {
        return teacherService.list()
    }


    @GetMapping("/changeName")
    fun updateOtherName (@RequestBody SubjectDto: SubjectDto): List<Teacher>?{
        return teacherService.updateOtherName(SubjectDto)
    }
    @GetMapping("/age/{age}")
    fun listbyAge (@PathVariable("age") age: Long): List<Teacher>? {
        return teacherService.getByAge(age)
    }

    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): Teacher?{
        return teacherService.getById(id)
    }

    @PostMapping
    fun save(@RequestBody teacher: Teacher): Teacher {
        return teacherService.save(teacher)
    }
    @PutMapping
    fun update (@RequestBody teacher: Teacher): Teacher {
        return teacherService.update(teacher)
    }

    @PatchMapping
    fun updateName(@RequestBody teacher: Teacher): Teacher {
        return teacherService.updateName(teacher)
    }
    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable("id") id:Long):Boolean {
        return teacherService.delete(id)
    }

}
