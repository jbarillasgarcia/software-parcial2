package gt.edu.umg.ingenieria.sistemas.software.parcial2.dao;

import gt.edu.umg.ingenieria.sistemas.software.parcial2.entity.T2Student;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Josué Pivaral
 */
@Repository
public interface T2StudentRepositoryP extends CrudRepository<T2Student, Integer>{
   
    @Query(value = "call sp_consult_students_pages(:numeroPagina,:registrosPorPagina,"
                                          + ":campo,:direccion);",nativeQuery = true)   
    public List<T2Student> getStudentPerPages(@Param("numeroPagina") Integer numeroPagina,
                                 @Param("registrosPorPagina") Integer registrosPorPagina, 
                                 @Param("campo") String campo, 
                                 @Param("direccion") String direccion);
    
    
    
    @Query(value = "call sp_consult_students_pages(5,25,'birthdate','asc');",nativeQuery = true)    
    public List<T2Student> getStudents();
  
}
