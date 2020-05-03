package gt.edu.umg.ingenieria.sistemas.software.parcial2.controller;

import gt.edu.umg.ingenieria.sistemas.software.parcial2.entity.T2Student;
import gt.edu.umg.ingenieria.sistemas.software.parcial2.service.T2StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Josué Pivaral
 */
@RestController
public class T2StudentController {
    
    @Autowired
    public T2StudentService studentService;
    
    @GetMapping("student/lazyLoad")
    public List<T2Student> handle1(@RequestParam(name = "page") int page,
                                   @RequestParam(name = "size") int size,
                                   @RequestParam(name = "field") String field,
                                   @RequestParam(name = "direction") String direction){     
       return this.studentService.getStudentPerPages(page,size,field,direction);
   
   } 
    
    @GetMapping("student/lazyLoaded")
    public List<T2Student> handle1(){     
       return this.studentService.getStudentPerPage();
   
   }
    
}
