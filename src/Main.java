import java.net.ServerSocket;
import java.net.Socket;


public class Main {

	ServerSocket serverSocket;
	
	//entry point
	public static void main(String[] args) throws Exception {
		new Main().runServer();
	}
				
	public void runServer() throws Exception {
		System.out.println("Server is started");
		serverSocket = new ServerSocket(6543); // port number
		
		//for accepting requests
		acceptRequests();
	}
	
	private void acceptRequests() throws Exception{
		while(true) { //to accept all request
			//connection to client in form of stream to inut and output
			Socket s=serverSocket.accept();
			ConnectionHandler ch = new ConnectionHandler(s);
		
		//ch is the thread so start thread using
			ch.start();//this will start the thread automatically
			
			
		}
		
		
	}
	
}
