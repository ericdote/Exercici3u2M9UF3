package activitat3u2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import javax.swing.JOptionPane;

public class TCPClientSuma {
    //Declarem el host i el port per defecte
    static String HOST = "localhost";
    static int PORT = 5487;
    //Declarem els diferents objectes.
    private final Socket ss;
    private final DataOutputStream outToServer;
    private final BufferedReader bf;
    /**
     * Creem el constructor que li arribara per parametre un host i un port.
     * Dins inicialitzem els objectes i passem per teclat els dos numeros, els escribim i els enviem al Server.
     * @param host
     * @param port
     * @throws IOException 
     */
    public TCPClientSuma(String host, int port) throws IOException {
        //Inicialitzem el Sokcet
        this.ss = new Socket(host, port);
        //Inicialitzem el DataOutput.. I el Buffer
        outToServer = new DataOutputStream(ss.getOutputStream());
        bf = new BufferedReader(new InputStreamReader(ss.getInputStream()));
        //Demanem el primer i segon nombre que volem
        String num1 = JOptionPane.showInputDialog(null, "Dona el primer numero: ","Entrando",3);
        String num2 = JOptionPane.showInputDialog(null, "Dona el segon numero: ", "Entrando",3);
        //Escribim i enviem al Server els dos numeros, pero abans es parsean.
        outToServer.writeInt(Integer.parseInt(num1));
        outToServer.writeInt(Integer.parseInt(num2));
        bf.close();
        outToServer.close();
        ss.close();

    }
    /**
     * Metode main on inicialitzem la clase TCPClientSuma
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException{
        new TCPClientSuma(HOST, PORT);
    }


}
