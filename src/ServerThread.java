import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerThread extends Thread{
	private Socket clientSocket = null;
	private ServerSocket server = null;
	private String serverMsg = "";
	
	public ServerThread(Socket s) {
		this.clientSocket= s;
	}
	
	public void run(){
		BufferedReader in = null;
		PrintWriter out = null;
		try{
			in = new BufferedReader(
					new InputStreamReader(clientSocket.getInputStream()));
			out = new PrintWriter(
					new OutputStreamWriter(clientSocket.getOutputStream()), true);
			while (!serverMsg.equals("fin.")){
				serverMsg = in.readLine();
				System.out.println(serverMsg);
				out.println(serverMsg);
			}
			serverMsg = "";
			out.close();
		}catch(IOException e) {
			e.printStackTrace();
		}finally{
			out.close();
		}
		
	}
}
