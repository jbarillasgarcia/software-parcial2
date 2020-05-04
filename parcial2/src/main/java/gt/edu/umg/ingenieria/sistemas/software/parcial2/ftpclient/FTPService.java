package gt.edu.umg.ingenieria.sistemas.software.parcial2.ftpclient;

import cu.yoandypv.ftp.exceptions.FTPErrors;

import java.io.File;


public interface FTPService {
     void connectToFTP(String host, String user, String pass) throws FTPErrors;
     void uploadFileToFTP(File file, String ftpHostDir , String serverFilename) throws FTPErrors;
     void downloadFileFromFTP(String ftpRelativePath, String copytoPath) throws FTPErrors;
     void disconnectFTP() throws FTPErrors;

}
