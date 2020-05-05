package gt.edu.umg.ingenieria.sistemas.software.parcial2;


import gt.edu.umg.ingenieria.sistemas.software.parcial2.ftpclient.FTPService;
import gt.edu.umg.ingenieria.sistemas.software.parcial2.ftpexceptions.FTPErrors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;


@RestController
public class MainController {

    @Autowired
    private FTPService ftpService;

    @RequestMapping( value = "/upload", method = RequestMethod.GET)
    public void uploadExample(){
        ftpService.connectToFTP("ftp.jb-studio.org","pacial2ftp@jb-studio.org","So{w!pEJVSlN");
        ftpService.uploadFileToFTP(new File("/Users/diegoovalle/Desktop/UseCase9ISP2.xls"),"/Test/","Test.xls");
        ftpService.downloadFileFromFTP("/Test/FotoTest1.png","/Users/diegoovalle/Desktop/kaka.png");
    }


}
