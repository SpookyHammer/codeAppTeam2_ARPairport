package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import hbo5.it.www.beans.Persoon;
import java.util.ArrayList;
import hbo5.it.www.beans.Vlucht;

public final class overzichtVluchten_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Overzicht vluchten</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");
ArrayList<Vlucht> lijstAlleBinnenkomendeVluchten = (ArrayList<Vlucht>) request.getAttribute("lijstAlleBinnenkomendeVluchten");
      out.write("\r\n");
      out.write("        ");
ArrayList<Vlucht> lijstAlleVertrekkendeVluchten = (ArrayList<Vlucht>) request.getAttribute("lijstAlleVertrekkendeVluchten");
      out.write("\r\n");
      out.write("        ");
ArrayList<Vlucht> lijstAlleVluchtenLuchtvaartmaatschappij = (ArrayList<Vlucht>) request.getAttribute("lijstAlleVluchtenLuchtvaartmaatschappij");
      out.write("\r\n");
      out.write("        ");
Persoon persoon = (Persoon) session.getAttribute("persoon");
      out.write("\r\n");
      out.write("        ");
Vlucht vlucht2 = (Vlucht) request.getAttribute("vlucht");
      out.write("\r\n");
      out.write("        ");
ArrayList<Vlucht> vluchtenDatum = (ArrayList<Vlucht>) request.getAttribute("vluchtenDatum");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <h1>Overzicht vluchten</h1>\r\n");
      out.write("\r\n");
      out.write("        <table border=\"1\" cellpadding=\"3\">\r\n");
      out.write("            <thead>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>Vluchtnummer:</td>\r\n");
      out.write("                    <td>Vertrek luchthaven:</td>\r\n");
      out.write("                    <td width=\"100\">Geplande vertrektijd:</td>\r\n");
      out.write("                    <td>Aankomst luchthaven:</td>\r\n");
      out.write("                    <td>Geplande aankomsttijd:</td>\r\n");
      out.write("                    ");
