import java.util.ArrayList;


public class SampleData {
	//Create ArrayList for User, Message
	static ArrayList<User> users = new ArrayList<User>();
	static ArrayList<Message> messages = new ArrayList<Message>();
	//Insert sample data
	public SampleData(){
		users.add(new User("Tobias"));
		users.add(new User("Rafael"));
		users.add(new User("Mirco"));
		users.add(new User("Markus"));
		
		messages.add(new Message(users.get(0), "Hallo ich bin Tobias"));
		messages.add(new Message(users.get(0), "Ich bin sehr aktiv mein 2ter Post"));
		messages.add(new Message(users.get(1), "Das Forum ist langweilig"));
		messages.add(new Message(users.get(2), "Ich bin Mirco, ich bin neu hier"));
		messages.add(new Message(users.get(3), "Ich werde mich wieder ausloggen, das Soziale Netzwerk ist mir zu unbekannt"));	
		
	}
}
