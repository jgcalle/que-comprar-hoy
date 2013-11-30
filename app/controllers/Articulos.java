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

@Security.Authenticated(Secured.class)
public class Articulos extends Controller {

    // Devuelve el URI para acceder al recurso creado
    public static String getURI(){
    	String subPath = request().path().substring(0, request().path().indexOf("/articulos"));
    	return "http://" + request().host() + subPath;
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
	
	
    // Binding de los datos obtenidos del body al objeto Articulo
	private static Articulo getArticuloFromBody() {
		Articulo nuevoArticulo = null;		
	
		if (request().getHeader("Content-Type").startsWith("application/json")) {					// Conten-type de la entrada es Json
			JsonNode input = request().body().asJson();
			if (input != null)  {
				nuevoArticulo = Articulo.CreateNewItemJSON(input);
			}	
		}
		
		else if ((request().getHeader("Content-Type").startsWith("application/xml")) ||  (request().getHeader("Content-Type").startsWith("text/xml"))){
			Document input = request().body().asXml();												// Conten-type de la entrada es XML
			if (input != null)  {
				nuevoArticulo = Articulo.CreateNewItemXML(input);
			}	
		}
		else {
			nuevoArticulo = null;
		}
		
		return nuevoArticulo;
	}        
    
    // Añadir artículos a una lista
    public static Result create(Long listId) {
		Result resultado = null;
		
		Lista listaEncontrada = Lista.finder.byId(listId);

		if (listaEncontrada != null) {																			// Existe la lista para añadir artículos	
		
			if(Secured.isOwnerOf(listId)){																		// La lista pertenece al usuario que desea añadir artículos
			
				Articulo articuloCreado = getArticuloFromBody();
				
				if (articuloCreado != null) {
					List<String> errors = articuloCreado.validateAndSave(listaEncontrada);
					if (errors.size() == 0) {																	// No existen errores de validación, creamos la lista
						resultado = created();																	// Respuesta 201 Created - la acción POST fue correcta
						response().setHeader(LOCATION, getURI());												// Devolver la cabecera LOCATION donde se puede consultar el recurso creado
					}
					else {			
						resultado = badRequest(errorJson(902, errors.toString()));								// Existen errores de validación para crear la lista devolver errores
					}			
				}
				else {
					resultado = badRequest(errorJson(901, "formato_no_soportado"));								// No se soporta el tipo de entrada obtenida
				}
			} else {
				resultado = forbidden(errorJson(903, "no_tiene_permiso"));										// El usuario no es propietario de la lista, luego no tiene permisos				
			}	
    	} else {
			resultado = notFound(errorJson(906, "recurso_no_encontrado"));										// Si no se ha encontrado la lista se devuelve error 404
    	}
		
		return resultado;
    }   
    
    
    // Eliminar un articulo de una lista
    public static Result delete(Long itemId) {
		Result resultado = null;
		
		Articulo articuloEncontrado = Articulo.finder.byId(itemId);

		if (articuloEncontrado != null) {																		// Existe el artículo	
			
			Lista listaEncontrada = articuloEncontrado.myList;
			
			if(Secured.isOwnerOf(listaEncontrada.id)){															// La lista pertenece al usuario
					
				listaEncontrada.deleteItem(listaEncontrada.myItems.indexOf(articuloEncontrado));				// Borramos el artículo
				listaEncontrada.save();
				resultado = ok();
					
			} else {
				resultado = forbidden(errorJson(903, "no_tiene_permiso"));										// El usuario no es propietario de la lista, luego no tiene permisos				
			}	
    	} else {
			resultado = notFound(errorJson(906, "recurso_no_encontrado"));										// Artículo no encontrado
    	}
		
		return resultado;
    }  	     
    
}
