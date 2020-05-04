
package gt.edu.umg.ingenieria.sistemas.software.parcial2.service;

import gt.edu.umg.ingenieria.sistemas.software.parcial2.entity.T2Course;
import gt.edu.umg.ingenieria.sistemas.software.parcial2.entity.T2Student;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import gt.edu.umg.ingenieria.sistemas.software.parcial2.dao.CU06CourseRepository;

@RestController
public class CU06CourseService {
    
    @Autowired    
    private CU06CourseRepository courrep;
    
    public T2Course getCourseById(Integer Id){
         return this.courrep.findById(Id).get();
     }
    
    public T2Course getCourseByName(String name){
        return (T2Course) this.courrep.findByName(name);
     }
    
    
    
    public T2Course saveCourse(T2Course course){     
   
       this.courrep.save(course);
        
        return course;
    }
}
