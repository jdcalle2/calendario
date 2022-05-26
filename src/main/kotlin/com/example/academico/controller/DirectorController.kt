package com.example.academico.controller


import com.example.academico.model.Director
import com.example.academico.service.DirectorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/director")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH,RequestMethod.DELETE])

class DirectorController {
    @Autowired
    lateinit var directorService: DirectorService


    @GetMapping
    fun list():List<Director> {
        return directorService.list()
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): Director?{
        return directorService.getById(id)
    }

    @PostMapping
    fun save(@RequestBody director: Director): Director {
        return directorService.save(director)
    }
    @PutMapping
    fun update (@RequestBody director: Director): Director {
        return directorService.update(director)
    }
    @PatchMapping
    fun updateName(@RequestBody director: Director): Director{
        return directorService.updateName(director)
    }
    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable("id") id:Long):Boolean {
        return directorService.delete(id)
    }
}
