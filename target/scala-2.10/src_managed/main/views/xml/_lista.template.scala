
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
object _lista extends BaseScalaTemplate[play.api.templates.XmlFormat.Appendable,Format[play.api.templates.XmlFormat.Appendable]](play.api.templates.XmlFormat) with play.api.templates.Template1[Lista,play.api.templates.XmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lista: Lista):play.api.templates.XmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.16*/("""
<lista lista_id=""""),_display_(Seq[Any](/*2.19*/lista/*2.24*/.id)),format.raw/*2.27*/("""">
	<name>"""),_display_(Seq[Any](/*3.9*/lista/*3.14*/.name)),format.raw/*3.19*/("""</name>
	<createdat>"""),_display_(Seq[Any](/*4.14*/lista/*4.19*/.createdAt)),format.raw/*4.29*/("""</createdat>
	<users>
	"""),_display_(Seq[Any](/*6.3*/for(user <- lista.myUsers) yield /*6.29*/{_display_(Seq[Any](format.raw/*6.30*/("""
		"""),_display_(Seq[Any](/*7.4*/_lista_usuario(user))),format.raw/*7.24*/("""
	""")))})),format.raw/*8.3*/("""	
	</users>	
	<articulos>
	"""),_display_(Seq[Any](/*11.3*/for(articulo <- lista.myItems) yield /*11.33*/{_display_(Seq[Any](format.raw/*11.34*/("""
		"""),_display_(Seq[Any](/*12.4*/_articulo(articulo))),format.raw/*12.23*/("""
	""")))})),format.raw/*13.3*/("""	
	</articulos>	
</lista>"""))}
    }
    
    def render(lista:Lista): play.api.templates.XmlFormat.Appendable = apply(lista)
    
    def f:((Lista) => play.api.templates.XmlFormat.Appendable) = (lista) => apply(lista)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Nov 30 19:14:40 CET 2013
                    SOURCE: C:/Users/pc_pataliebre/Documents/play/que-comprar/app/views/_lista.scala.xml
                    HASH: dfe634908038dd922c608f1ed0038d3a23f73184
                    MATRIX: 768->1|875->15|930->35|943->40|967->43|1013->55|1026->60|1052->65|1109->87|1122->92|1153->102|1213->128|1254->154|1292->155|1331->160|1372->180|1406->184|1472->215|1518->245|1557->246|1597->251|1638->270|1673->274
                    LINES: 26->1|29->1|30->2|30->2|30->2|31->3|31->3|31->3|32->4|32->4|32->4|34->6|34->6|34->6|35->7|35->7|36->8|39->11|39->11|39->11|40->12|40->12|41->13
                    -- GENERATED --
                */
            