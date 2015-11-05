/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import facades.CurrencyFacade;
import facades.UserFacade;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import util.JSONConverter;

/**
 * REST Web Service
 *
 * @author Andreas
 */
@Path("currency")
@RolesAllowed("User")
public class Currency {
    CurrencyFacade f = new CurrencyFacade();
    
    @GET
    @Path("dailyrates")
    public String getCurrencies() {
        
        return JSONConverter.getJSONFromCurrencyRates(f.getCurrencies());
    }
    
    @GET
    @Path("calculator/{amount}/{fromcurrency}/{tocurrency}")
    public String calculator(@PathParam("amount") Double amount, @PathParam("fromcurrency") String fromcurrency, @PathParam("tocurrency") String tocurrency) {
        return JSONConverter.getJSONFromDouble(f.calculateCurrencies(amount, fromcurrency, tocurrency));
    }
    
}

