package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.ConstraintViolation;

import org.w3c.dom.Document;

import com.fasterxml.jackson.databind.JsonNode;

import play.data.validation.Constraints.*;
import play.data.validation.Validation;
import play.db.ebean.Model;

@Entity
public class Articulo extends Model {

	@Id 
	public Long id;
	
	@Required
	public String name;
	
	@Min(0)
	@Max(100)
	public Integer amount;
	
	@ManyToOne
	public Lista myList;

	// Buscador de Articulos
	public static Finder<Long, Articulo> finder = new Finder<Long, Articulo>(Long.class, Articulo.class);
	
	//Constructor artículo a partir de propiedades primitivas
	public Articulo(String name, Integer amount) {
		super();
		this.name = name;
		this.amount = amount;
	}		
	
	// Validador para que en los datos XML recibidos exista cada propiedad del articulo 
	public static Articulo CreateNewItemXML(Document input) {
		Articulo newItem = null;

		if ((input.getElementsByTagName("name").item(0) != null ) && (input.getElementsByTagName("amount").item(0) != null )) {
			String nuevo_name = input.getElementsByTagName("name").item(0).getTextContent();
			Integer nuevo_amount = Integer.parseInt(input.getElementsByTagName("amount").item(0).getTextContent());	
			
			newItem = new Articulo(nuevo_name,nuevo_amount);
		}
		return newItem;
	}
	
	// Validador para que en los datos Json recibidos exista cada propiedad del articulo 
	public static Articulo CreateNewItemJSON(JsonNode input) {
		Articulo newItem = null;

		if ((input.get("name") != null ) && (input.get("amount") != null )) {
			String nuevo_name = input.get("name").asText();
			Integer nuevo_amount = input.get("amount").asInt();	
			
			newItem = new Articulo(nuevo_name,nuevo_amount);
		}
		return newItem;
	}	
	
	
	
	// Validación de las propiedades del objeto Artículo
	public List<String> directValidate() {
		Set<ConstraintViolation<Articulo>> violations = Validation.getValidator().validate(this);
		List<String> errors = new ArrayList<String>();
		for(ConstraintViolation<Articulo> cv : violations) {
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
	
	// Grabación de un artículo
	public List<String> validateAndSave(Lista listaIncluye) {
		List<String> errors = directValidate();
		if (errors.size() == 0) {
			this.myList = listaIncluye;
			this.save();
		}
		return errors;
	}	
	
}
