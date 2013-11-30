
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
object _usuario extends BaseScalaTemplate[play.api.templates.TxtFormat.Appendable,Format[play.api.templates.TxtFormat.Appendable]](play.api.templates.TxtFormat) with play.api.templates.Template1[Usuario,play.api.templates.TxtFormat.Appendable] {

    /**/
    def apply/*1.2*/(usuario: Usuario):play.api.templates.TxtFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.20*/("""
"""),format.raw/*2.1*/("""{"""),format.raw/*2.2*/("""
	"id": """"),_display_(Seq[Any](/*3.10*/usuario/*3.17*/.id)),format.raw/*3.20*/("""",
	"nickname": """"),_display_(Seq[Any](/*4.16*/usuario/*4.23*/.nickName)),format.raw/*4.32*/("""",
	"email": """"),_display_(Seq[Any](/*5.13*/usuario/*5.20*/.email)),format.raw/*5.26*/("""",
	"listas": [
		"""),_display_(Seq[Any](/*7.4*/for(index <- 0 until usuario.myLists.size) yield /*7.46*/{_display_(Seq[Any](format.raw/*7.47*/("""
			"""),_display_(Seq[Any](/*8.5*/_usuario_lista(usuario.myLists(index)))),format.raw/*8.43*/("""
    		"""),_display_(Seq[Any](/*9.8*/if(index != (usuario.myLists.size - 1))/*9.47*/{_display_(Seq[Any](format.raw/*9.48*/("""
        		,
    		""")))})),format.raw/*11.8*/("""
		""")))})),format.raw/*12.4*/("""		
	]
"""),format.raw/*14.1*/("""}"""))}
    }
    
    def render(usuario:Usuario): play.api.templates.TxtFormat.Appendable = apply(usuario)
    
    def f:((Usuario) => play.api.templates.TxtFormat.Appendable) = (usuario) => apply(usuario)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Nov 30 19:14:40 CET 2013
                    SOURCE: C:/Users/pc_pataliebre/Documents/play/que-comprar/app/views/_usuario.scala.txt
                    HASH: 5637f2a706e95e83ae861125a328fff47fb8d27a
                    MATRIX: 772->1|883->19|911->21|938->22|984->33|999->40|1023->43|1077->62|1092->69|1122->78|1173->94|1188->101|1215->107|1270->128|1327->170|1365->171|1405->177|1464->215|1507->224|1554->263|1592->264|1645->286|1681->291|1716->299
                    LINES: 26->1|29->1|30->2|30->2|31->3|31->3|31->3|32->4|32->4|32->4|33->5|33->5|33->5|35->7|35->7|35->7|36->8|36->8|37->9|37->9|37->9|39->11|40->12|42->14
                    -- GENERATED --
                */
            