if (persoon != null && persoon.getSoort() == 'P') {
      out.write("\r\n");
      out.write("                    <td> Boek vlucht </td>\r\n");
      out.write("                    ");
}
                        if (persoon != null && persoon.getSoort() == 'B') {
      out.write("\r\n");
      out.write("                    <td> Bekijk Passagierslijst </td>\r\n");
      out.write("                    ");
}
      out.write(" \r\n");
      out.write("                </tr>\r\n");
      out.write("            </thead>\r\n");
      out.write("            <tbody>\r\n");
      out.write("\r\n");
      out.write("                ");
  if (lijstAlleBinnenkomendeVluchten != null) {
                        for (Vlucht vlucht : lijstAlleBinnenkomendeVluchten) {
      out.write("\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td> ");
      out.print(vlucht.getCode());
      out.write("</td>\r\n");
      out.write("                    <td>");
      out.print(vlucht.getVertrekluchthaven().getLuchthavennaam());
      out.write("</td>\r\n");
      out.write("                    <td> ");
      out.print(vlucht.getVertrektijd());
      out.write("</td>\r\n");
      out.write("                    <td>");
      out.print(vlucht.getAankomstluchthaven().getLuchthavennaam());
      out.write("</td>\r\n");
      out.write("                    <td> ");
      out.print(vlucht.getAankomsttijd());
      out.write("</td> \r\n");
      out.write("                    ");
if (persoon != null && persoon.getSoort() == 'P') {
      out.write("\r\n");
      out.write("                    <td> <button value=\"");
      out.print(vlucht.getCode());
      out.write("\" name=\"knopVluchtBoeken\" >Vlucht boeken</button> </td>\r\n");
      out.write("                    ");
 }
                        if (persoon != null && persoon.getSoort() == 'B') {
      out.write("\r\n");
      out.write("            <form action=\"ManageServlet\">\r\n");
      out.write("                <td> <button type=\"submit\" value=\"");
      out.print(vlucht.getCode());
      out.write("\" name=\"knopPassagierslijstZoeken\" >Passagierslijst</button> </td>\r\n");
      out.write("            </form>\r\n");
      out.write("            ");
}
      out.write("\r\n");
      out.write("        </tr>\r\n");
      out.write("\r\n");
      out.write("        ");
}
        } else if (lijstAlleVertrekkendeVluchten != null) {
            for (Vlucht vlucht : lijstAlleVertrekkendeVluchten) {
      out.write("\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td> ");
      out.print(vlucht.getCode());
      out.write("</td>\r\n");
      out.write("            <td>");
      out.print(vlucht.getVertrekluchthaven().getLuchthavennaam());
      out.write("</td>\r\n");
      out.write("            <td> ");
      out.print(vlucht.getVertrektijd());
      out.write("</td>\r\n");
      out.write("            <td>");
      out.print(vlucht.getAankomstluchthaven().getLuchthavennaam());
      out.write("</td>\r\n");
      out.write("            <td> ");
      out.print(vlucht.getAankomsttijd());
      out.write("</td>\r\n");
      out.write("            ");
if (persoon != null && persoon.getSoort() == 'P') {
      out.write("\r\n");
      out.write("            <td> <button value=\"");
      out.print(vlucht.getCode());
      out.write("\" name=\"knopVluchtBoeken\" >Vlucht boeken</button> </td>\r\n");
      out.write("            ");
}
                if (persoon != null && persoon.getSoort() == 'B') {
      out.write("\r\n");
      out.write("        <form action=\"ManageServlet\">\r\n");
      out.write("            <td> <button type=\"submit\" value=\"");
      out.print(vlucht.getCode());
      out.write("\" name=\"knopPassagierslijstZoeken\" >Passagierslijst</button> </td>\r\n");
      out.write("        </form>\r\n");
      out.write("        ");
}
      out.write("\r\n");
      out.write("    </tr>\r\n");
      out.write("\r\n");
      out.write("    ");
}
    } else if (lijstAlleVluchtenLuchtvaartmaatschappij != null) {
        for (Vlucht vlucht : lijstAlleVluchtenLuchtvaartmaatschappij) {
      out.write("\r\n");
      out.write("    <tr>\r\n");
      out.write("        <td> ");
      out.print(vlucht.getCode());
      out.write("</td>\r\n");
      out.write("        <td>");
      out.print(vlucht.getVertrekluchthaven().getLuchthavennaam());
      out.write("</td>\r\n");
      out.write("        <td> ");
      out.print(vlucht.getVertrektijd());
      out.write("</td>\r\n");
      out.write("        <td>");
      out.print(vlucht.getAankomstluchthaven().getLuchthavennaam());
      out.write("</td>\r\n");
      out.write("        <td> ");
      out.print(vlucht.getAankomsttijd());
      out.write("</td> \r\n");
      out.write("        ");
if (persoon != null && persoon.getSoort() == 'P') {
      out.write("\r\n");
      out.write("        <td> <button value=\"");
      out.print(vlucht.getCode());
      out.write("\" name=\"knopVluchtBoeken\" >Vlucht boeken</button> </td>\r\n");
      out.write("        ");
}
            if (persoon != null && persoon.getSoort() == 'B') {
      out.write("\r\n");
      out.write("    <form action=\"ManageServlet\">\r\n");
      out.write("        <td> <button type=\"submit\" value=\"");
      out.print(vlucht.getCode());
      out.write("\" name=\"knopPassagierslijstZoeken\" >Passagierslijst</button> </td>\r\n");
      out.write("    </form>\r\n");
      out.write("    ");
}
      out.write("\r\n");
      out.write("</tr>                   \r\n");
}
} else if (vlucht2 != null) {
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("    <td> ");
      out.print(vlucht2.getCode());
      out.write("</td>\r\n");
      out.write("    <td>");
      out.print(vlucht2.getVertrekluchthaven().getLuchthavennaam());
      out.write("</td>\r\n");
      out.write("    <td> ");
      out.print(vlucht2.getVertrektijd());
      out.write("</td>\r\n");
      out.write("    <td>");
      out.print(vlucht2.getAankomstluchthaven().getLuchthavennaam());
      out.write("</td>\r\n");
      out.write("    <td> ");
      out.print(vlucht2.getAankomsttijd());
      out.write("</td> \r\n");
      out.write("    ");
if (persoon != null && persoon.getSoort() == 'P') {
      out.write("\r\n");
      out.write("    <td> <button value=\"");
      out.print(vlucht2.getCode());
      out.write("\" name=\"knopVluchtBoeken\" >Vlucht boeken</button> </td>\r\n");
      out.write("    ");
}
        if (persoon != null && persoon.getSoort() == 'B') {
      out.write("\r\n");
      out.write("<form action=\"ManageServlet\">\r\n");
      out.write("    <td> <button type=\"submit\" value=\"");
      out.print(vlucht2.getCode());
      out.write("\" name=\"knopPassagierslijst\" >Passagierslijst</button> </td>\r\n");
      out.write("</form>\r\n");
}
      out.write("\r\n");
      out.write("</tr>                   \r\n");
} else if (vluchtenDatum != null) {
    for (Vlucht vlucht : vluchtenDatum) {
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("    <td>");
      out.print(vlucht.getCode());
      out.write("</td>\r\n");
      out.write("    <td>");
      out.print(vlucht.getVertrekluchthaven().getLuchthavennaam());
      out.write("</td>\r\n");
      out.write("    <td> ");
      out.print(vlucht.getVertrektijd());
      out.write("</td>\r\n");
      out.write("    <td>");
      out.print(vlucht.getAankomstluchthaven().getLuchthavennaam());
      out.write("</td>\r\n");
      out.write("    <td> ");
      out.print(vlucht.getAankomsttijd());
      out.write("</td>  \r\n");
      out.write("    ");
if (persoon != null && persoon.getSoort() == 'P') {
      out.write("\r\n");
      out.write("    <td> <button value=\"");
      out.print(vlucht.getCode());
      out.write("\" name=\"knopVluchtBoeken\" >Vlucht boeken</button> </td>\r\n");
      out.write("    ");
}
        if (persoon != null && persoon.getSoort() == 'B') {
      out.write("\r\n");
      out.write("<form action=\"ManageServlet\">\r\n");
      out.write("    <td> <input type=\"submit\" value=\"");
      out.print(vlucht.getCode());
      out.write("\" name=\"knopPassagierslijstZoeken\" >Passagierslijst</button> </td>\r\n");
      out.write("</form>\r\n");
}
      out.write("\r\n");
      out.write("</tr>                   \r\n");
}
    }
      out.write("\r\n");
      out.write("</tbody>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("<form action=\"InlogServlet\">\r\n");
      out.write("    <!-- Zet dit er bij voor een de naam van de gebruiker en een inlog of uitlog button te hebben : -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    ");
if (persoon != null) {
      out.write("\r\n");
      out.write("    <P>\r\n");
      out.write("        <label name=\"naam\">");
      out.print(persoon.getVoornaam());
      out.write("</label>\r\n");
      out.write("        <label name=\"famillienaam\">");
      out.print(persoon.getFamilienaam());
      out.write("</label>\r\n");
      out.write("    </p>\r\n");
      out.write("    <input type=\"submit\" value=\"Uitloggen\" name=\"UitlogKnop\"/>\r\n");
      out.write("    ");
} else {
      out.write("\r\n");
      out.write("    <input type=\"submit\" value=\"Inloggen\" name=\"InlogKnop\"/>\r\n");
      out.write("    ");
}
      out.write("\r\n");
      out.write("</form> \r\n");
      out.write("\r\n");
      out.write("<p>  <a href=\"vluchtenZoeken.jsp\">Terug naar zoekpagina</a></p>\r\n");
      out.write("<p>  <a href=\"index.jsp\">Terug naar beginpagina</a></p>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
