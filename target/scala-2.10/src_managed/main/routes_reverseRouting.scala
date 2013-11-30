// @SOURCE:C:/Users/pc_pataliebre/Documents/play/que-comprar/conf/routes
// @HASH:fd9f64234ff34eacc26f41a60fee81662e524c67
// @DATE:Sat Nov 30 19:14:40 CET 2013

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:31
// @LINE:28
// @LINE:27
// @LINE:24
// @LINE:23
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:7
// @LINE:6
package controllers {

// @LINE:31
class ReverseAssets {
    

// @LINE:31
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "api/1.0/assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:28
// @LINE:27
class ReverseArticulos {
    

// @LINE:27
def create(listId:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "api/1.0/listas/" + implicitly[PathBindable[Long]].unbind("listId", listId) + "/articulos")
}
                                                

// @LINE:28
def delete(itemId:Long): Call = {
   Call("DELETE", _prefix + { _defaultPrefix } + "api/1.0/articulos/" + implicitly[PathBindable[Long]].unbind("itemId", itemId))
}
                                                
    
}
                          

// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:7
def logout(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "api/1.0/logout")
}
                                                

// @LINE:6
def login(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "api/1.0/login")
}
                                                
    
}
                          

// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
class ReverseUsuarios {
    

// @LINE:14
def delete(userId:Long): Call = {
   Call("DELETE", _prefix + { _defaultPrefix } + "api/1.0/usuarios/" + implicitly[PathBindable[Long]].unbind("userId", userId))
}
                                                

// @LINE:12
def create(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "api/1.0/usuarios")
}
                                                

// @LINE:11
def read(userId:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "api/1.0/usuarios/" + implicitly[PathBindable[Long]].unbind("userId", userId))
}
                                                

// @LINE:10
def readAll(page:Integer = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "api/1.0/usuarios" + queryString(List(if(page == 0) None else Some(implicitly[QueryStringBindable[Integer]].unbind("page", page)))))
}
                                                

// @LINE:13
def update(userId:Long): Call = {
   Call("PUT", _prefix + { _defaultPrefix } + "api/1.0/usuarios/" + implicitly[PathBindable[Long]].unbind("userId", userId))
}
                                                
    
}
                          

// @LINE:24
// @LINE:23
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
class ReverseListas {
    

// @LINE:20
def delete(listId:Long): Call = {
   Call("DELETE", _prefix + { _defaultPrefix } + "api/1.0/listas/" + implicitly[PathBindable[Long]].unbind("listId", listId))
}
                                                

// @LINE:17
def create(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "api/1.0/listas")
}
                                                

// @LINE:19
def read(listId:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "api/1.0/listas/" + implicitly[PathBindable[Long]].unbind("listId", listId))
}
                                                

// @LINE:24
def shareNot(listId:Long, userId:Long): Call = {
   Call("DELETE", _prefix + { _defaultPrefix } + "api/1.0/listas/" + implicitly[PathBindable[Long]].unbind("listId", listId) + "/usuarios/" + implicitly[PathBindable[Long]].unbind("userId", userId))
}
                                                

// @LINE:18
def readAll(listName:String = "", page:Integer = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "api/1.0/listas" + queryString(List(if(listName == "") None else Some(implicitly[QueryStringBindable[String]].unbind("listName", listName)), if(page == 0) None else Some(implicitly[QueryStringBindable[Integer]].unbind("page", page)))))
}
                                                

// @LINE:23
def share(listId:Long, userId:Long): Call = {
   Call("PUT", _prefix + { _defaultPrefix } + "api/1.0/listas/" + implicitly[PathBindable[Long]].unbind("listId", listId) + "/usuarios/" + implicitly[PathBindable[Long]].unbind("userId", userId))
}
                                                
    
}
                          
}
                  


// @LINE:31
// @LINE:28
// @LINE:27
// @LINE:24
// @LINE:23
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:7
// @LINE:6
package controllers.javascript {

// @LINE:31
class ReverseAssets {
    

// @LINE:31
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/1.0/assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:28
// @LINE:27
class ReverseArticulos {
    

// @LINE:27
def create : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Articulos.create",
   """
      function(listId) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/1.0/listas/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("listId", listId) + "/articulos"})
      }
   """
)
                        

// @LINE:28
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Articulos.delete",
   """
      function(itemId) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "api/1.0/articulos/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("itemId", itemId)})
      }
   """
)
                        
    
}
              

// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:7
def logout : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.logout",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/1.0/logout"})
      }
   """
)
                        

// @LINE:6
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.login",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/1.0/login"})
      }
   """
)
                        
    
}
              

// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
class ReverseUsuarios {
    

// @LINE:14
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Usuarios.delete",
   """
      function(userId) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "api/1.0/usuarios/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("userId", userId)})
      }
   """
)
                        

// @LINE:12
def create : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Usuarios.create",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/1.0/usuarios"})
      }
   """
)
                        

// @LINE:11
def read : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Usuarios.read",
   """
      function(userId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/1.0/usuarios/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("userId", userId)})
      }
   """
)
                        

// @LINE:10
def readAll : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Usuarios.readAll",
   """
      function(page) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/1.0/usuarios" + _qS([(page == null ? null : (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("page", page))])})
      }
   """
)
                        

// @LINE:13
def update : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Usuarios.update",
   """
      function(userId) {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "api/1.0/usuarios/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("userId", userId)})
      }
   """
)
                        
    
}
              

// @LINE:24
// @LINE:23
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
class ReverseListas {
    

// @LINE:20
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Listas.delete",
   """
      function(listId) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "api/1.0/listas/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("listId", listId)})
      }
   """
)
                        

// @LINE:17
def create : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Listas.create",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/1.0/listas"})
      }
   """
)
                        

