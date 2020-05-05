package gt.edu.umg.ingenieria.sistemas.software.parcial2.ftpclient;



import java.io.File;


public interface FTPService {
     void connectToFTP(String host, String user, String pass);
     void uploadFileToFTP(File file, String ftpHostDir , String serverFilename) ;
     void downloadFileFromFTP(String ftpRelativePath, String copytoPath) ;
     void disconnectFTP() ;

}
