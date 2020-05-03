/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.ingenieria.sistemas.software.parcial2.service;

import gt.edu.umg.ingenieria.sistemas.software.parcial2.entity.T2Student;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import gt.edu.umg.ingenieria.sistemas.software.parcial2.dao.T2StudentRepository;

/**
 *
 * @author Josué Pivaral
 */
@Service
public class T2StudentService {
    
   @Autowired
   private T2StudentRepository studentRepository; 
    
   public List<T2Student> getStudentPerPages(int numeroPagina,int registrosPorPagina,
                                             String campo, String direccion){
           
      return this.studentRepository.getStudentPerPages(numeroPagina,registrosPorPagina,
                                                        campo,direccion);
  }
   
   public List<T2Student> getStudentPerPage(){
          
      return this.studentRepository.getStudents();
  }
  
   
}
