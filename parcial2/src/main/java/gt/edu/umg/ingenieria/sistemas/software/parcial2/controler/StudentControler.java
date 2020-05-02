
package gt.edu.umg.ingenieria.sistemas.software.parcial2.controler;

import gt.edu.umg.ingenieria.sistemas.software.parcial2.entity.T2Student;
import gt.edu.umg.ingenieria.sistemas.software.parcial2.service.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author diegoovalle
 */
@RestController
@RequestMapping("/student")
public class StudentControler {
    
    @Autowired
    private StudentService studentService;

    @GetMapping("/getById")
    public T2Student getById(@RequestParam(name = "id", required = true) int id) {
        return this.studentService.getStudentById(id);
    }
    
    @GetMapping("/getByCarnetNumber")
    public T2Student getByCarnetNumber(@RequestParam(name = "carnetNumber", required = true) String carnetNumber) {
        return this.studentService.getStudentByCarnetNumber(carnetNumber);
    }
    
    @GetMapping("/getAll")
    public List<T2Student> getAll() {
        return this.studentService.getAllStudents();
    }
    
    @PostMapping("/create")
    public T2Student create(@RequestBody(required = true) T2Student newStudent) {
        return this.studentService.createStudent(newStudent);
    }
    
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable(required = true) int id) {
        this.studentService.deleteStudent(id);
        
        return String.format("El estudiante con id = %d ha sido eliminado del sistema.", id);
    }
    
    @PutMapping("/update/{id}")
    public T2Student update(@PathVariable(required = true) int id, @RequestBody(required = true) T2Student studentToUpdate) {
        return this.studentService.updateStudent(studentToUpdate);
    }  
    
    /*@GetMapping("/findByInitial")
    public List<T2Student> findByInitial() {
        return this.studentService.findByInitial();
    }*/
    
}
