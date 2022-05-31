package com.example.academico.controller


import com.example.academico.model.Student
import com.example.academico.service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/student")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH,RequestMethod.DELETE])
class StudentController  {
    @Autowired
    lateinit var studentService: StudentService

    @GetMapping
    fun list():List<Student> {
        return studentService.list()
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): Student?{
        return studentService.getById(id)
    }


    @GetMapping("/age/{age}")
    fun listbyAge (@PathVariable("age") age: Long): List<Student>? {
        return studentService.getByAge(age)
    }

    @PostMapping
    fun save(@RequestBody student:Student):Student {
        return studentService.save(student)
    }
    @PutMapping
    fun update (@RequestBody student:Student): Student {
        return studentService.update(student)
    }
    @PatchMapping
    fun updateName(@RequestBody student:Student): Student {
        return studentService.updateName(student)
    }
    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable("id") id:Long):Boolean {
        return studentService.delete(id)
    }
}


