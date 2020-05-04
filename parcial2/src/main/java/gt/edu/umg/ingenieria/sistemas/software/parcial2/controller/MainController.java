/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.ingenieria.sistemas.software.parcial2.controller;

import gt.edu.umg.ingenieria.sistemas.software.parcial2.service.FTPServiceImpl;
import java.io.File;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author roco
 */
@RestController
public class MainController {
    
    @Autowired
    private FTPServiceImpl ftpService;

    @RequestMapping( value = "/upload", method = RequestMethod.GET)
    public void uploadExample() throws IOException{
        try {

              ftpService.connectToFTP("ftp.jb-studio.org","pacial2ftp@jb-studio.org","So{w!pEJVSlN");
              ftpService.uploadFileToFTP(new File("/home/roco/Escritorio/Tiburon"),"/Test/","Tiburon");
              //ftpService.downloadFileFromFTP("/Test/FotoTest1.png","/home/roco/Escritorio/kaka.png");

        } catch (FTPErrors ftpErrors) {
            System.out.println(ftpErrors.getMessage());
        }
    }
    
}
