package controllers;

import java.util.List;

import org.w3c.dom.Document;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import play.i18n.Messages;
import play.libs.Json;
import play.mvc.*;
import views.html.index;
import models.*;

public class Usuarios extends Controller {

    // Devuelve el URI para acceder al recurso creado
    public static String getURI(Long id){
    	return "http://" + request().host() + request().path() + "/" + id;
    }
    
	
	// Gestión de errores, devuelve Json de error con estructura estandar
	private static JsonNode errorJson(Integer code, String message) {
		ObjectNode node = Json.newObject();
		node.put("code", code);
		node.put("message", Messages.get(message));
		return node;
	}
	
	// Modifica cabecera indicando se devuelve respuesta con contenido XML
	private static Result okWithXML(Content content){
		response().setHeader(CONTENT_TYPE, "application/xml");
		return ok(content);
	}
	
	// Modifica cabecera indicando se devuelve respuesta con contenido Json
	private static Result okWithJson(Content content){
		response().setHeader(CONTENT_TYPE, "application/json");
		return ok(content);
	}	
	
	@Security.Authenticated(Secured.class)
	// Devolver página del listado de Usuarios
    public static Result readAll(Integer pagina) {
    	Result resultado = null;

    	List<Usuario> listadoPagina = Usuario.finderByPagina(pagina);								// Obtener lista con los usuarios de la página pasada como parámetro
    	if ((listadoPagina!=null) && (listadoPagina.size() != 0)) {															// Si se han encontrado los usuarios de la página preparar la respuesta
			if (request().accepts("application/json")) {											// Devolvemos respuesta como Json ya que es aceptada por el cliente
				resultado = okWithJson(views.txt.usuarios.render(listadoPagina));
			}
			else if (request().accepts("application/xml") || request().accepts("text/xml")) {		// Devolvemos respuesta como XML ya que es aceptada por el cliente
				resultado = okWithXML(views.xml.usuarios.render(listadoPagina));
			} else {																				// Devolvemos error con estructura ya que el cliente no acepta ni Json ni XML
				resultado = badRequest(errorJson(901, "formato_no_soportado"));
			}
    	} else {																					
    		resultado = notFound(errorJson(906, "recurso_no_encontrado"));							// No existen usuarios para la página se devuelve error 404
    	}
    	
    	return resultado;
    }
	
	@Security.Authenticated(Secured.class)    	
    // Devolver un usuario
    public static Result read(Long userId) {
    	Result resultado = null;
    	
    	Usuario usuarioEncontrado = Usuario.finder.byId(userId);									// Realizar la búsqueda por id
    								
    	if (usuarioEncontrado != null) {															// Si se ha encontrado el usuario se prepara la respuesta
			if (request().accepts("application/json")) {											// Devolvemos respuesta como Json ya que es aceptada por el cliente
				resultado = okWithJson(views.txt._usuario.render(usuarioEncontrado));
			}
			else if (request().accepts("application/xml") || request().accepts("text/xml")) {		// Devolvemos respuesta como XML ya que es aceptada por el cliente
				resultado = okWithXML(views.xml._usuario.render(usuarioEncontrado));
			} else {																				// Devolvemos error con estructura ya que el cliente no acepta ni Json ni XML
				resultado = badRequest(errorJson(901, "formato_no_soportado"));
			}
    	} else {																					
    		resultado = notFound(errorJson(906, "recurso_no_encontrado"));							// Si no se ha encontrado el usuario se devuelve error 404
    	}
    	
    	return resultado;
    }
    
    
    // Binding de los datos obtenidos del body al objeto Usuario
	private static Usuario getUsuarioFromBody() {
		Usuario nuevoUsuario = null;		

		if (request().getHeader("Content-Type").startsWith("application/json")) {					// Conten-type de la entrada es Json
			JsonNode input = request().body().asJson();
			if (input != null)  {
				nuevoUsuario = Usuario.CreateNewUserJSON(input);
			}
		}
		else if ((request().getHeader("Content-Type").startsWith("application/xml")) ||  (request().getHeader("Content-Type").startsWith("text/xml"))){
			Document input = request().body().asXml();												// Conten-type de la entrada es XML
			if (input != null)  {
				nuevoUsuario = Usuario.CreateNewUserXML(input);
			}		
		}
		else {
			nuevoUsuario = null;
		}
		
		return nuevoUsuario;
	}    
    	
	
    // Crear un nuevo usuario
    public static Result create() {
		Result resultado = null;
		
		Usuario usuarioCreado = getUsuarioFromBody();
		
		if (usuarioCreado != null) {
			List<String> errors = usuarioCreado.validateAndSave();
			if (errors.size() == 0) {																	// No existen errores de validación, creamos el usuario
				resultado = created();																	// Respuesta 201 Created - la acción POST fue correcta
				response().setHeader(LOCATION, getURI(usuarioCreado.id));								// Devolver la cabecera LOCATION donde se puede consultar el recurso creado
			}
			else {			
				resultado = badRequest(errorJson(902, errors.toString()));								// Existen errores de validación para crear el usuario devolver errores
			}			
		}
		else {
			resultado = badRequest(errorJson(901, "formato_no_soportado"));								// No se soporta el tipo de entrada obtenida
		}
		
		return resultado;
    }
    
    @Security.Authenticated(Secured.class)        
    // Eliminar un usuario
    public static Result delete(Long userId) {
    	Result resultado = null;
    	
    	Usuario usuarioBorrar = Usuario.finder.byId(userId);											// Realizar la búsqueda por id

    	if (usuarioBorrar != null) {																	// Se encuentra al usuario y se borra	

    		for(Lista listaABorrar : usuarioBorrar.myLists){
    			
    			listaABorrar.myUsers.remove(usuarioBorrar);												// La lista ya no pertenece al usuario
    			listaABorrar.save();
				
				if(listaABorrar.myUsers.size() == 0) {													// Si era el únio usuario de la lista se elimina la lista
					listaABorrar.delete();
				}

    		}  
    		usuarioBorrar.delete();
    		resultado = ok();
    	} else {
    		resultado = notFound(errorJson(906, "recurso_no_encontrado"));								// Si no se ha encontrado el usuario se devuelve error 404
    	}
    	
    	return resultado;
    }    
    
    @Security.Authenticated(Secured.class)    
    // Modificar los datos de un usuario    
    public static Result update(Long userId) {
    	Result resultado = null;
    	Usuario usuarioModificar = Usuario.finder.byId(userId);											// Realizar la búsqueda por id

		if (usuarioModificar != null) {		
			
			Usuario nuevosDatosUsuario = getUsuarioFromBody();
			
			if (nuevosDatosUsuario != null) {															// Obtener los nuevos datos del usuario y modificarlos		
				
				if (usuarioModificar.updateDataUser(nuevosDatosUsuario, usuarioModificar.email)) {
					usuarioModificar.save();
					resultado = ok();
				}
				else {
					resultado = status(NOT_MODIFIED);
				}				
			}
			else {			
				resultado = badRequest(errorJson(901, "formato_no_soportado"));							// No se soporta el tipo de entrada obtenida
			}			
		}
		else {
			resultado = notFound(errorJson(906, "recurso_no_encontrado"));								// Si no se ha encontrado el usuario se devuelve error 404
		}    	
    	
    	return resultado;
    }

}
