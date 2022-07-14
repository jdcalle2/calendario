package com.example.academico.service



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


    fun validateSerialNumber (serial:String?): Boolean?{

        serial.takeIf { !it?.trim().isNullOrEmpty() }
            ?: throw Exception()

        if (serial?.substring(0, 3).equals("786"))
            return true

        return false



        /*try {
                serial.takeIf { !it?.trim().isNullOrEmpty() }
                    ?: throw Exception()
                if (serial?.substring(0, 3).equals("786"))
                    return true
                return false
            }
            catch (e: Exception) {
                throw Exception()
            }*/
    }

    fun multiplicacion (coeficiente: Int, digito: Int): Int{
        val response =coeficiente*digito
        if (response >= 10)
            return response - 9
        return response

    }

    //Uso de un if en la misma linea. Si i es par coeficiente es 2 caso contrario es 1
    fun sumaValores (nui: String): Long {
        var sum: Long=0
        for ( i in 0..8) {
            val coeficiente = if(i%2 ==0) 2 else 1
            sum  += multiplicacion(coeficiente,Integer.parseInt(nui[i].toString()) )
        }
        return sum
    }

    fun findDecenaSuperior (sum: Int): Int {//sum=20
        val division: Int = sum /10 //2
        val decenaSuperior:Int = (division+1) * 10 //(2+1)*10 = 30
        var response: Int=decenaSuperior-sum
        if (decenaSuperior == 10)
            response=0
        return response

    }

    fun validarCedula (cedula:String): Boolean {
        //val sum = sumaValores(cedula)
        //val resta = findDecenaSuperior(sum)
        //obtener decimo digito de la cedula[9]
        // si la resta es igual al 10dig entonces es valida
        // caso contrario invalida
        return true

    }

}
