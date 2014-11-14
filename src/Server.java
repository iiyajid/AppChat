import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private Socket clientSocket = null;
	private ServerSocket server = null;
	private int port = 1234;
	private String serverMsg = "";
	
	public Server() throws IOException{
		try {
			server = new ServerSocket(port);
			while (true){
				clientSocket = server.accept();
				new ServerThread(clientSocket).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			server.close();
		}
	}
	
	public static void main(String[] args) {
		try {
			Server s = new Server();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean checkPwd(String login, String pwd){
		return true;
	}

}
