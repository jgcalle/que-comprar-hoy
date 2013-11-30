package controllers;

import play.mvc.*;
import play.mvc.Http.*;

import models.*;

public class Secured extends Security.Authenticator {
    
    @Override
    public String getUsername(Context ctx) {
        return ctx.session().get("email");
    }
    
    @Override
    public Result onUnauthorized(Context ctx) {
        return unauthorized();
    }
    
    // Comprueba si el usuario logueado es propietario de una lista
    public static boolean isOwnerOf(Long list) {
        return Lista.isOwner(
            list,
            Context.current().request().username()
        );
    }
    
}