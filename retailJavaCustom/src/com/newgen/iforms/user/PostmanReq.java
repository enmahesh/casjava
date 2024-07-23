
package com.newgen.iforms.user;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

/**
 *
 * @author Rabin
 */
public class PostmanReq {

    public void Request() throws MalformedURLException, IOException{

//            HttpClient client = HttpClient.newBuilder()
//                .followRedirects(HttpClient.Redirect.NORMAL)
//                .build();
//
//            HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("https://safariexpress240.faulukenya.com:9453/FauluCreditWorkflow/services"))
//                .POST(BodyPublishers.ofString(" <soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:faul=\"http://temenos.com/FauluCreditWorkflow\">\n <soapenv:Header/> \n <soapenv:Body> \n\n <faul:ProductCodes>\n     <WebRequestCommon>\n         <company>com</company>\n         <password>pas</password>\n         <userName>usr</userName>\n     </WebRequestCommon>\n     <FKLLOANPRODCODESType>\n         <enquiryInputCollection>\n             <columnName>col</columnName>\n             <criteriaValue>cri</criteriaValue>\n             <operand>ope</operand>\n         </enquiryInputCollection>\n     </FKLLOANPRODCODESType>\n </faul:ProductCodes>\n \n  </soapenv:Body>\n </soapenv:Envelope>\n"))
//                .setHeader("SOAPAction", "#POST")
//                .setHeader("Content-Type", "application/xml")
//                .build();
//
//            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//            return response;
            
            StringBuilder response = new StringBuilder();
            String output = "";
            String ApiUrl = "https://safariexpress240.faulukenya.com:9453/FauluCreditWorkflow/services";
            String finalPayload ="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:faul=\"http://temenos.com/FauluCreditWorkflow\">\n <soapenv:Header/> \n <soapenv:Body> \n\n <faul:ProductCodes>\n     <WebRequestCommon>\n         <company>com</company>\n         <password>pas</password>\n         <userName>usr</userName>\n     </WebRequestCommon>\n     <FKLLOANPRODCODESType>\n         <enquiryInputCollection>\n             <columnName>col</columnName>\n             <criteriaValue>cri</criteriaValue>\n             <operand>ope</operand>\n         </enquiryInputCollection>\n     </FKLLOANPRODCODESType>\n </faul:ProductCodes>\n \n  </soapenv:Body>\n </soapenv:Envelope>\n";
            URL url = new URL(ApiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/xml");
            conn.setRequestProperty("SOAPAction", "#POST");
            
            conn.setDoOutput(true);
            DataOutputStream out = new DataOutputStream(conn.getOutputStream());
            out.writeBytes(finalPayload);
            out.flush();
            out.close();
            
            if (conn.getResponseCode() == 200) {
                BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
                while ((output = br.readLine()) != null) {
                    response.append(output + "\n");
                }
                output = "SUCCESS##" + response;
                br.close();
            }else {
                System.out.println("inside !200");
                BufferedReader br = new BufferedReader(new InputStreamReader((conn.getErrorStream())));
                System.out.println("BR" + br);
                while ((output = br.readLine()) != null) {
                    System.out.println("inside while" + output + "#######" + response);
                    response.append(output + "\n");
                    System.out.println("inside while" + output + "#######" + response);
                }
                output = conn.getResponseCode()+"##" + response;
                br.close();
            }
    }
}
