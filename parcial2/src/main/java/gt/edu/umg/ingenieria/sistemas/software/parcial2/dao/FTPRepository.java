/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.ingenieria.sistemas.software.parcial2.dao;

import gt.edu.umg.ingenieria.sistemas.software.parcial2.controller.FTPErrors;
import org.springframework.stereotype.Repository;
import java.io.File;

/**
 *
 * @author roco
 */
@Repository
public interface FTPRepository {
    
    void connectToFTP(String host, String user, String pass) throws FTPErrors;
     void uploadFileToFTP(File file, String ftpHostDir , String serverFilename) throws FTPErrors;
     void downloadFileFromFTP(String ftpRelativePath, String copytoPath) throws FTPErrors;
     void disconnectFTP() throws FTPErrors;
    
}
