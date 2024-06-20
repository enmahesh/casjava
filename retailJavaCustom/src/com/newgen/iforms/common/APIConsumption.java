package com.newgen.iforms.common;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Properties;

public class APIConsumption {

    public static final String SPECIAL_STRING = "\",\r\n";

    public String consumeAPI(String request, String process) {
        
       LogMessages.statusLog.info("Entered consumeAPI");
        
        
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.mmm");
        Properties properties = new Properties();
        StringBuilder response = new StringBuilder();
        String output = "";
        try {
                InputStream input = new FileInputStream("/newgen/jboss-eap-7.4/bin" + "/FAULUConfig/Integration.properties");
        
            properties.load(input);
            
            String fauluURL = properties.getProperty("fauluURL");
            
            //Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            //String finalTimestamp = sdf.format(timestamp);
            //String data = Base64.getEncoder().encodeToString(request.getBytes());
            LogMessages.statusLog.info(fauluURL);
           
            HttpURLConnection conn = getHttpURLConnection(fauluURL);

            DataOutputStream out = new DataOutputStream(conn.getOutputStream());
            out.writeBytes(request);
            out.flush();
            out.close();
            LogMessages.statusLog.info("Inside APIConsumption=" + conn.getResponseCode());

            if (conn.getResponseCode() == 200) {
                LogMessages.statusLog.info("inside 200");
                BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
                while ((output = br.readLine()) != null) {
                    response.append(output + "\n");
                }
                output = "SUCCESS##" + response;
                br.close();
            } else {
                LogMessages.statusLog.info("inside !200");
                BufferedReader br = new BufferedReader(new InputStreamReader((conn.getErrorStream())));
                while ((output = br.readLine()) != null) {
                    response.append(output + "\n");
                }
                output = conn.getResponseCode() + "##" + response;
                br.close();
            }
            LogMessages.statusLog.info("Response=" + response);
        } catch (IOException e) {
            LogMessages.errorLog.info("Exception inside APIConsumption=" + e);
        }
        return output;
    }

    private HttpURLConnection getHttpURLConnection(String requestUrl) throws IOException {
        URL url = new URL(requestUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("SOAPAction", "#POST");
        conn.setDoOutput(true);
        return conn;
    }

   
}