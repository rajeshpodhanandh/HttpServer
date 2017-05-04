
public class HttpRequest {

	//we need only 1st line and 1st part(i.e request GET)
	String filename;

	//we have to create an acceptor
	public HttpRequest(String request) {

		String lines[] = request.split("\n");

		//this to separate first line items by space " "
		System.out.println(lines);
		lines =lines[0].split(" ");
		filename = lines[1];

	}

}
