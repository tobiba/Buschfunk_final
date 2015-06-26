package websocket;


	import javax.websocket.OnClose;
	import javax.websocket.OnError;
	import javax.websocket.OnMessage;
	import javax.websocket.OnOpen;
	import javax.websocket.server.ServerEndpoint;

	@ServerEndpoint("/serverendpointfinal")
	public class ServerEndpointFinal {
		
		String username;
		String IP;
		String longi;
		String lati;
		String Fall;
		String[] parts = new String[5];
		String nachricht;
		
		
		@OnOpen
		public void handleOpen() {
			 System.out.println("client is now connected...");
		}
		@OnMessage
		public String handleMessage(String message) {
			
		parts = message.split("-");
		
		Fall = parts[0];

		
		if(Fall.equals("Chat")) {
			
			nachricht = parts[1];
			
			System.out.println("receive from client: " + nachricht);
			String replyMessage = "Chatnachricht lautet:  "+ nachricht;
			System.out.println("send to client: " + replyMessage);
			
			String harrysliste = "[{\"id\": \"1\", \"name\": \"Gisela\", \"entfernung\": \"50\"},"
					+ "{\"id\": \"2\", \"name\": \"Elfriede\", \"entfernung\": \"100\"},"
					+ "{\"id\": \"3\", \"name\": \"Helga\", \"entfernung\": \"120\"},"                         
					+ "{\"id\": \"4\", \"name\": \"Olga\", \"entfernung\": \"150\"},"
					+ "{\"id\": \"5\", \"name\": \"Kunigunde\", \"entfernung\": \"267\"}]";
			
			
			return replyMessage + "\n" + harrysliste;
		} 
		
		else if (Fall.equals("Anmelden")){
			
			username = parts[1];
			IP = parts[2];
			longi = parts[3];
			lati = parts[4];
			
		
			System.out.println("receive from client: " + message);
			String replyMessage = "Username: "+ username + ", IP: " + IP + ", Long: " + longi + ", Lat: " + lati + ".";
			System.out.println("send to client: " + replyMessage);
			
			return replyMessage;
		} 
			else {
				System.out.println("error -- receive from client: " + message);
				System.out.println(Fall + "--" + username + "--" + IP + "--" + longi + "--" + lati);
				return "Fehler"; 
			}
		}
		
//		public String handleMessage(String username, String IP, String latitude, String longitude){
//			this.username = username;
//			this.IP = IP;
//			this.lati = latitude;
//			this.longi = longitude;
//			
//			return username + " ist angemeldet.";
//		}
		
		@OnClose
		public void handleClose() {
			System.out.println("client is now disconnected...");
		}
		@OnError
		public void handleError(Throwable t) {
			t.printStackTrace();
		}
	}
