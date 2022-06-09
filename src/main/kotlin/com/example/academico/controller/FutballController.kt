package com.example.academico.controller

import com.example.academico.dto.CanchaDto
import com.example.academico.dto.NameDto
import com.example.academico.model.Director
import com.example.academico.model.Futball
import com.example.academico.service.DirectorService
import com.example.academico.service.FutballService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/futball")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH, RequestMethod.DELETE])
class FutballController {
    @Autowired
    lateinit var futballService: FutballService


    @GetMapping
    fun list():List<Futball> {
        return futballService.list()
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): Futball?{
        return futballService.getById(id)
    }
    @GetMapping("/age/{age}")
    fun listbyAge (@PathVariable("age") age: Long): List<Futball>? {
        return futballService.getByAge(age)
    }



    @PostMapping
    fun save(@RequestBody futball: Futball): Futball {
        return futballService.save(futball)
    }
    @PutMapping
    fun update (@RequestBody futball: Futball): Futball {
        return futballService.update(futball)
    }
    @PatchMapping
    fun updateName(@RequestBody futball: Futball): Futball {
        return futballService.updateName(futball)
    }
    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable("id") id:Long):Boolean {
        return futballService.delete(id)
    }

}