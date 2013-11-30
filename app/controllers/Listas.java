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
public class Listas extends Controller {

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
	
	
    //Método controlador para añadir un usuario a una lista
    public static Result share(Long listId, Long newUserId) {
		Result resultado = null;
		
		Lista listaEncontrada = Lista.finder.byId(listId);
		Usuario nuevoUsuarioEncontrado = Usuario.finder.byId(newUserId);
		
		if ((listaEncontrada != null) && (nuevoUsuarioEncontrado != null)) {									// Existe la lista y el nuevo usuario	
		
			if(Secured.isOwnerOf(listId)){																		// La lista pertenece al usuario que desea compartirla

				listaEncontrada.myUsers.add(nuevoUsuarioEncontrado);											// Se añade el nuevo usuario como propietario de la lista
				listaEncontrada.save();
				resultado = ok();	

			} else {
				resultado = forbidden(errorJson(903, "no_tiene_permiso"));										// El usuario no es propietario de la lista, luego no tiene permisos				
			}	
    	} else {
			resultado = notFound(errorJson(906, "recurso_no_encontrado"));										// Si no se ha encontrado la lista o nuevo usuario se devuelve error 404
    	}
		
		return resultado;
    }    
	
    
    // Eliminar un usuario de una lista
    public static Result shareNot(Long listId, Long userId) {
		Result resultado = null;
		
		Lista listaEncontrada = Lista.finder.byId(listId);
		Usuario nuevoUsuarioEncontrado = Usuario.finder.byId(userId);
		
		if ((listaEncontrada != null) && (nuevoUsuarioEncontrado != null)) {									// Existe la lista y el usuario a eliminar
		
			if(Secured.isOwnerOf(listId)){																		// La lista pertenece al usuario que desea no compartirla

				if(listaEncontrada.myUsers.size() > 1) {
					listaEncontrada.myUsers.remove(nuevoUsuarioEncontrado);										// Se elimina al usuario como propietario de la lista
					listaEncontrada.save();
					resultado = ok();
				} else {
					resultado = forbidden(errorJson(904, "unico_propietario"));									// No se puede eliminar el usuario de la lista ya que es el único
				}

			} else {
				resultado = forbidden(errorJson(903, "no_tiene_permiso"));										// El usuario no es propietario de la lista, luego no tiene permisos				
			}	
    	} else {
			resultado = notFound(errorJson(906, "recurso_no_encontrado"));										// Si no se ha encontrado la lista o nuevo usuario se devuelve error 404
    	}
		
		return resultado;
    }  	
	
	
    // Devolver una lista
    public static Result read(Long listId) {
    	Result resultado = null;
    	
    	Lista listaEncontrada = Lista.finder.byId(listId);

    	if (listaEncontrada!=null) {																	// Se ha encontrado la lista a consultar
    		
    		if(Secured.isOwnerOf(listId)){																// La lista solicitada pertenece al usuario
    			
				if (request().accepts("application/json")) {											// Devolvemos respuesta como Json ya que es aceptada por el cliente	
					resultado = okWithJson(views.txt._lista.render(listaEncontrada));
				}
				else if (request().accepts("application/xml") || request().accepts("text/xml")) {		// Devolvemos respuesta como XML ya que es aceptada por el cliente
					resultado = okWithXML(views.xml._lista.render(listaEncontrada));
				} else {																				// Devolvemos error con estructura ya que el cliente no acepta ni Json ni XML
					resultado = badRequest(errorJson(901, "formato_no_soportado"));
				}
				
    		} else {
    			resultado = forbidden(errorJson(903, "no_tiene_permiso"));								// El usuario no es propietario de la lista, luego no tiene permisos    			
    		}
    	
    	} else {																						
    		resultado = notFound(errorJson(906, "recurso_no_encontrado"));								// No existe lista para el usuario se devuelve error 404
    	}
    	
    	return resultado;
    	
    }	
    
	
    // Devolver conjunto de listas filtrado por nombre de la lista
    public static Result readAll(String nameList, Integer pag) {
    	Result resultado = null;

    	Long userId = Usuario.finderByEmail(request().username()).id;

    	List<Lista> listadoListas = Lista.finderByName(userId, nameList, pag);						// Obtener listado de las listas del usuario filtrado por nombre
    	
    	if ((listadoListas!=null) && (listadoListas.size() != 0)) {									// Si se han encontrado listas preparar la respuesta
			if (request().accepts("application/json")) {											// Devolvemos respuesta como Json ya que es aceptada por el cliente	
				resultado = okWithJson(views.txt.listas.render(listadoListas));
			}
			else if (request().accepts("application/xml") || request().accepts("text/xml")) {		// Devolvemos respuesta como XML ya que es aceptada por el cliente
				resultado = okWithXML(views.xml.listas.render(listadoListas));
			} else {																				// Devolvemos error con estructura ya que el cliente no acepta ni Json ni XML
				resultado = badRequest(errorJson(901, "formato_no_soportado"));
			}
    	} else {																					
    		resultado = notFound(errorJson(906, "recurso_no_encontrado"));							// No existen listas para el usuario por el criterio de filtrado se devuelve error 404
    	}
    	
    	return resultado;
    	
    }	
	
    
    // Binding de los datos obtenidos del body al objeto Lista
	private static Lista getListaFromBody() {
		Lista nuevaLista = null;		
		if (request().getHeader("Content-Type").startsWith("application/json")) {					// Conten-type de la entrada es Json
			JsonNode input = request().body().asJson();
			if (input != null)  {
				nuevaLista = Lista.CreateNewListJSON(input);
			}			
		}
		
		else if ((request().getHeader("Content-Type").startsWith("application/xml")) ||  (request().getHeader("Content-Type").startsWith("text/xml"))){
			Document input = request().body().asXml();												// Conten-type de la entrada es XML
			if (input != null)  {
				nuevaLista = Lista.CreateNewListXML(input);
			}		
		}
		else {
			nuevaLista = null;
		}
		
		return nuevaLista;
	}    	
    

