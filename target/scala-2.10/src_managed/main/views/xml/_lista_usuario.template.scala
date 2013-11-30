
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
object _lista_usuario extends BaseScalaTemplate[play.api.templates.XmlFormat.Appendable,Format[play.api.templates.XmlFormat.Appendable]](play.api.templates.XmlFormat) with play.api.templates.Template1[Usuario,play.api.templates.XmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(usuario: Usuario):play.api.templates.XmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.20*/("""
<usuario id=""""),_display_(Seq[Any](/*2.15*/usuario/*2.22*/.id)),format.raw/*2.25*/("""">
	<nickname>"""),_display_(Seq[Any](/*3.13*/usuario/*3.20*/.nickName)),format.raw/*3.29*/("""</nickname>
</usuario>"""))}
    }
    
    def render(usuario:Usuario): play.api.templates.XmlFormat.Appendable = apply(usuario)
    
    def f:((Usuario) => play.api.templates.XmlFormat.Appendable) = (usuario) => apply(usuario)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Nov 30 19:14:40 CET 2013
                    SOURCE: C:/Users/pc_pataliebre/Documents/play/que-comprar/app/views/_lista_usuario.scala.xml
                    HASH: 159c302b579440f05267444d406df1d5a66acafd
                    MATRIX: 778->1|889->19|940->35|955->42|979->45|1030->61|1045->68|1075->77
                    LINES: 26->1|29->1|30->2|30->2|30->2|31->3|31->3|31->3
                    -- GENERATED --
                */
            