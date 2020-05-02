package gt.edu.umg.ingenieria.sistemas.software.parcial2.dao;

import gt.edu.umg.ingenieria.sistemas.software.parcial2.entity.T2Student;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Cuo2Repository extends CrudRepository<T2Student, Integer> {
    
   @Query("SELECT u FROM T2Student u WHERE u.name LIKE :username")
   public List<T2Student> findStudentsWithPartOfName( @Param("username") String name);
   
   @Query("SELECT  COUNT(u) FROM T2Student u WHERE u.name LIKE :username")
   Long  countByName(@Param("username") String name);
}
   

    


    
    
    
   
    
    
    
    
    
