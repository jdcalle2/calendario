package service

import com.example.academico.model.Student
import com.example.academico.repository.StudentRepository
import com.example.academico.service.StudentService
import com.google.gson.Gson
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.io.File

class StudentServiceTest {

    @SpringBootTest
    class ProductServiceTest {

        @InjectMocks
        lateinit var studentService: StudentService

        @Mock
        lateinit var studentRepository: StudentRepository

        val jsonString = File("./src/test/resources/product.json").readText(Charsets.UTF_8)
        val productMock = Gson().fromJson(jsonString, Student::class.java)

        @Test
        fun saveProduct(){
            //PAra actualizar
            /// LLAVES  FORENEAS
            //Mockito.`when`(productRepository.findById(productMock.id)).thenReturn(productMock)
            Mockito.`when`(studentRepository.save(Mockito.any(Student::class.java))).thenReturn(productMock)
            val response = studentService.save(productMock)
            Assertions.assertEquals(response?.id, productMock.id)
        }

        @Test
        fun saveProductFailed(){
            Assertions.assertThrows(Exception::class.java) {
                productMock.apply { id = 1}
                Mockito.`when`(studentRepository.save(Mockito.any(Student::class.java))).thenReturn(productMock)
                studentService.save(productMock)
            }
        }

    }
}





    /*@Autowired
    lateinit var studentService: StudentService

    @Test
    fun validateSerialIsValid(){
        val response =  studentService.validateSerialNumber("786456789")
        Assertions.assertEquals(true,response)
    }

    @Test
    fun validateSerialIsInvalid(){
        val response =  studentService.validateSerialNumber("32154697")
        Assertions.assertEquals(false,response)
    }

    @Test
    fun validateSerialIsBlank(){
        Assertions.assertThrows(Exception::class.java) {
            val response = studentService.validateSerialNumber("")

        }
    }

    @Test
    fun validateSerialIsincomplete(){
        Assertions.assertThrows(Exception::class.java) {
            val response = studentService.validateSerialNumber("1")

        }
    }*/

/*@Autowired
lateinit var studentService: StudentService
@Test
fun multiplicacionWhenLessThanTen (){
    val response=studentService.multiplicacion(1,7)
    Assertions.assertEquals(7,response)
}

@Test
fun multiplicacionWhenMajorThanTen (){
    val response=studentService.multiplicacion(2,7)
    Assertions.assertEquals(5,response)
}

@Test
fun validarSumaNui(){
    val response=studentService.sumaValores("0301707030")
    Assertions.assertEquals(20,response)
}

@Test
fun validarDecenaSuperiorCuandoNoEsCero(){
    val response=studentService.findDecenaSuperior(26)
    Assertions.assertEquals(4,response)
}

@Test
fun validarDecenaSuperiorCuandoEsCero(){
    val response=studentService.findDecenaSuperior(20)
    Assertions.assertEquals(0,response)
}

@Test
fun validarDecenaSuperiorCuandoNoEsCero(){
    val response=studentService.findDecenaSuperior(26)
    Assertions.assertEquals(4,response)
}

@Test
fun validarDecenaSuperiorCuandoEsCero(){
    val response=studentService.findDecenaSuperior(20)
    Assertions.assertEquals(0,response)
}

@Test
fun validarCedulaValida(){
    //val response=studentService.findDecenaSuperior(20)
    //Assertions.assertEquals(0,response)
}
@Test
fun validarCedulaInValida(){
    //val response=studentService.findDecenaSuperior(20)
    //Assertions.assertEquals(0,response)
}
}*/



