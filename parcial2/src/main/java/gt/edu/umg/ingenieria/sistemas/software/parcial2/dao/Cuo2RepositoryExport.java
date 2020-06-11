package gt.edu.umg.ingenieria.sistemas.software.parcial2.dao;

import gt.edu.umg.ingenieria.sistemas.software.parcial2.Cuo2Exeption.DosentAnypercent;
import gt.edu.umg.ingenieria.sistemas.software.parcial2.Cuo2Exeption.ManyRows;
import gt.edu.umg.ingenieria.sistemas.software.parcial2.Cuo2Exeption.StudentNameNotFound;
import gt.edu.umg.ingenieria.sistemas.software.parcial2.entity.T2Student;
import java.io.ByteArrayInputStream;


public interface Cuo2RepositoryExport extends GenericServiceAPI<T2Student, Long>{
   
    ByteArrayInputStream exportData(String name) throws Exception, StudentNameNotFound, DosentAnypercent, ManyRows ; 

}


