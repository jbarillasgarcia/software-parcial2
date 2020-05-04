/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.ingenieria.sistemas.software.parcial2.dao;

import gt.edu.umg.ingenieria.sistemas.software.parcial2.entity.T2Course;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author pc
 */
public interface CourseRepository  extends CrudRepository<T2Course, Integer>{
     public List<T2Course> findByName (String name);    
     
}

