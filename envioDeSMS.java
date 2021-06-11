/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package envio.sms;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
public class envioDeSMS {

public void envioSMS(String num){
				 
//Se fija el tiempo máximo de espera para conectar con el servidor (5000)
//Se fija el tiempo máximo de espera de la respuesta del servidor (60000)
RequestConfig config = RequestConfig.custom()
 .setConnectTimeout(5000)
 .setSocketTimeout(60000)
 .build();
	
//Se inicia el objeto HTTP
HttpClientBuilder builder = HttpClientBuilder.create();
builder.setDefaultRequestConfig(config);
CloseableHttpClient httpClient = builder.build();
	
//Se fija la URL sobre la que enviar la petición POST
HttpPost post = new HttpPost("http://www.altiria.net/api/http");
	
//Se crea la lista de parámetros a enviar en la petición POST
List<NameValuePair> parametersList = new ArrayList <NameValuePair>();
//XX, YY y ZZ se corresponden con los valores de identificación del
//usuario en el sistema.
parametersList.add(new BasicNameValuePair("cmd", "sendsms"));
//domainId solo es necesario si el login no es un email
//parametersList.add(new BasicNameValuePair("domainId", "XX"));
parametersList.add(new BasicNameValuePair("login", "afabiantriana@ucundinamarca.edu.co"));
parametersList.add(new BasicNameValuePair("passwd", "sbt4nm3f"));
parametersList.add(new BasicNameValuePair("dest", "57"+num+""));
String s="ssds funciona";
parametersList.add(new BasicNameValuePair("msg", ""));
//No es posible utilizar el remitente en América pero sí en España y Europa
//Descomentar la línea solo si se cuenta con un remitente autorizado por Altiria
//parametersList.add(new BasicNameValuePair("senderId", "remitente"));
	
try {
 //Se fija la codificacion de caracteres de la peticion POST
 post.setEntity(new UrlEncodedFormEntity(parametersList,"UTF-8"));
}
catch(Exception e) {
 System.out.println("ERROR: codificación de caracteres no soportada");
}
	
CloseableHttpResponse response = null;
	
try {
 System.out.println("Enviando petición");
 //Se envía la petición
 response = httpClient.execute(post);
 //Se consigue la respuesta
 String resp = EntityUtils.toString(response.getEntity());
	    
 //Error en la respuesta del servidor
 if (response.getStatusLine().getStatusCode()!=200){
   System.out.println("ERROR: Código de error HTTP:  " + response.getStatusLine().getStatusCode());
   System.out.println("Compruebe que ha configurado correctamente la direccion/url ");
   System.out.println("suministrada por Altiria");
   return;
 }else {
   //Se procesa la respuesta capturada en la cadena 'response'
   if (resp.startsWith("ERROR")){
    System.out.println(resp);
    System.out.println("Código de error de Altiria. Compruebe las especificaciones");
   } else
    System.out.println(resp);
   }
 }
 catch (Exception e) {
   System.out.println("Excepción");
   e.printStackTrace();
   return;
 }
 finally {
    //En cualquier caso se cierra la conexión
    post.releaseConnection();
    if(response!=null) {
     try {
       response.close();
     }
     catch(Exception e) {
       System.out.println("ERROR cerrando recursos");
     }
    }
 }
}
}