// @LINE:19
def read : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Listas.read",
   """
      function(listId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/1.0/listas/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("listId", listId)})
      }
   """
)
                        

// @LINE:24
def shareNot : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Listas.shareNot",
   """
      function(listId,userId) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "api/1.0/listas/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("listId", listId) + "/usuarios/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("userId", userId)})
      }
   """
)
                        

// @LINE:18
def readAll : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Listas.readAll",
   """
      function(listName,page) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/1.0/listas" + _qS([(listName == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("listName", listName)), (page == null ? null : (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("page", page))])})
      }
   """
)
                        

// @LINE:23
def share : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Listas.share",
   """
      function(listId,userId) {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "api/1.0/listas/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("listId", listId) + "/usuarios/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("userId", userId)})
      }
   """
)
                        
    
}
              
}
        


// @LINE:31
// @LINE:28
// @LINE:27
// @LINE:24
// @LINE:23
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:7
// @LINE:6
package controllers.ref {


// @LINE:31
class ReverseAssets {
    

// @LINE:31
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """api/1.0/assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:28
// @LINE:27
class ReverseArticulos {
    

// @LINE:27
def create(listId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Articulos.create(listId), HandlerDef(this, "controllers.Articulos", "create", Seq(classOf[Long]), "POST", """ Operaciones sobre articulos""", _prefix + """api/1.0/listas/$listId<[0-9]*>/articulos""")
)
                      

// @LINE:28
def delete(itemId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Articulos.delete(itemId), HandlerDef(this, "controllers.Articulos", "delete", Seq(classOf[Long]), "DELETE", """""", _prefix + """api/1.0/articulos/$itemId<[0-9]*>""")
)
                      
    
}
                          

// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:7
def logout(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.logout(), HandlerDef(this, "controllers.Application", "logout", Seq(), "GET", """""", _prefix + """api/1.0/logout""")
)
                      

// @LINE:6
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.login(), HandlerDef(this, "controllers.Application", "login", Seq(), "POST", """ Authentication""", _prefix + """api/1.0/login""")
)
                      
    
}
                          

// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
class ReverseUsuarios {
    

// @LINE:14
def delete(userId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Usuarios.delete(userId), HandlerDef(this, "controllers.Usuarios", "delete", Seq(classOf[Long]), "DELETE", """""", _prefix + """api/1.0/usuarios/$userId<[0-9]*>""")
)
                      

// @LINE:12
def create(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Usuarios.create(), HandlerDef(this, "controllers.Usuarios", "create", Seq(), "POST", """""", _prefix + """api/1.0/usuarios""")
)
                      

// @LINE:11
def read(userId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Usuarios.read(userId), HandlerDef(this, "controllers.Usuarios", "read", Seq(classOf[Long]), "GET", """""", _prefix + """api/1.0/usuarios/$userId<[0-9]*>""")
)
                      

// @LINE:10
def readAll(page:Integer): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Usuarios.readAll(page), HandlerDef(this, "controllers.Usuarios", "readAll", Seq(classOf[Integer]), "GET", """ Operaciones sobre usuarios""", _prefix + """api/1.0/usuarios""")
)
                      

// @LINE:13
def update(userId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Usuarios.update(userId), HandlerDef(this, "controllers.Usuarios", "update", Seq(classOf[Long]), "PUT", """""", _prefix + """api/1.0/usuarios/$userId<[0-9]*>""")
)
                      
    
}
                          

// @LINE:24
// @LINE:23
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
class ReverseListas {
    

// @LINE:20
def delete(listId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Listas.delete(listId), HandlerDef(this, "controllers.Listas", "delete", Seq(classOf[Long]), "DELETE", """""", _prefix + """api/1.0/listas/$listId<[0-9]*>""")
)
                      

// @LINE:17
def create(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Listas.create(), HandlerDef(this, "controllers.Listas", "create", Seq(), "POST", """ Operaciones sobre listas""", _prefix + """api/1.0/listas""")
)
                      

// @LINE:19
def read(listId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Listas.read(listId), HandlerDef(this, "controllers.Listas", "read", Seq(classOf[Long]), "GET", """""", _prefix + """api/1.0/listas/$listId<[0-9]*>""")
)
                      

// @LINE:24
def shareNot(listId:Long, userId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Listas.shareNot(listId, userId), HandlerDef(this, "controllers.Listas", "shareNot", Seq(classOf[Long], classOf[Long]), "DELETE", """""", _prefix + """api/1.0/listas/$listId<[0-9]*>/usuarios/$userId<[0-9]*>""")
)
                      

// @LINE:18
def readAll(listName:String, page:Integer): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Listas.readAll(listName, page), HandlerDef(this, "controllers.Listas", "readAll", Seq(classOf[String], classOf[Integer]), "GET", """""", _prefix + """api/1.0/listas""")
)
                      

// @LINE:23
def share(listId:Long, userId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Listas.share(listId, userId), HandlerDef(this, "controllers.Listas", "share", Seq(classOf[Long], classOf[Long]), "PUT", """ Operaciones compartir listas""", _prefix + """api/1.0/listas/$listId<[0-9]*>/usuarios/$userId<[0-9]*>""")
)
                      
    
}
                          
}
        
    