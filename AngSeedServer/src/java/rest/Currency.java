///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package rest;
//
//import facades.CurrencyFacade;
//import facades.UserFacade;
//import java.io.IOException;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.Scanner;
//import javax.annotation.security.RolesAllowed;
//import javax.ws.rs.core.Context;
//import javax.ws.rs.core.UriInfo;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.Consumes;
//import javax.ws.rs.PUT;
//import javax.ws.rs.Path;
//import javax.ws.rs.GET;
//import javax.ws.rs.POST;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//import util.JSONConverter;
//
///**
// * REST Web Service
// *
// * @author Andreas
// */
//@Path("currency")
//@RolesAllowed("user")
//public class Currency {
//
//    CurrencyFacade cc = new CurrencyFacade();
//
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("dailyrates")
//    public String getSomething() {
//        return JSONConverter.getJSONFromCurrencyList(cc.getCurrenciesFromDB());
//    }
//    
//    @POST
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("calculator/:amount/:fromcurrency/:tocurrency")
//    public String calculateRates(@PathParam("amount")double amount,@PathParam("option") String fromCur, @PathParam("searchText") String toCur) {
//        String json = JSONConverter.getJSONFromDouble(cc.convertCurrency(amount, fromCur, toCur));
//        return json;
//    }
//    
//}
