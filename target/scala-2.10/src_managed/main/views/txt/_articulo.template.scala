
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
object _articulo extends BaseScalaTemplate[play.api.templates.TxtFormat.Appendable,Format[play.api.templates.TxtFormat.Appendable]](play.api.templates.TxtFormat) with play.api.templates.Template1[Articulo,play.api.templates.TxtFormat.Appendable] {

    /**/
    def apply/*1.2*/(articulo: Articulo):play.api.templates.TxtFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.22*/("""
"""),format.raw/*2.1*/("""{"""),format.raw/*2.2*/("""
	"id": """"),_display_(Seq[Any](/*3.10*/articulo/*3.18*/.id)),format.raw/*3.21*/("""",
	"name": """"),_display_(Seq[Any](/*4.12*/articulo/*4.20*/.name)),format.raw/*4.25*/("""",
	"amount": """"),_display_(Seq[Any](/*5.14*/articulo/*5.22*/.amount)),format.raw/*5.29*/(""""
"""),format.raw/*6.1*/("""}"""))}
    }
    
    def render(articulo:Articulo): play.api.templates.TxtFormat.Appendable = apply(articulo)
    
    def f:((Articulo) => play.api.templates.TxtFormat.Appendable) = (articulo) => apply(articulo)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Nov 30 19:14:40 CET 2013
                    SOURCE: C:/Users/pc_pataliebre/Documents/play/que-comprar/app/views/_articulo.scala.txt
                    HASH: a85533d9cacd2a41df95b80d6442fc2778f5bb78
                    MATRIX: 774->1|887->21|915->23|942->24|988->35|1004->43|1028->46|1078->61|1094->69|1120->74|1172->91|1188->99|1216->106|1245->109
                    LINES: 26->1|29->1|30->2|30->2|31->3|31->3|31->3|32->4|32->4|32->4|33->5|33->5|33->5|34->6
                    -- GENERATED --
                */
            