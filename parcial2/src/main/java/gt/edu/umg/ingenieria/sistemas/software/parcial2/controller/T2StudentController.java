/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.ingenieria.sistemas.software.parcial2.controller;

import gt.edu.umg.ingenieria.sistemas.software.parcial2.service.T2StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rodrigo
 */

@RestController
public class T2StudentController {
    
    @Autowired
    private T2StudentService studentServ;
    
    @DeleteMapping("/purge/{tableName}/{fildCond}")
    public String delete(@PathVariable String tableName, 
                       @PathVariable String fildCond,
                       @RequestParam(name = "value") String fildVal,
                       @RequestParam(name = "order") String orden,
                       @RequestParam(name = "limit") Integer limitVal){
        return this.studentServ.deleteLimitStoredProcedure(tableName, fildCond, fildVal, orden, limitVal);
    }
}
