
package gt.edu.umg.ingenieria.sistemas.software.parcial2.controller;

import gt.edu.umg.ingenieria.sistemas.software.parcial2.entity.T2Course;
import gt.edu.umg.ingenieria.sistemas.software.parcial2.entity.T2Student;
import gt.edu.umg.ingenieria.sistemas.software.parcial2.service.CU05CourseService;
import gt.edu.umg.ingenieria.sistemas.software.parcial2.service.CU05StudentService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CU05StudentController {
    
   @Autowired
   public CU05StudentService studentService;
   
   @Autowired
   public CU05CourseService courseService;    
    
    @GetMapping("/findv")
    public List<T2Student> geteEstu(){
        return studentService.geteEstu();    
    }
    
    @GetMapping("/estudiantePorId")
    public T2Student getEstudianteById(@RequestParam int id){
       return this.studentService.getEstudianteById(id);
    }
    
    @GetMapping("/estudiantePorNombre")
     public List<T2Student> getEstudianteByName(@RequestParam String nombre){
       return this.studentService.getEstudianteByName(nombre);
    }
     
     @GetMapping("/cursoePorNombre")
     public T2Course getCursoByName(@RequestParam String nombre){
       return this.courseService.getCourseByName(nombre);
    }       

     @PostMapping("/insertar")
    public T2Course insertar(@RequestParam int alumno, int curso){
            
        // Vamos a traer el estudiante que queremos asignar
        T2Student theStudent = (T2Student) this.studentService.getEstudianteById(alumno);
        
        // Hacemos una lista de los estudiantes a asignar
        List<T2Student> students = new ArrayList<>();        
        students.add(theStudent);
        
        // Vamos a traer nuestro curso
        T2Course newCourse = (T2Course) this.courseService.getCourseById(curso);
        
        // Verificamos que la lista de cursos del estudiante no sea nula. Esto esta demas pero por si acaso lo dejamos.
        if (theStudent.getT2CourseList() == null) {
            theStudent.setT2CourseList(new ArrayList<>());
        }
        
        // Al estudiante le agregamos el curso
        theStudent.getT2CourseList().add(newCourse);
        
        // Verificamos que la lista de estudiantes ya asignados no sea nula. Esto esta demas pero por si acaso lo dejamos.
        if (newCourse.getT2StudentList() == null) {
            newCourse.setT2StudentList(new ArrayList<>());
        }
        
        // Al curso le agregamos el estudiante
        newCourse.getT2StudentList().add(theStudent);     
        
        // Guardamos el curso
        return this.courseService.saveCourse(newCourse);                                                                            
    }      
}