package gt.edu.umg.ingenieria.sistemas.software.parcial2.services;

import gt.edu.umg.ingenieria.sistemas.software.parcial2.dao.T2StudentRepository;
import gt.edu.umg.ingenieria.sistemas.software.parcial2.entity.T2Student;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
   
    @Autowired
    private T2StudentRepository studentRepo;

    public String deleteLimitStoredProcedure(String tableName, String fildCon, String fildVal, String orden, int limitVal) { 
       return this.studentRepo.deleteLimitStoredProcedure(tableName, fildCon, fildVal, orden, limitVal);
    }
   
}
