/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.ingenieria.sistemas.software.parcial2.service;

import gt.edu.umg.ingenieria.sistemas.software.parcial2.StudentExcep.FileExceedsSize;
import gt.edu.umg.ingenieria.sistemas.software.parcial2.dao.StudentRepository;
import gt.edu.umg.ingenieria.sistemas.software.parcial2.entity.T2Student;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StudentService {
    
    @Autowired
    private StudentRepository strepo;
    
    public void insertFromExcelFile(MultipartFile excelFile) throws Exception, FileExceedsSize
    {   
        String log[] = new String[9];
        int cont = 0;
        
        if(excelFile.getSize() > 4000000)
        {
            throw new FileExceedsSize();     
        }
        
        try(FileInputStream file = new FileInputStream(convert(excelFile)))
        {
            XSSFWorkbook ws = new XSSFWorkbook(file);
            //Choose a sheet from file
            XSSFSheet s = ws.getSheetAt(0);
            //get all rows from file
            Iterator<Row> rI = s.iterator();
            
            Row row;
                while(rI.hasNext())
                {
                    row = rI.next();
                    //get cell by row
                    Iterator<Cell> cI = row.cellIterator();
                    Cell cell;
                     while(cI.hasNext())
                        {
                            cell = cI.next();
                            switch(cell.getCellType())
                            {
                                case NUMERIC: 
                                    System.out.println("N"+cell.getNumericCellValue());
                                break; 
                                
                                case STRING:
                                    //System.out.println("S "+cell.getStringCellValue());
                                    log[cont] = cell.getStringCellValue();
                                    cont++;
                                break;
                            }
                        }
                      this.strepo.save(getT2St(log));
                      cont = 0;
                      //System.out.println("\n");
                }
        file.close();
        } catch(Exception e) {
            e.printStackTrace();
                             }
    
    }
    
    
    //--------------------------------FUNCTIIONS To 1.
    private static File convert(MultipartFile file) throws IOException {
	File convFile = new File(file.getOriginalFilename());
	convFile.createNewFile();
	FileOutputStream fos = new FileOutputStream(convFile);
	fos.write(file.getBytes());
	fos.close();
	return convFile;
    }
    
    private static Date convertDate(String date)
    {
        Date date1 = new Date();
        try {
            date1 = new SimpleDateFormat("yyyy/MM/dd").parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return date1;
    }
    
    private static T2Student getT2St(String log[])
    {
        
        T2Student st = new T2Student();
        
        st.setIdStudent(null);
        st.setName(log[0]);
        st.setSurname(log[1]);
        st.setEmail(log[2]);
        st.setBirthdate(convertDate(log[3]));
        st.setStudentId(log[4]);
        st.setPhone1(log[5]);
        st.setPhone2(log[6]);
        st.setAddress1(log[7]);
        st.setAddress2(log[8]);
        
        return st;
    }
}
