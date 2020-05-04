/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.ingenieria.sistemas.software.parcial2.dao;

import gt.edu.umg.ingenieria.sistemas.software.parcial2.entity.T2Course;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author pc
 */
public interface CU06CourseRepository  extends CrudRepository<T2Course, Integer>{
     public List<T2Course> findByName (String name);    
     
      
     @Query(value = "DELETE FROM t2_student_rel_course WHERE id_student = :id AND id_course =:id2",nativeQuery = true)
     public String deleteByAssign(@Param("id")Integer id,@Param("id2")Integer id2);
    
     
}

