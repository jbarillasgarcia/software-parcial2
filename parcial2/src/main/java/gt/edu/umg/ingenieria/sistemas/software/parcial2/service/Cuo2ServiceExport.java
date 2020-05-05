
package gt.edu.umg.ingenieria.sistemas.software.parcial2.service;

import gt.edu.umg.ingenieria.sistemas.software.parcial2.Cuo2Exeption.DosentAnypercent;
import gt.edu.umg.ingenieria.sistemas.software.parcial2.Cuo2Exeption.ManyRows;
import gt.edu.umg.ingenieria.sistemas.software.parcial2.Cuo2Exeption.StudentNameNotFound;
import gt.edu.umg.ingenieria.sistemas.software.parcial2.dao.Cuo2Repository;
import gt.edu.umg.ingenieria.sistemas.software.parcial2.dao.Cuo2RepositoryExport;
import gt.edu.umg.ingenieria.sistemas.software.parcial2.entity.T2Student;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Cuo2ServiceExport implements Cuo2RepositoryExport {
    
    @Autowired 
   private Cuo2Repository Cuo2Repo;

    @Override
    public ByteArrayInputStream exportData(String name) throws Exception ,StudentNameNotFound, DosentAnypercent, ManyRows {
        
        System.out.println(this.Cuo2Repo.countByName(name));
        
        List<T2Student> students = this.Cuo2Repo.findStudentsWithPartOfName(name);
       
        if(name.indexOf("%")==-1 ){
              throw new DosentAnypercent();
        }else if(this.Cuo2Repo.countByName(name)==0){   
             throw new StudentNameNotFound();
        }else if(this.Cuo2Repo.countByName(name)>=10000){
            throw new ManyRows();
        }    
            
        String[] columns ={"idStudent","name","surname","email","birthdate","studentId","phone1","phone2","address1","address2"};
      Workbook workbook = new HSSFWorkbook();
      //ByteArrayOutputStream stream = new ByteArrayOutputStream(); 
      
      ByteArrayOutputStream stream = getByteStreamMethod();
try(OutputStream outputStream = new FileOutputStream("thefilename")) {
    stream.writeTo(outputStream);
}
      
      
      
      Sheet sheet = workbook.createSheet("Student");
      Row row = sheet.createRow(0);
      
      for(int i=0; i<columns.length; i++ ){
         Cell cell = row.createCell(i);
         cell.setCellValue(columns[i]);
      }
      
      int initRow =1;
      for(T2Student student : students ){
      row = sheet.createRow(initRow);
      row.createCell(0).setCellValue(student.getIdStudent());
      row.createCell(1).setCellValue(student.getName());
      row.createCell(2).setCellValue(student.getSurname());
      row.createCell(3).setCellValue(student.getEmail());
      row.createCell(4).setCellValue(student.getBirthdate());
      row.createCell(5).setCellValue(student.getStudentId());
      row.createCell(6).setCellValue(student.getPhone1());
      row.createCell(7).setCellValue(student.getPhone2());
      row.createCell(8).setCellValue(student.getAddress1());
      row.createCell(9).setCellValue(student.getAddress2());
      
      initRow++;
  }
            
    workbook.write(stream);
    workbook.close();
    
    
    return new ByteArrayInputStream(stream.toByteArray());
        
          
    }

    @Override
    public T2Student save(T2Student entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T2Student get(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<T2Student> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private ByteArrayOutputStream getByteStreamMethod() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
