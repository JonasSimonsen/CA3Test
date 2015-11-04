/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entity.User;
import facades.UserFacade;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import security.PasswordHash;
/**
 *
 * @author jonassimonsen
 */
@Path("saveUser")
public class SaveUser
{
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveUser(String user) throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        JsonObject json = new JsonParser().parse(user).getAsJsonObject();
        User saveUser = new User();
        saveUser.setUserName(json.get("username").getAsString());
        //Saves a hashed version of the password in db
        saveUser.setPassword(PasswordHash.createHash(json.get("password").getAsString()));
        saveUser.AddRole("User");
        UserFacade uf = new UserFacade();
        uf.saveUser(saveUser);
        JsonObject responseJson = new JsonObject();
        responseJson.addProperty("username", saveUser.getUserName());
        return Response.ok(new Gson().toJson(responseJson)).build();
    }

}
