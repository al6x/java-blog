import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
  // The `main` method would be called when the program starts.
  public static void main(String[] args) throws IOException {
    // Listening for connections of port 3000.
    ServerSocket serverSocket = new ServerSocket(3000);
    // Creating endless loop, accepting any incoming connection.
    while (true) {
      // Blocking call, waiting until someone would connect.
      Socket socket = serverSocket.accept();
      // Getting output stream to write data to socket.
      OutputStream output = socket.getOutputStream();
      // Writing "Hello World!" message.
      String message = "Hello World";
      // In order for Browser to understood the message it should comply to the HTTP format, adding HTTP header.
      String httpHeader =
        "HTTP/1.0 200 OK\r\n" +
        "Content-Length: " + message.length() + "\r\n" +
        "\r\n";
      // Writing HTTP header and message.
      output.write((httpHeader + message).getBytes());
      // Closing output stream and the socket.
      output.close();
      socket.close();
    }
  }
}