 package gt.edu.umg.ingenieria.sistemas.software.parcial2.service;

import gt.edu.umg.ingenieria.sistemas.software.parcial2.dao.Cuo2Repository;
import gt.edu.umg.ingenieria.sistemas.software.parcial2.entity.T2Student;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
@Service
public class Cuo2Service  {
   
   @Autowired 
   private Cuo2Repository Cuo2Repo;
   
   
  public List<T2Student> getStudentsByName(String name){
      System.out.println(this.Cuo2Repo.countByName(name));     
      return this.Cuo2Repo.findStudentsWithPartOfName(name);
      
  }
 
   
  
    
}
