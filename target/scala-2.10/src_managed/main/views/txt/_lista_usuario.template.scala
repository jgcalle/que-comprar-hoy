
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
object _lista_usuario extends BaseScalaTemplate[play.api.templates.TxtFormat.Appendable,Format[play.api.templates.TxtFormat.Appendable]](play.api.templates.TxtFormat) with play.api.templates.Template1[Usuario,play.api.templates.TxtFormat.Appendable] {

    /**/
    def apply/*1.2*/(usuario: Usuario):play.api.templates.TxtFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.20*/("""
"""),format.raw/*2.1*/("""{"""),format.raw/*2.2*/("""
	"id": """"),_display_(Seq[Any](/*3.10*/usuario/*3.17*/.id)),format.raw/*3.20*/("""",
	"nickname": """"),_display_(Seq[Any](/*4.16*/usuario/*4.23*/.nickName)),format.raw/*4.32*/(""""
"""),format.raw/*5.1*/("""}"""))}
    }
    
    def render(usuario:Usuario): play.api.templates.TxtFormat.Appendable = apply(usuario)
    
    def f:((Usuario) => play.api.templates.TxtFormat.Appendable) = (usuario) => apply(usuario)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Nov 30 19:14:40 CET 2013
                    SOURCE: C:/Users/pc_pataliebre/Documents/play/que-comprar/app/views/_lista_usuario.scala.txt
                    HASH: 91be4912576c7b50c85f0d006a9c03a432d3793e
                    MATRIX: 778->1|889->19|917->21|944->22|990->33|1005->40|1029->43|1083->62|1098->69|1128->78|1157->81
                    LINES: 26->1|29->1|30->2|30->2|31->3|31->3|31->3|32->4|32->4|32->4|33->5
                    -- GENERATED --
                */
            