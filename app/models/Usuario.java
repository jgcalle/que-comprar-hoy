package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.ConstraintViolation;

import org.w3c.dom.Document;

import com.fasterxml.jackson.databind.JsonNode;

import play.data.validation.Constraints.Required;
import play.data.validation.Validation;
import play.data.format.Formats.NonEmpty;
import play.db.ebean.Model;
import play.i18n.Messages;

@Entity
public class Usuario extends Model {

	@Id
	public Long id;
	
	@Required
	public String nickName;
	
	@Required
	@NonEmpty
	public String email;
	
	@Required
	public String password;
	
	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
	public List<Lista> myLists = new ArrayList<Lista>();
	
	public static final int USERS_BY_PAGE = 10;
	
	// Buscador de Usuarios
	public static Finder<Long, Usuario> finder = new Finder<Long, Usuario>(Long.class, Usuario.class);
	
	//Constructor usuario a partir de propiedades primitivas
	public Usuario(String nickname, String email, String password) {
		super();
		this.nickName = nickname;
		this.email = email;
		this.password = password;
	}	
	
	// Validador para que en los datos XML recibidos exista cada propiedad del usuario 
	public static Usuario CreateNewUserXML(Document input) {
		Usuario newUsuario = null;

		if ((input.getElementsByTagName("nickname").item(0) != null ) && (input.getElementsByTagName("email").item(0) != null ) && (input.getElementsByTagName("password").item(0) != null )) {
			String nuevo_nickname = input.getElementsByTagName("nickname").item(0).getTextContent();
			String nuevo_email = input.getElementsByTagName("email").item(0).getTextContent();
			String nuevo_password = input.getElementsByTagName("password").item(0).getTextContent();	
			
			newUsuario = new Usuario(nuevo_nickname,nuevo_email,nuevo_password);
		}
		return newUsuario;
	}
	
	// Validador para que en los datos Json recibidos exista cada propiedad del usuario 
	public static Usuario CreateNewUserJSON(JsonNode input) {
		Usuario newUsuario = null;

		if ((input.get("nickname") != null ) && (input.get("email") != null ) && (input.get("password") != null )) {
			String nuevo_nickname = input.get("nickname").asText();
			String nuevo_email = input.get("email").asText();
			String nuevo_password = input.get("password").asText();	

			newUsuario = new Usuario(nuevo_nickname,nuevo_email,nuevo_password);
		}
		return newUsuario;
	}	
	
	// Devuelve un subconjunto de todos los usuarios definido por el parametro página
	public static List<Usuario> finderByPagina(Integer pag){
		return finder.setMaxRows(USERS_BY_PAGE).setFirstRow((USERS_BY_PAGE*pag)).findList();
	}
	
	
	// Devuelve un usuario por email
    public static Usuario finderByEmail(String email) {
        return finder.where().eq("email", email).findUnique();
    }
    	
	
	// Validación de las propiedades del objeto Usuario
	public List<String> directValidate() {
		Set<ConstraintViolation<Usuario>> violations = Validation.getValidator().validate(this);
		List<String> errors = new ArrayList<String>();
		for(ConstraintViolation<Usuario> cv : violations) {
			errors.add(cv.getMessage());
		}
		
		String violation = this.validate();
		if (violation != null) {
			errors.add(violation);
		}
		
		if (Usuario.finderByEmail(this.email) != null) {
			errors.add(Messages.get("email_duplicado"));	// Email duplicado
		}
		
		return errors;
	}
	
	public String validate() {
		return null;
	}
	
	// Validación y Grabación del Usuario
	public List<String> validateAndSave() {
		List<String> errors = directValidate();
		if (errors.size() == 0) {
			this.save();
		}
		return errors;
	}
	
	// Modificar los datos del Usuario
	public boolean updateDataUser(Usuario datosModificar, String actualEmail){
		boolean datosModificados = false;
		
		if((datosModificar.nickName != null) && (!datosModificar.nickName.equals(""))){
			this.nickName = datosModificar.nickName;
			datosModificados = true;
		}

		if((datosModificar.email != null) && (!datosModificar.email.equals("")) && ((Usuario.finderByEmail(datosModificar.email) == null) || (Usuario.finderByEmail(datosModificar.email).email.equals(actualEmail)))){		
			this.email = datosModificar.email;
			datosModificados = true;
		}		

		if((datosModificar.password != null) && (!datosModificar.password.equals(""))){
			this.password = datosModificar.password;
			datosModificados = true;
		}		
		
		return datosModificados;
	}	
	
 
	// Autenticación del Usuario
    public static Usuario authenticate(String email, String password) {
        return finder.where()
            .eq("email", email)
            .eq("password", password)
            .findUnique();
    }	 
    
}
