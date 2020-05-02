
package gt.edu.umg.ingenieria.sistemas.software.parcial2.dao;

import gt.edu.umg.ingenieria.sistemas.software.parcial2.entity.T2Student;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository <T2Student, Integer>{
    
    public List<T2Student> findAllByName(String name);
    
    List<T2Student> findByName(String name);
    
    /*@Query("select substr(name,1,1) as alpha, count(id_student) from t2_student group by substr(name,1,1)")
    List<T2Student> findByInitial(String name);*/
    
}