	// Crear una nueva lista
    public static Result create() {
		Result resultado = null;
		
		Usuario usuarioAutor = Usuario.finderByEmail(request().username());
		
		if (usuarioAutor != null) {		
			Lista listaCreada = getListaFromBody();
			
			if (listaCreada != null) {
				List<String> errors = listaCreada.validateAndSave(usuarioAutor);
				if (errors.size() == 0) {																	// No existen errores de validación, creamos la lista
					resultado = created();																	// Respuesta 201 Created - la acción POST fue correcta
					response().setHeader(LOCATION, getURI(listaCreada.id));									// Devolver la cabecera LOCATION donde se puede consultar el recurso creado					
				}
				else {			
					resultado = badRequest(errorJson(902, errors.toString()));								// Existen errores de validación para crear la lista devolver errores
				}			
			}
			else {
				resultado = badRequest(errorJson(901, "formato_no_soportado"));								// No se soporta el tipo de entrada obtenida
			}
    	} else {
			resultado = notFound(errorJson(906, "recurso_no_encontrado"));									// Si no se ha encontrado el usuario se devuelve error 404
    	}
		return resultado;
    }

    
    // Eliminar una lista
    public static Result delete(Long listId) {
		Result resultado = null;
		
		Lista listaEncontrada = Lista.finder.byId(listId);
		
		if (listaEncontrada != null)  {																			// Existe la lista
		
			if(Secured.isOwnerOf(listId)){																		// La lista pertenece al usuario que desea eliminarla
				
				listaEncontrada.myUsers.remove(Usuario.finderByEmail(request().username()));					// La lista ya no pertenece al usuario
				listaEncontrada.save();
				
				if(listaEncontrada.myUsers.size() == 0) {														// Si era el único usuario de la lista se elimina la lista
					listaEncontrada.delete();
				}

				resultado = ok();

			} else {
				resultado = forbidden(errorJson(903, "no_tiene_permiso"));										// El usuario no es propietario de la lista, luego no tiene permisos				
			}	
    	} else {
			resultado = notFound(errorJson(906, "recurso_no_encontrado"));										// Si no se ha encontrado la lista se devuelve error 404
    	}
		
		return resultado;
    }     
    
}
