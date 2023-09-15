/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.rest;

/**
 *
 * @author ADMIN
 */
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Rest {
    
    private static ObjectMapper mapper = new ObjectMapper();
    
    private static JsonNode request(String method, String path, Object data) throws ProtocolException, IOException{
        try {
            String uri = "https://java6-76c8d-default-rtdb.asia-southeast1.firebasedatabase.app"+path+".json";
            URL url = new URL(uri);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(method);
            
            if(method.equalsIgnoreCase("POST") || method.equalsIgnoreCase("PUT")){
                conn.setDoOutput(true);
                mapper.writeValue(conn.getOutputStream(), data);
            }
            
            int responseCode = conn.getResponseCode();
            if(responseCode == 200)
                return mapper.readTree(conn.getInputStream());
            conn.disconnect();
            return null;
        } catch (MalformedURLException ex) {
            Logger.getLogger(Rest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void delete(String path) throws IOException{
        request("DELETE", path, null);
    }
    
    public static JsonNode post(String path, Object data) throws IOException{
        return request("POST", path, data);
    }
    
    public static JsonNode put(String path, Object data) throws IOException{
        return request("PUT", path, data);
    }
    
    public static JsonNode get(String path) throws IOException{
        return request("GET", path, null);
    }
}
