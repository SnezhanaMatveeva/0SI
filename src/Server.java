import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int PORT = 8080;

    public static void main(String[] args) {
try(ServerSocket serverSocket=new ServerSocket(PORT)){
    System.out.println("Server started");
    while (true) {
        try (Socket clientsSocket = serverSocket.accept();
             PrintWriter out=new PrintWriter(clientsSocket.getOutputStream(),true);
             BufferedReader in=new BufferedReader(new InputStreamReader(clientsSocket.getInputStream()))){
            System.out.println(in.readLine());
            out.println("New connection accepted from adress "+clientsSocket.getInetAddress());
            out.println("New connection accepted from port "+clientsSocket.getLocalPort());
        }
    }
} catch (IOException e) {
  throw new RuntimeException(e);

}
    }
}
