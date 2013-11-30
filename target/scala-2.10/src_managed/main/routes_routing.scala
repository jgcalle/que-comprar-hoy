// @SOURCE:C:/Users/pc_pataliebre/Documents/play/que-comprar/conf/routes
// @HASH:fd9f64234ff34eacc26f41a60fee81662e524c67
// @DATE:Sat Nov 30 19:14:40 CET 2013


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_login0 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/1.0/login"))))
        

// @LINE:7
private[this] lazy val controllers_Application_logout1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/1.0/logout"))))
        

// @LINE:10
private[this] lazy val controllers_Usuarios_readAll2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/1.0/usuarios"))))
        

// @LINE:11
private[this] lazy val controllers_Usuarios_read3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/1.0/usuarios/"),DynamicPart("userId", """[0-9]*""",false))))
        

// @LINE:12
private[this] lazy val controllers_Usuarios_create4 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/1.0/usuarios"))))
        

// @LINE:13
private[this] lazy val controllers_Usuarios_update5 = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/1.0/usuarios/"),DynamicPart("userId", """[0-9]*""",false))))
        

// @LINE:14
private[this] lazy val controllers_Usuarios_delete6 = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/1.0/usuarios/"),DynamicPart("userId", """[0-9]*""",false))))
        

// @LINE:17
private[this] lazy val controllers_Listas_create7 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/1.0/listas"))))
        

// @LINE:18
private[this] lazy val controllers_Listas_readAll8 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/1.0/listas"))))
        

// @LINE:19
private[this] lazy val controllers_Listas_read9 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/1.0/listas/"),DynamicPart("listId", """[0-9]*""",false))))
        

// @LINE:20
private[this] lazy val controllers_Listas_delete10 = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/1.0/listas/"),DynamicPart("listId", """[0-9]*""",false))))
        

// @LINE:23
private[this] lazy val controllers_Listas_share11 = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/1.0/listas/"),DynamicPart("listId", """[0-9]*""",false),StaticPart("/usuarios/"),DynamicPart("userId", """[0-9]*""",false))))
        

// @LINE:24
private[this] lazy val controllers_Listas_shareNot12 = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/1.0/listas/"),DynamicPart("listId", """[0-9]*""",false),StaticPart("/usuarios/"),DynamicPart("userId", """[0-9]*""",false))))
        

// @LINE:27
private[this] lazy val controllers_Articulos_create13 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/1.0/listas/"),DynamicPart("listId", """[0-9]*""",false),StaticPart("/articulos"))))
        

// @LINE:28
private[this] lazy val controllers_Articulos_delete14 = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/1.0/articulos/"),DynamicPart("itemId", """[0-9]*""",false))))
        

// @LINE:31
private[this] lazy val controllers_Assets_at15 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/1.0/assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/1.0/login""","""controllers.Application.login()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/1.0/logout""","""controllers.Application.logout()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/1.0/usuarios""","""controllers.Usuarios.readAll(page:Integer ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/1.0/usuarios/$userId<[0-9]*>""","""controllers.Usuarios.read(userId:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/1.0/usuarios""","""controllers.Usuarios.create()"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/1.0/usuarios/$userId<[0-9]*>""","""controllers.Usuarios.update(userId:Long)"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/1.0/usuarios/$userId<[0-9]*>""","""controllers.Usuarios.delete(userId:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/1.0/listas""","""controllers.Listas.create()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/1.0/listas""","""controllers.Listas.readAll(listName:String ?= "", page:Integer ?= 0)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/1.0/listas/$listId<[0-9]*>""","""controllers.Listas.read(listId:Long)"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/1.0/listas/$listId<[0-9]*>""","""controllers.Listas.delete(listId:Long)"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/1.0/listas/$listId<[0-9]*>/usuarios/$userId<[0-9]*>""","""controllers.Listas.share(listId:Long, userId:Long)"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/1.0/listas/$listId<[0-9]*>/usuarios/$userId<[0-9]*>""","""controllers.Listas.shareNot(listId:Long, userId:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/1.0/listas/$listId<[0-9]*>/articulos""","""controllers.Articulos.create(listId:Long)"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/1.0/articulos/$itemId<[0-9]*>""","""controllers.Articulos.delete(itemId:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/1.0/assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_login0(params) => {
   call { 
        invokeHandler(controllers.Application.login(), HandlerDef(this, "controllers.Application", "login", Nil,"POST", """ Authentication""", Routes.prefix + """api/1.0/login"""))
   }
}
        

// @LINE:7
case controllers_Application_logout1(params) => {
   call { 
        invokeHandler(controllers.Application.logout(), HandlerDef(this, "controllers.Application", "logout", Nil,"GET", """""", Routes.prefix + """api/1.0/logout"""))
   }
}
        

// @LINE:10
case controllers_Usuarios_readAll2(params) => {
   call(params.fromQuery[Integer]("page", Some(0))) { (page) =>
        invokeHandler(controllers.Usuarios.readAll(page), HandlerDef(this, "controllers.Usuarios", "readAll", Seq(classOf[Integer]),"GET", """ Operaciones sobre usuarios""", Routes.prefix + """api/1.0/usuarios"""))
   }
}
        

// @LINE:11
case controllers_Usuarios_read3(params) => {
   call(params.fromPath[Long]("userId", None)) { (userId) =>
        invokeHandler(controllers.Usuarios.read(userId), HandlerDef(this, "controllers.Usuarios", "read", Seq(classOf[Long]),"GET", """""", Routes.prefix + """api/1.0/usuarios/$userId<[0-9]*>"""))
   }
}
        

// @LINE:12
case controllers_Usuarios_create4(params) => {
   call { 
        invokeHandler(controllers.Usuarios.create(), HandlerDef(this, "controllers.Usuarios", "create", Nil,"POST", """""", Routes.prefix + """api/1.0/usuarios"""))
   }
}
        

// @LINE:13
case controllers_Usuarios_update5(params) => {
   call(params.fromPath[Long]("userId", None)) { (userId) =>
        invokeHandler(controllers.Usuarios.update(userId), HandlerDef(this, "controllers.Usuarios", "update", Seq(classOf[Long]),"PUT", """""", Routes.prefix + """api/1.0/usuarios/$userId<[0-9]*>"""))
   }
}
        

// @LINE:14
case controllers_Usuarios_delete6(params) => {
   call(params.fromPath[Long]("userId", None)) { (userId) =>
        invokeHandler(controllers.Usuarios.delete(userId), HandlerDef(this, "controllers.Usuarios", "delete", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """api/1.0/usuarios/$userId<[0-9]*>"""))
   }
}
        

// @LINE:17
case controllers_Listas_create7(params) => {
   call { 
        invokeHandler(controllers.Listas.create(), HandlerDef(this, "controllers.Listas", "create", Nil,"POST", """ Operaciones sobre listas""", Routes.prefix + """api/1.0/listas"""))
   }
}
        

// @LINE:18
case controllers_Listas_readAll8(params) => {
   call(params.fromQuery[String]("listName", Some("")), params.fromQuery[Integer]("page", Some(0))) { (listName, page) =>
        invokeHandler(controllers.Listas.readAll(listName, page), HandlerDef(this, "controllers.Listas", "readAll", Seq(classOf[String], classOf[Integer]),"GET", """""", Routes.prefix + """api/1.0/listas"""))
   }
}
        

// @LINE:19
case controllers_Listas_read9(params) => {
   call(params.fromPath[Long]("listId", None)) { (listId) =>
        invokeHandler(controllers.Listas.read(listId), HandlerDef(this, "controllers.Listas", "read", Seq(classOf[Long]),"GET", """""", Routes.prefix + """api/1.0/listas/$listId<[0-9]*>"""))
   }
}
        

// @LINE:20
case controllers_Listas_delete10(params) => {
   call(params.fromPath[Long]("listId", None)) { (listId) =>
        invokeHandler(controllers.Listas.delete(listId), HandlerDef(this, "controllers.Listas", "delete", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """api/1.0/listas/$listId<[0-9]*>"""))
   }
}
        

// @LINE:23
case controllers_Listas_share11(params) => {
   call(params.fromPath[Long]("listId", None), params.fromPath[Long]("userId", None)) { (listId, userId) =>
        invokeHandler(controllers.Listas.share(listId, userId), HandlerDef(this, "controllers.Listas", "share", Seq(classOf[Long], classOf[Long]),"PUT", """ Operaciones compartir listas""", Routes.prefix + """api/1.0/listas/$listId<[0-9]*>/usuarios/$userId<[0-9]*>"""))
   }
}
        

// @LINE:24
case controllers_Listas_shareNot12(params) => {
   call(params.fromPath[Long]("listId", None), params.fromPath[Long]("userId", None)) { (listId, userId) =>
        invokeHandler(controllers.Listas.shareNot(listId, userId), HandlerDef(this, "controllers.Listas", "shareNot", Seq(classOf[Long], classOf[Long]),"DELETE", """""", Routes.prefix + """api/1.0/listas/$listId<[0-9]*>/usuarios/$userId<[0-9]*>"""))
   }
}
        

// @LINE:27
case controllers_Articulos_create13(params) => {
   call(params.fromPath[Long]("listId", None)) { (listId) =>
        invokeHandler(controllers.Articulos.create(listId), HandlerDef(this, "controllers.Articulos", "create", Seq(classOf[Long]),"POST", """ Operaciones sobre articulos""", Routes.prefix + """api/1.0/listas/$listId<[0-9]*>/articulos"""))
   }
}
        

// @LINE:28
case controllers_Articulos_delete14(params) => {
   call(params.fromPath[Long]("itemId", None)) { (itemId) =>
        invokeHandler(controllers.Articulos.delete(itemId), HandlerDef(this, "controllers.Articulos", "delete", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """api/1.0/articulos/$itemId<[0-9]*>"""))
   }
}
        

// @LINE:31
case controllers_Assets_at15(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """api/1.0/assets/$file<.+>"""))
   }
}
        
}

}
     