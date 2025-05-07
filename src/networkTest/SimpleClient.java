package networkTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SimpleClient {
    public static void main(String[] args) {
        String serverIp = "127.0.0.1"; // localhost
        int port = 9999;
        
        try {
			Socket socket = new Socket(serverIp,port);
			System.out.println("서버에 연결중입니다.");
			
			OutputStream os = socket.getOutputStream();
			
			PrintWriter out = new PrintWriter(os,true);
			
			out.println("안녕하세요");
			
			InputStream is = socket.getInputStream();
			
			InputStreamReader isr = new InputStreamReader(is);
			
			BufferedReader bfr = new BufferedReader(isr);
			
			String servermessage = bfr.readLine();
			
			System.out.println("서버 응답 :"+ servermessage);
        
        
        
        
        
        } catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
    }
}