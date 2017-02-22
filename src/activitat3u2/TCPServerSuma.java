package activitat3u2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

public class TCPServerSuma {
    //Declarem el PORT
    static int PORT = 5487;
    //Inicialitzem el ServerSocket
    private final ServerSocket serverSocket;
    DataOutputStream outToClient;
    DataInputStream bf;
    /**
     * Aquest constructor li arriba per parametre el port per inicialitzar el ServerSocket.
     * Un cop fet aixo, declarem el DataOutput i Input, llegim els dos numeros, i fem la suma.
     * Per ultim mostrem la suma en un Pane.
     * @param port
     * @throws IOException 
     */
    public TCPServerSuma(int port) throws IOException {
        //Inicialitzem el ServerSocket
        this.serverSocket = new ServerSocket(port);
        //Bucle per recogir totes les dades
        while (true) {
            //Declarem un Socket
            Socket ss = serverSocket.accept();
            //Declarem el DataOutput i Input
            outToClient = new DataOutputStream(ss.getOutputStream());
            bf = new DataInputStream(ss.getInputStream());
            //Llegim els dos numeros i els sumem
            int num1 = bf.readInt();
            int num2 = bf.readInt();
            int sum = num1+num2;
            //Escribim en bytes el resultat
            outToClient.writeByte(sum);
            //Mostrem el resultat en una DialogBox
            JOptionPane.showMessageDialog(null, "El resultat es: " + sum, "Salida", 1);
            bf.close();
            outToClient.close();
            ss.close();
        }
    }
    /**
     * Metode main que inicialitza el TCPServerSuma
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException{
        new TCPServerSuma(PORT);
    }

}
