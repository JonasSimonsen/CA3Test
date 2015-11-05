/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
//import entity.Currency;
import entity.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andreas
 */
public class JSONConverter {
    
    private static Gson gson = new GsonBuilder().setPrettyPrinting().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create();

    public static User getUserFromJson(String js) {
        return gson.fromJson(js, User.class);
    }
    
    public static String getJSONFromDouble(Double d) {
        JsonObject obj = new JsonObject();
        obj.addProperty("amount", d);
        return gson.toJson(obj);
    }
    
    public static String getJSONFromUserList(List<User> users) {
        List<JsonObject> personList = new ArrayList();
        for (int i = 0; i < users.size(); i++) {
            JsonObject obj = new JsonObject();
            String roles = "";
            for (String role : users.get(i).getRoles()) {
                roles = "" + role;
            }
           // obj.addProperty("id", users.get(i).getId());
            obj.addProperty("username", users.get(i).getUserName());
            obj.addProperty("password", users.get(i).getPassword());
            obj.addProperty("roles", roles);
            personList.add(obj);
        }
        return gson.toJson(personList);
    }
    
//    public static String getJSONFromCurrencyList(List<Currency> currencies) {
//        List<JsonObject> currencyList = new ArrayList();
//        for (int i = 0; i < currencies.size(); i++) {
//            JsonObject obj = new JsonObject();
//            obj.addProperty("id", currencies.get(i).getId());
//            obj.addProperty("code", currencies.get(i).getCode());
//            obj.addProperty("description", currencies.get(i).getDescription());
//            obj.addProperty("rate", currencies.get(i).getRate());
//            currencyList.add(obj);
//        }
//        return gson.toJson(currencyList);
//    }
}
