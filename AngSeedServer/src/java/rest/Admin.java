package rest;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import facades.UserFacade;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import entity.User;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.PathParam;
import util.JSONConverter;

@Path("demoadmin")
@RolesAllowed("Admin")
public class Admin {
    
    UserFacade uf = new UserFacade();
    
  
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public String getSomething(){
    String now = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss").format(new Date());
    return "{\"message\" : \"This message was delivered via a REST call accesible by only authenticated ADMINS\",\n"
            +"\"serverTime\": \""+now +"\"}"; 
  }
  
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("users")
    public String getUsers(){
    String json = JSONConverter.getJSONFromUserList(uf.getAllUsers());
        return json;
    }
    
        @DELETE
    @Path("delete/{username}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteUser(@PathParam("username") String username) {
        uf.deleteUser(username);
    }
    

  
 
}
