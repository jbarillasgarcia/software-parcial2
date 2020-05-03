package gt.edu.umg.ingenieria.sistemas.software.parcial2.controller;


import gt.edu.umg.ingenieria.sistemas.software.parcial2.dao.Cuo2RepositoryExport;
import gt.edu.umg.ingenieria.sistemas.software.parcial2.entity.T2Student;
import gt.edu.umg.ingenieria.sistemas.software.parcial2.service.Cuo2Service;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class Cuo2Controller {
    
    @Autowired 
   private Cuo2Service Cuo2Service;
   @Autowired 
   private Cuo2RepositoryExport Cuo2RepoExport;


 @GetMapping("/test/getstudent")
   public List<T2Student> handle1( @RequestParam(name = "student") String student){     
       return this.Cuo2Service.getStudentsByName(student);
   
   } 
  
   @GetMapping("/export/toxlsx") 
  public ResponseEntity<InputStreamResource> export(@RequestParam(name = "student") String student) throws Exception{
      

          
      //ByteArrayResource stream = this.Cuo2RepoExport.exportData(student);
     ByteArrayInputStream stream = Cuo2RepoExport.exportData(student);
  
  HttpHeaders headers = new HttpHeaders();
  headers.add("Content-Disposition", "attachment; filename=Students.xls");
  
  return ResponseEntity.ok().headers(headers).body(new InputStreamResource(stream));
  } 
 

   
 
 


  
  
  
}



   


    

