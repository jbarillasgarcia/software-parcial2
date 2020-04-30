
package gt.edu.umg.ingenieria.sistemas.software.parcial2.service;

import gt.edu.umg.ingenieria.sistemas.software.parcial2.dao.StudentRepository;
import gt.edu.umg.ingenieria.sistemas.software.parcial2.entity.T2Student;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author diegoovalle
 */

@Service
public class StudentService {
    
    @Autowired
    private StudentRepository studentRepo;
    
    /*public List<T2Student> getStudentsInitials(){
        List<T2Student> allStudent;
        
        allStudent = (List<T2Student>) studentRepo.findAll();
        
        
    }
    */
    
    
    public T2Student getStudentById(int id) {
        return this.studentRepo.findById(id).get();
    }
    
    public T2Student getStudentByCarnetNumber(String name) {
        return (T2Student) this.studentRepo.findAllByName(name);
    }
    
    public List<T2Student> getAllStudents() {
        return (List<T2Student>) this.studentRepo.findAll();
    }
    
    public T2Student createStudent(T2Student student) {
        return this.studentRepo.save(student);
    }

    public T2Student updateStudent(T2Student student) {
        return this.studentRepo.save(student);        
    }
    
    public void deleteStudent(int id) {        
        this.studentRepo.deleteById(id);
    }
    
}
