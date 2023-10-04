package net;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class SocketClientSide {
    public static void main(String[] args) throws IOException {
        try(Socket socket = new Socket()){
            socket.connect(new InetSocketAddress("localhost",8189),2000);
            Scanner cmd = new Scanner(System.in);
            Scanner scanner = new Scanner(socket.getInputStream());
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
            while (cmd.hasNextLine()){
                printWriter.println(cmd.nextLine());
                String str = scanner.nextLine();
                System.out.println(str);
                if (str.equals("you've sent: exit")){
                    break;
                }
            }
        }
    }

}
