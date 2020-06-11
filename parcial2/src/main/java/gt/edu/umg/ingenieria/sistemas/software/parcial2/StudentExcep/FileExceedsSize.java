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
public class FileExceedsSize extends Exception{
    
    public FileExceedsSize(){
        super("ERROR01|File exceeds 4mb");
    }
    
    
}
