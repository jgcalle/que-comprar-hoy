
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
object _lista extends BaseScalaTemplate[play.api.templates.TxtFormat.Appendable,Format[play.api.templates.TxtFormat.Appendable]](play.api.templates.TxtFormat) with play.api.templates.Template1[Lista,play.api.templates.TxtFormat.Appendable] {

    /**/
    def apply/*1.2*/(lista: Lista):play.api.templates.TxtFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.16*/("""
"""),format.raw/*2.1*/("""{"""),format.raw/*2.2*/("""
	"id": """"),_display_(Seq[Any](/*3.10*/lista/*3.15*/.id)),format.raw/*3.18*/("""",
	"name": """"),_display_(Seq[Any](/*4.12*/lista/*4.17*/.name)),format.raw/*4.22*/("""",
	"createdat": """"),_display_(Seq[Any](/*5.17*/lista/*5.22*/.createdAt)),format.raw/*5.32*/("""",
	"users": [
		"""),_display_(Seq[Any](/*7.4*/for((user,index) <- lista.myUsers.zipWithIndex) yield /*7.51*/{_display_(Seq[Any](format.raw/*7.52*/("""
			"""),_display_(Seq[Any](/*8.5*/_lista_usuario(user))),format.raw/*8.25*/("""
    		"""),_display_(Seq[Any](/*9.8*/if(index != (lista.myUsers.size - 1))/*9.45*/{_display_(Seq[Any](format.raw/*9.46*/("""
        		,
    		""")))})),format.raw/*11.8*/("""			
		""")))})),format.raw/*12.4*/("""  		
	],
	"articulos": [	
		"""),_display_(Seq[Any](/*15.4*/for(index_articulo <- 0 until lista.myItems.size) yield /*15.53*/{_display_(Seq[Any](format.raw/*15.54*/("""
			"""),_display_(Seq[Any](/*16.5*/_articulo(lista.myItems(index_articulo)))),format.raw/*16.45*/("""
    		"""),_display_(Seq[Any](/*17.8*/if(index_articulo != (lista.myItems.size - 1))/*17.54*/{_display_(Seq[Any](format.raw/*17.55*/("""
        		,
    		""")))})),format.raw/*19.8*/("""
		""")))})),format.raw/*20.4*/("""		
	]	
"""),format.raw/*22.1*/("""}"""),format.raw/*22.2*/("""	"""))}
    }
    
    def render(lista:Lista): play.api.templates.TxtFormat.Appendable = apply(lista)
    
    def f:((Lista) => play.api.templates.TxtFormat.Appendable) = (lista) => apply(lista)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Nov 30 19:14:40 CET 2013
                    SOURCE: C:/Users/pc_pataliebre/Documents/play/que-comprar/app/views/_lista.scala.txt
                    HASH: cbf4e2eaf02e968b33fb1a5c48c58b8ebed5ad30
                    MATRIX: 768->1|875->15|903->17|930->18|976->29|989->34|1013->37|1063->52|1076->57|1102->62|1157->82|1170->87|1201->97|1255->117|1317->164|1355->165|1395->171|1436->191|1479->200|1524->237|1562->238|1615->260|1654->268|1721->300|1786->349|1825->350|1866->356|1928->396|1972->405|2027->451|2066->452|2119->474|2155->479|2191->488|2219->489
                    LINES: 26->1|29->1|30->2|30->2|31->3|31->3|31->3|32->4|32->4|32->4|33->5|33->5|33->5|35->7|35->7|35->7|36->8|36->8|37->9|37->9|37->9|39->11|40->12|43->15|43->15|43->15|44->16|44->16|45->17|45->17|45->17|47->19|48->20|50->22|50->22
                    -- GENERATED --
                */
            