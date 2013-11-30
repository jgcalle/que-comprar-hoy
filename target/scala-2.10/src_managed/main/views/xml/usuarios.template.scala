
package views.xml

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
import views.xml._
/**/
object usuarios extends BaseScalaTemplate[play.api.templates.XmlFormat.Appendable,Format[play.api.templates.XmlFormat.Appendable]](play.api.templates.XmlFormat) with play.api.templates.Template1[List[Usuario],play.api.templates.XmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(usuarios:List[Usuario]):play.api.templates.XmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.26*/("""
<usuarios>
	"""),_display_(Seq[Any](/*3.3*/for(usuario <- usuarios) yield /*3.27*/{_display_(Seq[Any](format.raw/*3.28*/("""
		"""),_display_(Seq[Any](/*4.4*/_usuario(usuario))),format.raw/*4.21*/("""
	""")))})),format.raw/*5.3*/("""
</usuarios>"""))}
    }
    
    def render(usuarios:List[Usuario]): play.api.templates.XmlFormat.Appendable = apply(usuarios)
    
    def f:((List[Usuario]) => play.api.templates.XmlFormat.Appendable) = (usuarios) => apply(usuarios)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Nov 30 19:14:40 CET 2013
                    SOURCE: C:/Users/pc_pataliebre/Documents/play/que-comprar/app/views/usuarios.scala.xml
                    HASH: 4bcc62d3273cee3ecff67f5e2a7212671c56c02a
                    MATRIX: 778->1|895->25|945->41|984->65|1022->66|1061->71|1099->88|1133->92
                    LINES: 26->1|29->1|31->3|31->3|31->3|32->4|32->4|33->5
                    -- GENERATED --
                */
            