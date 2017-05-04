import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class HttpResponse {

	//we have to create an sender
	HttpRequest req;

	//this is final response generated
	String response;

	//root path to server(ie folder which contains files)
	String root = "C:/Rajesh BM/EclipseWorkSpace/root";

	public HttpResponse(HttpRequest request) throws Exception {
		req = request;
		//now open the file mentioned in request
		File f =  new File(root + req.filename);

		try{



			response = "HTTP/1/1 200"; //version, 200 is all okay
			response += "Server: Java server/1.0\r\n"; //server identity
			response += " Content type-HTML \r\n";
			response += "Content length :" +f.length() + "\r\n";
			response += "Connection: close \r\n";
			response += "\r\n"; //blank line

			//to read this file
			FileInputStream fis = new FileInputStream(f);

			int s;
			while ((s=fis.read()) != -1) {
				response += (char) s;
			}
			fis.close();
		}catch (FileNotFoundException e) { // if no file the server error 404
			response = response.replace("200", "404");
		}catch (Exception e) { //if other error the 500
			response = response.replace("200", "500");
		}
	}
}



