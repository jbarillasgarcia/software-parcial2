
package gt.edu.umg.ingenieria.sistemas.software.parcial2.dao;

import gt.edu.umg.ingenieria.sistemas.software.parcial2.entity.T2Student;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CU06StudentRepository extends CrudRepository<T2Student, Integer>{
     public List<T2Student> findByName (String name);   
    
     
    
     @Query(value = "DELETE FROM t2_student_rel_course WHERE id_student = :id AND id_course =:id2",nativeQuery = true)
     public String deleteByAssign(@Param("id")Integer id,@Param("id2")Integer id2);
}
