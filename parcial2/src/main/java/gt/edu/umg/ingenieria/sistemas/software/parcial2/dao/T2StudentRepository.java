/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.ingenieria.sistemas.software.parcial2.dao;

import gt.edu.umg.ingenieria.sistemas.software.parcial2.entity.T2Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rodrigo
 */

@Repository
public interface T2StudentRepository extends CrudRepository<T2Student, Integer> {
    
    @Query(value = "call deleteByLot(:tableName, :fildCond, :fildVal, :orden, :limitVal);",nativeQuery = true)
    public String deleteLimitStoredProcedure(@Param("tableName") String tableName, 
                                           @Param("fildCond") String fildCond, 
                                           @Param("fildVal") String fildVal,
                                           @Param("orden") String orden,
                                           @Param("limitVal") Integer limitVal);
}
