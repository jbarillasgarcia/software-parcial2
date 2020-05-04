
package gt.edu.umg.ingenieria.sistemas.software.parcial2.service;

import gt.edu.umg.ingenieria.sistemas.software.parcial2.dao.CourseRepository;
import gt.edu.umg.ingenieria.sistemas.software.parcial2.entity.T2Course;
import gt.edu.umg.ingenieria.sistemas.software.parcial2.entity.T2Student;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseService {
    
    @Autowired    
    private CourseRepository courrep;
    
    public T2Course getCourseById(Integer Id){
         return this.courrep.findById(Id).get();
     }
    
    public T2Course getCourseByName(String name){
        return (T2Course) this.courrep.findByName(name);
     }
    
    
    
    public T2Course saveCourse(T2Course course){     
       /* List<T2Course> data =          
        for(T2Course student : course ){
             
            List<T2Student> students = this.Cuo2Repo.findStudentsWithPartOfName(name);
        }*/
       
       /*List<T2Student> dataStudents = course.getT2StudentList();
       int a = course.getIdCourse();
       
       for (T2Student data : dataStudents){
           data.getIdStudent();
       }*/
       
       //this.courrep.save(course);
       this.courrep.save(course);
        
        return course;
    }
}
