
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
object _articulo extends BaseScalaTemplate[play.api.templates.XmlFormat.Appendable,Format[play.api.templates.XmlFormat.Appendable]](play.api.templates.XmlFormat) with play.api.templates.Template1[Articulo,play.api.templates.XmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(articulo: Articulo):play.api.templates.XmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.22*/("""
<articulo articulo_id=""""),_display_(Seq[Any](/*2.25*/articulo/*2.33*/.id)),format.raw/*2.36*/("""">
	<name>"""),_display_(Seq[Any](/*3.9*/articulo/*3.17*/.name)),format.raw/*3.22*/("""</name>
	<amount>"""),_display_(Seq[Any](/*4.11*/articulo/*4.19*/.amount)),format.raw/*4.26*/("""</amount>
</articulo>"""))}
    }
    
    def render(articulo:Articulo): play.api.templates.XmlFormat.Appendable = apply(articulo)
    
    def f:((Articulo) => play.api.templates.XmlFormat.Appendable) = (articulo) => apply(articulo)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Nov 30 19:14:40 CET 2013
                    SOURCE: C:/Users/pc_pataliebre/Documents/play/que-comprar/app/views/_articulo.scala.xml
                    HASH: eb7f4480c1892f32b2d1d3e4ae0122453252c60a
                    MATRIX: 774->1|887->21|948->47|964->55|988->58|1034->70|1050->78|1076->83|1130->102|1146->110|1174->117
                    LINES: 26->1|29->1|30->2|30->2|30->2|31->3|31->3|31->3|32->4|32->4|32->4
                    -- GENERATED --
                */
            