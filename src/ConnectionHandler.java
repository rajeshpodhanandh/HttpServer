import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


//this class basically handles all the connection having requests

public class ConnectionHandler extends Thread{ //by extending to thread, this class becomes a thread

	Socket s;

	//for sending o/p to client
	PrintWriter pw;

	//getting i/p from client
	BufferedReader br;



	//constructor 
	//which accepts socket
	public ConnectionHandler (Socket s) throws Exception{
		this.s=s;
		br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		pw = new PrintWriter(s.getOutputStream());
	}

	//Thread class contains method which is called auto
	//here we have to read the request and give the response
	@Override
	public void run() {

		try {
			//here we get the request string and gives to Http 

			String reqS = "";

			//from br we have to read request
			// read until request is not received or br is not ready
			while(br.ready() || reqS.length() == 0)
				reqS += (char) br.read(); 
			System.out.println(reqS); //for display 

			HttpRequest req = new HttpRequest(reqS);

			//we pass the httprequest object to http response class for getting response

			HttpResponse res = new HttpResponse(req);

			//final O/P to pw
			pw.write(res.response.toCharArray());

			pw.close();
			br.close();
			s.close();

		}catch(Exception e) {
			e.printStackTrace();

		}
	}


}
