
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
object listas extends BaseScalaTemplate[play.api.templates.TxtFormat.Appendable,Format[play.api.templates.TxtFormat.Appendable]](play.api.templates.TxtFormat) with play.api.templates.Template1[List[Lista],play.api.templates.TxtFormat.Appendable] {

    /**/
    def apply/*1.2*/(listas: List[Lista]):play.api.templates.TxtFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.23*/("""
"""),format.raw/*2.1*/("""{"""),format.raw/*2.2*/("""
	"listas": [		
		"""),_display_(Seq[Any](/*4.4*/for(index <- 0 until listas.size) yield /*4.37*/{_display_(Seq[Any](format.raw/*4.38*/("""
			"""),_display_(Seq[Any](/*5.5*/_lista(listas(index)))),format.raw/*5.26*/("""
    		"""),_display_(Seq[Any](/*6.8*/if(index != (listas.size - 1))/*6.38*/{_display_(Seq[Any](format.raw/*6.39*/("""
        		,
    		""")))})),format.raw/*8.8*/("""
		""")))})),format.raw/*9.4*/("""		
	]
"""),format.raw/*11.1*/("""}"""))}
    }
    
    def render(listas:List[Lista]): play.api.templates.TxtFormat.Appendable = apply(listas)
    
    def f:((List[Lista]) => play.api.templates.TxtFormat.Appendable) = (listas) => apply(listas)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Nov 30 19:14:40 CET 2013
                    SOURCE: C:/Users/pc_pataliebre/Documents/play/que-comprar/app/views/listas.scala.txt
                    HASH: 7294f96721ac115aac11557cc6070b19ddb305c3
                    MATRIX: 774->1|888->22|916->24|943->25|998->46|1046->79|1084->80|1124->86|1166->107|1209->116|1247->146|1285->147|1337->169|1372->174|1407->182
                    LINES: 26->1|29->1|30->2|30->2|32->4|32->4|32->4|33->5|33->5|34->6|34->6|34->6|36->8|37->9|39->11
                    -- GENERATED --
                */
            