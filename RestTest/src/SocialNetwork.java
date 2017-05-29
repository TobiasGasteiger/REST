/**
 * Created by Tobias on 28.05.2017.
 */

import javax.ws.rs.*;

// Find site under http://localhost/SocialNetwork
@Path("SocialNetwork")
public class SocialNetwork {
	
    @GET
    @Produces("text/plain")
    public String welcome(){
    	
       String welcomeText =  "This is a simple application to demonstrate the power of REST \n\n";
       welcomeText += "GET USERS: http://localhost/SocialNetwork/getUser/ \n";
       welcomeText += "GET MESSAGES: http://localhost/SocialNetwork/getMessages \n";
       welcomeText += "GET MESSAGES FROM USER: http://localhost/SocialNetwork/getMessages/{username} \n";
       welcomeText += "POST NEW USER: http://localhost/SocialNetwork/createUser/{username} \n";
       welcomeText += "POST NEW MESSAGE: http://localhost/SocialNetwork/createMessage/user/{username}/message/{text} \n";
       
       return welcomeText;
    }
    
    //get all usernames from the social network
    @GET
    @Path("getUser")
    @Produces("application/json")
    public String getUser(){
        String user = "[ ";
        for(int i = 0; i < SampleData.users.size(); i++){
        	user += "\"" + SampleData.users.get(i).username + "\"," ;
        }
        user = user.substring(0, user.length()-1);
        user += " ]";
        return user;
    }
    
    //get all messages from a user, if the user doesn't exist no entries are shown
    @GET
    @Path("getMessages/{username}")
    @Produces("text/plain")
    public String getMessageUser(@PathParam("username") String username){
        String message = "Messages from " + username +":\n\n";
        for(int i = 0; i < SampleData.messages.size(); i++){
        	if(SampleData.messages.get(i).getUser().username.equals(username)){
            	message += SampleData.messages.get(i).getMessage();
            	message += "\n";
        	}
        }
		return message;
    }

    //get all messages
    @GET
    @Path("getMessages")
    @Produces("text/plain")
    public String getMessages()
    {
    	String message = "";
        for(int i = 0; i < SampleData.messages.size(); i++){
        	message += SampleData.messages.get(i).toString();
        	message += "\n";
        }
        return message;
    }
    
    //create a new user
    @GET
    @Path("createUser/{username}")
    public void createUser(@PathParam("username") String username) {
    	SampleData.users.add(new User(username));
    }
    
    //create a new message
    @GET
    @Path("createMessage/user/{username}/message/{text}")
    public void createMessage(@PathParam("username") String username, @PathParam("text") String text) {
    	SampleData.messages.add(new Message((new User(username)), text));
    }
}
