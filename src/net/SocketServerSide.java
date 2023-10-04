package net;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SocketServerSide {
    public static void main(String[] args) throws IOException {
        try(ServerSocket serverSocket = new ServerSocket(8189)){
            new Thread(new MyServer(serverSocket.accept())).start();
        }
    }
}
class MyServer implements Runnable{
    private Socket socket;

    public MyServer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(socket.getInputStream());
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            //writer.println("hello");
            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                writer.println("you've sent: " + str);
                System.out.println("user sent: "+str);
                if (str.equals("exit")) {
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
