import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;


public class Client {
	private String serverAdress = "127.0.0.1";
	private int portNumber = 1234;
	private Socket socket = null;
	private String msgClient = "test to server";
	private String msgServer = "test from server";

	
	public Client() {
		try {
			socket = new Socket(serverAdress, portNumber);
			
			BufferedReader in = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(
					new OutputStreamWriter(socket.getOutputStream()), true);
			while(!(msgClient.equals("fin."))){
				msgClient = this.readMessage();
				out.println(msgClient);
				out.flush();
				msgServer= in.readLine();
				System.out.println(msgServer);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			
		}
	}
	
	public String readMessage() throws IOException{
		BufferedReader inStream =
				new BufferedReader (new InputStreamReader(System.in));
		System.out.print("> ");
		return inStream.readLine();
	}
	
	public String getMsgClient(){
		return msgClient;
	}

	public String getServerAdress() {
		return serverAdress;
	}

	public void setServerAdress(String serverAdress) {
		this.serverAdress = serverAdress;
	}

	public int getPortNumber() {
		return portNumber;
	}

	public void setPortNumber(int portNumber) {
		this.portNumber = portNumber;
	}

	public String getMsgServer() {
		return msgServer;
	}

	public void setMsgServer(String msgServer) {
		this.msgServer = msgServer;
	}

	public void setMsgClient(String msgClient) {
		this.msgClient = msgClient;
	}
	
	
	//main
	public static void main(String[] args) {
		Client c = new Client();
	}
	

}
