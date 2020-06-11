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
public class RowsWithError extends Exception{
    
    public RowsWithError(int r)
    {
        super("The Row No. "+r+" has a error");
    }
}
