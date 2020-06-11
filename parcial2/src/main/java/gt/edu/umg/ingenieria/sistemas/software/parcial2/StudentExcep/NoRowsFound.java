/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.ingenieria.sistemas.software.parcial2.StudentExcep;

/**
 *
 * @author dlagu
 */
public class NoRowsFound extends Exception {
    
    public NoRowsFound(){
        super("ERROR02|No rows found");
    }
    
}
