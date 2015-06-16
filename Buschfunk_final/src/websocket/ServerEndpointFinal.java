package websocket;


	import javax.websocket.OnClose;
	import javax.websocket.OnError;
	import javax.websocket.OnMessage;
	import javax.websocket.OnOpen;
	import javax.websocket.server.ServerEndpoint;

	@ServerEndpoint("/serverendpointfinal")
	public class ServerEndpointFinal {
		@OnOpen
		public void handleOpen() {
			 System.out.println("client is now connected...");
		}
		@OnMessage
		public String handleMessage(String message) {
			
			System.out.println("receive from client: " + message);
			String replyMessage = "echo "+ message;
			System.out.println("send to client: " +replyMessage);
			
			String harrysliste = "[{\"id\": \"1\", \"name\": \"Gisela\", \"entfernung\": \"50\"},"
					+ "{\"id\": \"2\", \"name\": \"Elfriede\", \"entfernung\": \"100\"},"
					+ "{\"id\": \"3\", \"name\": \"Helga\", \"entfernung\": \"120\"},"                         
					+ "{\"id\": \"4\", \"name\": \"Olga\", \"entfernung\": \"150\"},"
					+ "{\"id\": \"5\", \"name\": \"Kunigunde\", \"entfernung\": \"267\"}]";
			
			
			return replyMessage + "\n" + harrysliste;
		}
		@OnClose
		public void handleClose() {
			System.out.println("client is now disconnected...");
		}
		@OnError
		public void handleError(Throwable t) {
			t.printStackTrace();
		}
	}
