
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
object _usuario_lista extends BaseScalaTemplate[play.api.templates.TxtFormat.Appendable,Format[play.api.templates.TxtFormat.Appendable]](play.api.templates.TxtFormat) with play.api.templates.Template1[Lista,play.api.templates.TxtFormat.Appendable] {

    /**/
    def apply/*1.2*/(lista: Lista):play.api.templates.TxtFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.16*/("""
"""),format.raw/*2.1*/("""{"""),format.raw/*2.2*/("""
	"id": """"),_display_(Seq[Any](/*3.10*/lista/*3.15*/.id)),format.raw/*3.18*/("""",
	"name": """"),_display_(Seq[Any](/*4.12*/lista/*4.17*/.name)),format.raw/*4.22*/(""""
"""),format.raw/*5.1*/("""}"""),format.raw/*5.2*/("""	"""))}
    }
    
    def render(lista:Lista): play.api.templates.TxtFormat.Appendable = apply(lista)
    
    def f:((Lista) => play.api.templates.TxtFormat.Appendable) = (lista) => apply(lista)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Nov 30 19:14:40 CET 2013
                    SOURCE: C:/Users/pc_pataliebre/Documents/play/que-comprar/app/views/_usuario_lista.scala.txt
                    HASH: 5df82d1d0b729ce9d9f33b4b3b2ec755dca79113
                    MATRIX: 776->1|883->15|911->17|938->18|984->29|997->34|1021->37|1071->52|1084->57|1110->62|1139->65|1166->66
                    LINES: 26->1|29->1|30->2|30->2|31->3|31->3|31->3|32->4|32->4|32->4|33->5|33->5
                    -- GENERATED --
                */
            