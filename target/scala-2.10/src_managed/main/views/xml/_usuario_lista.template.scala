
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
object _usuario_lista extends BaseScalaTemplate[play.api.templates.XmlFormat.Appendable,Format[play.api.templates.XmlFormat.Appendable]](play.api.templates.XmlFormat) with play.api.templates.Template1[Lista,play.api.templates.XmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lista: Lista):play.api.templates.XmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.16*/("""
<lista lista_id=""""),_display_(Seq[Any](/*2.19*/lista/*2.24*/.id)),format.raw/*2.27*/("""">
	<name>"""),_display_(Seq[Any](/*3.9*/lista/*3.14*/.name)),format.raw/*3.19*/("""</name>	
</lista>"""))}
    }
    
    def render(lista:Lista): play.api.templates.XmlFormat.Appendable = apply(lista)
    
    def f:((Lista) => play.api.templates.XmlFormat.Appendable) = (lista) => apply(lista)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Nov 30 19:14:40 CET 2013
                    SOURCE: C:/Users/pc_pataliebre/Documents/play/que-comprar/app/views/_usuario_lista.scala.xml
                    HASH: 26a02aaecea7cc88eb2d2b600e28ba07269f22a0
                    MATRIX: 776->1|883->15|938->35|951->40|975->43|1021->55|1034->60|1060->65
                    LINES: 26->1|29->1|30->2|30->2|30->2|31->3|31->3|31->3
                    -- GENERATED --
                */
            