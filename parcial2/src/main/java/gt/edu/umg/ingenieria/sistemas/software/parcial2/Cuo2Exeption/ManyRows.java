package gt.edu.umg.ingenieria.sistemas.software.parcial2.Cuo2Exeption;

/**
 *
 * @author Fernando
 */
public class ManyRows extends Exception {
    
    public ManyRows(){
        super("ERROR03|Too many rows");
    }
    
}