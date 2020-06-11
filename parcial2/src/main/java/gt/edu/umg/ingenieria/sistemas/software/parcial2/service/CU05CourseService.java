
package gt.edu.umg.ingenieria.sistemas.software.parcial2.service;

import gt.edu.umg.ingenieria.sistemas.software.parcial2.entity.T2Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import gt.edu.umg.ingenieria.sistemas.software.parcial2.dao.CU05CourseRepository;

@RestController
public class CU05CourseService {
    
    @Autowired    
    private CU05CourseRepository courrep;
    
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
             
       this.courrep.save(course);              
        return course;
    }
}
