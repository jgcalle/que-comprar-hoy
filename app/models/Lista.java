package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.ConstraintViolation;

import org.w3c.dom.Document;

import com.avaje.ebean.annotation.CreatedTimestamp;
import com.fasterxml.jackson.databind.JsonNode;

import play.data.validation.Constraints.Required;
import play.data.validation.Validation;
import play.db.ebean.Model;

@Entity
public class Lista extends Model {
	
	@Id
	public Long id;
	
	@Required
	public String name;
	
	@CreatedTimestamp
	public Date createdAt;
	
	@ManyToMany(mappedBy = "myLists")
	public Set<Usuario> myUsers;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="myList")
	public List<Articulo> myItems;

	public static final int LISTS_BY_PAGE = 10;
	
	// Buscador de Listas
	public static Finder<Long, Lista> finder = new Finder<Long, Lista>(Long.class, Lista.class);
	
	//Constructor lista a partir de propiedades primitivas
	public Lista(String name) {
		super();
		this.name = name;
	}		
	
	// Validador para que en los datos XML recibidos exista cada propiedad de la lista 
	public static Lista CreateNewListXML(Document input) {
		Lista newList = null;

		if (input.getElementsByTagName("name").item(0) != null) {
			newList = new Lista(input.getElementsByTagName("name").item(0).getTextContent());
		}
		return newList;
	}
	
	// Validador para que en los datos Json recibidos exista cada propiedad de la lista 
	public static Lista CreateNewListJSON(JsonNode input) {
		Lista newList = null;

		if (input.get("name") != null ) {
			newList = new Lista(input.get("name").asText());
		}
		return newList;
	}		
	
	
	// Devuelve un subconjunto de listas filtrado por nombre de la lista y paginado
	public static List<Lista> finderByName(Long userId, String listName, Integer pag){

		List<Lista> listadoTotal = finder.where()
					.eq("myUsers.id",userId)
					.like("name","%"+listName+"%")
					.setMaxRows(LISTS_BY_PAGE)
					.setFirstRow((LISTS_BY_PAGE*pag))
					.findList();
		
		return listadoTotal;
	}	
	
	// Validación de las propiedades del objeto Lista
	public List<String> directValidate() {
		Set<ConstraintViolation<Lista>> violations = Validation.getValidator().validate(this);
		List<String> errors = new ArrayList<String>();
		for(ConstraintViolation<Lista> cv : violations) {
			errors.add(cv.getMessage());
		}
		String violation = this.validate();
		if (violation != null) {
			errors.add(violation);
		}
		return errors;
	}
	
	public String validate() {
		return null;
	}
	
	// Grabación de la lista
	public List<String> validateAndSave(Usuario usuarioAutor) {
		List<String> errors = directValidate();
		if (errors.size() == 0) {
			this.myUsers.add(usuarioAutor);
			this.save();
		}
		return errors;
	}
	
	// Borrado de un elemento de la lista
	public void deleteItem(int pos) {
		Articulo articuloABorrar = this.myItems.get(pos);
		articuloABorrar.delete();
		articuloABorrar.myList = null;
		this.myItems.remove(pos);
	}	
	
    
	// Comprueba si un usuario es propietario de la lista
    public static boolean isOwner(Long list, String user) {
        return finder.where()
            .eq("myUsers.email", user)
            .eq("id", list)
            .findRowCount() > 0;
    }	
}
