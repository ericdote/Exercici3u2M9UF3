package activitat3u2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

public class TCPServerSuma {

    static int PORT = 5487;
    private final ServerSocket serverSocket;

    public TCPServerSuma(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
        while (true) {
            Socket ss = serverSocket.accept();
            DataOutputStream outToClient = new DataOutputStream(ss.getOutputStream());
            DataInputStream bf = new DataInputStream(ss.getInputStream());
            int num1 = bf.readInt();
            int num2 = bf.readInt();
            int sum = num1+num2;
            outToClient.writeByte(sum);
            JOptionPane.showMessageDialog(null, "El resultat es: " + sum, "Salida", 1);
            bf.close();
            outToClient.close();
            ss.close();
        }
    }
    
    public static void main(String[] args) throws IOException{
        new TCPServerSuma(PORT);
    }

}
