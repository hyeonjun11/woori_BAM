package networkTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.print.DocFlavor.INPUT_STREAM;

public class SimpleServer{
    public static void main(String[] args) {
        int port = 9999; // 개발자 지정
        
        try {
			ServerSocket serverSocket = new ServerSocket(port);
			System.out.println("서버가 클라이언트를 기다립니다.");
			
			Socket clientSocket = serverSocket.accept();
			System.out.println("클라이언트가 연결되었습니다.");
			
			InputStream is = clientSocket.getInputStream();
			
			InputStreamReader isr = new InputStreamReader(is);
			
			BufferedReader bfr = new BufferedReader(isr);
			
			String clientmessage = bfr.readLine();
			
			System.out.println("클라이언트 :"+clientmessage) ;
			
			OutputStream os = clientSocket.getOutputStream();
			
			PrintWriter out = new PrintWriter(os,true);
			
			out.println("서버도 안녕합니다");
			
			clientSocket.close();
			System.out.println("서버종료");
					
        
        
        } catch (IOException e) {
			e.printStackTrace();
		}
    }
}
