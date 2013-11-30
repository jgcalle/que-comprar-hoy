
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
object listas extends BaseScalaTemplate[play.api.templates.XmlFormat.Appendable,Format[play.api.templates.XmlFormat.Appendable]](play.api.templates.XmlFormat) with play.api.templates.Template1[List[Lista],play.api.templates.XmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(listas:List[Lista]):play.api.templates.XmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.22*/("""
<listas>
	"""),_display_(Seq[Any](/*3.3*/for(lista <- listas) yield /*3.23*/{_display_(Seq[Any](format.raw/*3.24*/("""
		"""),_display_(Seq[Any](/*4.4*/_lista(lista))),format.raw/*4.17*/("""
	""")))})),format.raw/*5.3*/("""
</listas>"""))}
    }
    
    def render(listas:List[Lista]): play.api.templates.XmlFormat.Appendable = apply(listas)
    
    def f:((List[Lista]) => play.api.templates.XmlFormat.Appendable) = (listas) => apply(listas)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Nov 30 19:14:40 CET 2013
                    SOURCE: C:/Users/pc_pataliebre/Documents/play/que-comprar/app/views/listas.scala.xml
                    HASH: dfed029278449c5c56c95a07fd193c6a7f67b053
                    MATRIX: 774->1|887->21|935->35|970->55|1008->56|1047->61|1081->74|1115->78
                    LINES: 26->1|29->1|31->3|31->3|31->3|32->4|32->4|33->5
                    -- GENERATED --
                */
            