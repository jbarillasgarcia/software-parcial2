/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.ingenieria.sistemas.software.parcial2.service;

import gt.edu.umg.ingenieria.sistemas.software.parcial2.dao.T2StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rodrigo
 */

@Transactional
@Service
public class T2StudentService {
    
    @Autowired
    private T2StudentRepository studentRepo;

    public String deleteLimitStoredProcedure(String tableName, String fildCon, String fildVal, String orden, int limitVal) { 
       return this.studentRepo.deleteLimitStoredProcedure(tableName, fildCon, fildVal, orden, limitVal);
    }
    
    
    
}
