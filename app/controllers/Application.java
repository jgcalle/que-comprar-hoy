package controllers;

import org.w3c.dom.Document;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import play.i18n.Messages;
import play.libs.Json;
import play.mvc.*;
import models.*;


public class Application extends Controller {
  
	// Gestión de errores, devuelve Json de error con estructura estandar
	private static JsonNode errorJson(Integer code, String message) {
		ObjectNode node = Json.newObject();
		node.put("code", code);
		node.put("message", Messages.get(message));
		return node;
	}
	
	
    // Clase para representar objetos Login
    public static class Login {
        
        public String email;
        public String password;

    	//Constructor crear usuario a partir de propiedades primitivas
    	public Login(String email, String password) {
    		this.email = email;
    		this.password = password;
    	}	
    	
    	// Validador para que en los datos XML recibidos exista cada propiedad del login 
    	public static Login CreateNewLoginXML(Document input) {
    		Login newLogin = null;

    		if ((input.getElementsByTagName("email").item(0) != null ) && (input.getElementsByTagName("password").item(0) != null )) {
    			String nuevo_email = input.getElementsByTagName("email").item(0).getTextContent();
    			String nuevo_password = input.getElementsByTagName("password").item(0).getTextContent();	
    			
    			newLogin = new Login(nuevo_email,nuevo_password);
    		}
    		return newLogin;
    	}
    	
    	// Validador para que en los datos Json recibidos exista cada propiedad del login 
    	public static Login CreateNewLoginJSON(JsonNode input) {
    		Login newLogin = null;

    		if ((input.get("email") != null ) && (input.get("password") != null )) {
    			String nuevo_email = input.get("email").asText();
    			String nuevo_password = input.get("password").asText();	

    			newLogin = new Login(nuevo_email,nuevo_password);
    		}
    		return newLogin;
    	}	
    	
    	
    	// La validación es correcta si existe un usuario con el email y password enviados
        public String validate() {
            if(Usuario.authenticate(email, password) == null) {
                return "login_no_valido";
            }
            return null;
        }
        
    }

    // Realiza el bidding de los datos obtenidos del body al objeto Login
	private static Login getLoginFromBody() {
		Login nuevoLogin = null;		
	
		if (request().getHeader("Content-Type").startsWith("application/json")) {					// Conten-type de la entrada es Json
			JsonNode input = request().body().asJson();
			if (input != null)  {
				nuevoLogin = Login.CreateNewLoginJSON(input);
			}
		}
		else if ((request().getHeader("Content-Type").startsWith("application/xml")) ||  (request().getHeader("Content-Type").startsWith("text/xml"))){
			Document input = request().body().asXml();												// Conten-type de la entrada es XML
			if (input != null)  {
				nuevoLogin = Login.CreateNewLoginXML(input);
			}
		}
		else {
			nuevoLogin = null;
		}
		
		return nuevoLogin;
	}    

    
    // Login
    public static Result login() {
		Result resultado = null;
		String validacion = null;
		
		Login loginCreado = getLoginFromBody();																// Recuperamos los datos del login en un objeto Login
		
		if (loginCreado != null) {																			// Si se ha creado el objeto Login
			validacion = loginCreado.validate();															// Pasamos la validación al objeto Login creado
			if(validacion == null){
				session("email", loginCreado.email);														// La validación es correcta, almacenamos variable de sesión
				resultado = ok();
			} else {
				resultado = unauthorized(errorJson(905, validacion));										// No es correcto el login	
			}
		} else {
			resultado = badRequest(errorJson(901, "formato_no_soportado"));									// No se soporta el tipo de entrada obtenida
		}
		
		return resultado;
		
    }


    // Logout
    public static Result logout() {
        session().clear();
        return ok();
    }

}