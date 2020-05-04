package gt.edu.umg.ingenieria.sistemas.software.parcial2.service;

import gt.edu.umg.ingenieria.sistemas.software.parcial2.entity.T2Course;
import gt.edu.umg.ingenieria.sistemas.software.parcial2.entity.T2Student;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gt.edu.umg.ingenieria.sistemas.software.parcial2.dao.CU05CourseRepository;
import gt.edu.umg.ingenieria.sistemas.software.parcial2.dao.CU05StudentRepository;

@Service
public class CU05StudentService {
   
    @Autowired    
    private CU05StudentRepository studrepo;
    private CU05CourseRepository courrep;
     
     public List<T2Student> geteEstu(){
        List<T2Student> data;
        
        data = (List <T2Student>) studrepo.findAll();
        for(T2Student e : data){
            e.getName();
        }
            
        return data;
    }
    
     
     public T2Student getEstudianteById(Integer Id){
         return this.studrepo.findById(Id).get();
     }
     
     public T2Course getCourseById(Integer Id){
         return this.courrep.findById(Id).get();
     }
     
    public List<T2Student> getEstudianteByName(String nombre){
        return this.studrepo.findByName(nombre);
    }
       
}
