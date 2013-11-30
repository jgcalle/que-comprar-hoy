
package views.txt

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.txt._
/**/
object usuarios extends BaseScalaTemplate[play.api.templates.TxtFormat.Appendable,Format[play.api.templates.TxtFormat.Appendable]](play.api.templates.TxtFormat) with play.api.templates.Template1[List[Usuario],play.api.templates.TxtFormat.Appendable] {

    /**/
    def apply/*1.2*/(usuarios: List[Usuario]):play.api.templates.TxtFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.27*/("""
"""),format.raw/*2.1*/("""{"""),format.raw/*2.2*/("""
	"usuarios": [
		"""),_display_(Seq[Any](/*4.4*/for(index <- 0 until usuarios.size) yield /*4.39*/{_display_(Seq[Any](format.raw/*4.40*/("""
			"""),_display_(Seq[Any](/*5.5*/_usuario(usuarios(index)))),format.raw/*5.30*/("""
    		"""),_display_(Seq[Any](/*6.8*/if(index != (usuarios.size - 1))/*6.40*/{_display_(Seq[Any](format.raw/*6.41*/("""
        		,
    		""")))})),format.raw/*8.8*/("""
		""")))})),format.raw/*9.4*/("""
	]
"""),format.raw/*11.1*/("""}"""))}
    }
    
    def render(usuarios:List[Usuario]): play.api.templates.TxtFormat.Appendable = apply(usuarios)
    
    def f:((List[Usuario]) => play.api.templates.TxtFormat.Appendable) = (usuarios) => apply(usuarios)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Nov 30 19:14:40 CET 2013
                    SOURCE: C:/Users/pc_pataliebre/Documents/play/que-comprar/app/views/usuarios.scala.txt
                    HASH: 0af6c1a840dc9f45b74ba6a7bf4320001ca12fd2
                    MATRIX: 778->1|896->26|924->28|951->29|1006->50|1056->85|1094->86|1134->92|1180->117|1223->126|1263->158|1301->159|1353->181|1388->186|1421->192
                    LINES: 26->1|29->1|30->2|30->2|32->4|32->4|32->4|33->5|33->5|34->6|34->6|34->6|36->8|37->9|39->11
                    -- GENERATED --
                */
            