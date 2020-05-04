
package gt.edu.umg.ingenieria.sistemas.software.parcial2.dao;

import gt.edu.umg.ingenieria.sistemas.software.parcial2.entity.T2Student;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CU06StudentRepository extends CrudRepository<T2Student, Integer>{
     public List<T2Student> findByName (String name);   
    
   
}
