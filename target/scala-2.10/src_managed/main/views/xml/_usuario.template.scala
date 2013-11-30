
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
object _usuario extends BaseScalaTemplate[play.api.templates.XmlFormat.Appendable,Format[play.api.templates.XmlFormat.Appendable]](play.api.templates.XmlFormat) with play.api.templates.Template1[Usuario,play.api.templates.XmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(usuario: Usuario):play.api.templates.XmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.20*/("""
<usuario id=""""),_display_(Seq[Any](/*2.15*/usuario/*2.22*/.id)),format.raw/*2.25*/("""">
	<nickname>"""),_display_(Seq[Any](/*3.13*/usuario/*3.20*/.nickName)),format.raw/*3.29*/("""</nickname>
	<email>"""),_display_(Seq[Any](/*4.10*/usuario/*4.17*/.email)),format.raw/*4.23*/("""</email>
	<listas>
	"""),_display_(Seq[Any](/*6.3*/for(lista <- usuario.myLists) yield /*6.32*/{_display_(Seq[Any](format.raw/*6.33*/("""
		"""),_display_(Seq[Any](/*7.4*/_usuario_lista(lista))),format.raw/*7.25*/("""
	""")))})),format.raw/*8.3*/("""	
	</listas>
</usuario>"""))}
    }
    
    def render(usuario:Usuario): play.api.templates.XmlFormat.Appendable = apply(usuario)
    
    def f:((Usuario) => play.api.templates.XmlFormat.Appendable) = (usuario) => apply(usuario)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Nov 30 19:14:40 CET 2013
                    SOURCE: C:/Users/pc_pataliebre/Documents/play/que-comprar/app/views/_usuario.scala.xml
                    HASH: d3cd8a69a8ad25f1106d21e6324d64fd7b91d973
                    MATRIX: 772->1|883->19|934->35|949->42|973->45|1024->61|1039->68|1069->77|1126->99|1141->106|1168->112|1225->135|1269->164|1307->165|1346->170|1388->191|1422->195
                    LINES: 26->1|29->1|30->2|30->2|30->2|31->3|31->3|31->3|32->4|32->4|32->4|34->6|34->6|34->6|35->7|35->7|36->8
                    -- GENERATED --
                */
            