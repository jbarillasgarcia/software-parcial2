package gt.edu.umg.ingenieria.sistemas.software.parcial2;

import java.io.IOException;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Parcial2Application {

	public static void main(String[] args) {
		SpringApplication.run(Parcial2Application.class, args);
                
        }
}
                
                
               /* FTPClient client = new FTPClient();

        try {
            client.connect("ftp.jb-studio.org");

            // When login success the login method returns true.
            boolean login = client.login("pacial2ftp@jb-studio.org", "So{w!pEJVSlN");
            if (login) {
                System.out.println("Login success...");

                // When logout success the logout method returns true.
                boolean logout = client.logout();
                if (logout) {
                    System.out.println("Logout from FTP server...");
                }
            } else {
                System.out.println("ç fail...");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // Closes the connection to the FTP server
                client.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }*/



