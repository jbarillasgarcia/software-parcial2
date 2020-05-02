
package gt.edu.umg.ingenieria.sistemas.software.parcial2.controller;

import gt.edu.umg.ingenieria.sistemas.software.parcial2.entity.T2Student;
import gt.edu.umg.ingenieria.sistemas.software.parcial2.service.StudentService;
import java.io.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class StudentController {
    
    @Autowired
    private StudentService sr;
    
    @PostMapping("/import/fromxlsx")
    public void insertFromXlsx(@RequestBody(required = true) MultipartFile file)
    {
        this.sr.insertFromExcelFile(file);
    }
    
}
