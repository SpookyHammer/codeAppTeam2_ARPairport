package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import hbo5.it.www.beans.Luchtvaartmaatschappij;
import hbo5.it.www.beans.Persoon;
import hbo5.it.www.beans.Luchthaven;
import java.util.ArrayList;
import hbo5.it.www.beans.Vlucht;

public final class vluchtenZoeken_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Vluchten zoeken</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <script>\r\n");
      out.write("        String selectedValue = \"\";\r\n");
      out.write("        function changeFunction(){\r\n");
      out.write("            selectedValue = selectBoxID.options[selectBoxID.selectedIndex].value;\r\n");
      out.write("           \r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("    </script>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");
ArrayList<Luchthaven> lijstAlleLuchthavens = (ArrayList<Luchthaven>) request.getAttribute("lijstAlleLuchthavens");
      out.write("\r\n");
      out.write("        ");
ArrayList<Luchtvaartmaatschappij> lijstAlleLuchtvaartmaatschappijen = (ArrayList<Luchtvaartmaatschappij>) request.getAttribute("lijstAlleLuchtvaartmaatschappijen");
      out.write("\r\n");
      out.write("       \r\n");
      out.write("        \r\n");
      out.write("        <h1>Zoek hier uw vlucht</h1>\r\n");
      out.write("\r\n");
      out.write("        <form action=\"ZoekServlet\">\r\n");
      out.write("            <p>\r\n");
      out.write("                <label for=\"keuzeLuchthaven\">Ik wil zoeken op:</label>\r\n");
      out.write("                <select name =\"keuzeLuchthaven\" id=\"selectBoxID\" onchange=\"changeFunction();\">\r\n");
      out.write("                    <option value=\"0\">---Maak hier je keuze---</option>\r\n");
      out.write("                    <option value=\"vertrek\">Luchthaven van vertrek</option>\r\n");
      out.write("                    <option value=\"aankomst\">Luchthaven van aankomst</option>\r\n");
      out.write("                    <option value=\"maatschappij\">Luchtvaartmaatschappij</option>\r\n");
      out.write("                </select>\r\n");
      out.write("            </p>\r\n");
      out.write("\r\n");
      out.write("            <!-- moet nog aangepast worden, dit is nog niet werkende, we moeten kunnen gebruik maken van de function? -->\r\n");
      out.write("            ");
if (lijstAlleLuchthavens != null) {
      out.write("\r\n");
      out.write("            <p> <!-- We gebruiken de value van de geslecteerde luchthaven voor zowel de methode van binnenkomende vluchten als vertrekkende vluchten in de zoekServlet -->\r\n");
      out.write("                <label for=\"naamLuchthaven\">Naam luchthaven:</label>\r\n");
      out.write("                <select name =\"naamLuchthaven\">\r\n");
      out.write("                    <option value=\"0\">---Kies hier je luchthaven---</option>\r\n");
      out.write("                    ");
 for (Luchthaven luchthaven : lijstAlleLuchthavens) {
      out.write("\r\n");
      out.write("                    <option value=\"");
      out.print(luchthaven.getId());
      out.write('"');
      out.write('>');
      out.print(luchthaven.getLuchthavennaam());
      out.write(',');
      out.write(' ');
      out.print(luchthaven.getLand().getLandnaam());
      out.write(" </option>\r\n");
      out.write("                    ");
}
      out.write("\r\n");
      out.write("                </select>\r\n");
      out.write("            </p>\r\n");
      out.write("            ");
}
            
            if (lijstAlleLuchtvaartmaatschappijen != null) {
      out.write(" \r\n");
      out.write("            \r\n");
      out.write("            <p>\r\n");
      out.write("                <label for=\"naamMaatschappij\">Naam luchtvaartmaatschappij:</label>\r\n");
      out.write("                <select name=\"naamMaatschappij\">\r\n");
      out.write("                    ");
 for (Luchtvaartmaatschappij maatschappij : lijstAlleLuchtvaartmaatschappijen) {
      out.write("\r\n");
      out.write("                    <option value=\"");
      out.print(maatschappij.getId());
      out.write('"');
      out.write('>');
      out.print(maatschappij.getLuchtvaartnaam());
      out.write("</option>\r\n");
      out.write("                    ");
}
      out.write("\r\n");
      out.write("                </select>\r\n");
      out.write("            </p>\r\n");
      out.write("            ");
}
      out.write("\r\n");
      out.write("            <input type=\"submit\" value=\"Zoeken\" name=\"ZoekKnop\"/>\r\n");
      out.write("        </form> \r\n");
      out.write("\r\n");
      out.write("        <form action=\"ZoekServlet\">\r\n");
      out.write("            <p>\r\n");
      out.write("                <label>Geef datum in de volgende formaat yyyy-mm-dd:</label>\r\n");
      out.write("                <input type=\"text\" name=\"datum\">\r\n");
      out.write("                <input type=\"submit\" value=\"ZoekenDatum\" name=\"ZoekDatumKnop\"/>\r\n");
      out.write("            </p>\r\n");
      out.write("        </form>   \r\n");
      out.write("            \r\n");
      out.write("        <form action=\"ZoekServlet\">\r\n");
      out.write("            <p>\r\n");
      out.write("                <label>Geef vluchtnummer in om op vluchtnummer te zoeken:</label>\r\n");
      out.write("                <input type=\"text\" name=\"code\">\r\n");
      out.write("                <input type=\"submit\" value=\"ZoekenCode\" name=\"ZoekCodeKnop\"/>\r\n");
      out.write("            </p>\r\n");
      out.write("        </form>        \r\n");
      out.write("\r\n");
      out.write("        <form action=\"InlogServlet\">\r\n");
      out.write("            <!-- Zet dit er bij voor een de naam van de gebruiker en een inlog of uitlog button te hebben : -->\r\n");
      out.write("\r\n");
      out.write("            ");
Persoon persoon = (Persoon) session.getAttribute("persoon");
                if (persoon != null) {
      out.write("\r\n");
      out.write("            <P>\r\n");
      out.write("                <label name=\"naam\">");
      out.print(persoon.getVoornaam());
      out.write("</label>\r\n");
      out.write("                <label name=\"famillienaam\">");
      out.print(persoon.getFamilienaam());
      out.write("</label>\r\n");
      out.write("            </p>\r\n");
      out.write("            <input type=\"submit\" value=\"Uitloggen\" name=\"UitlogKnop\"/>\r\n");
      out.write("            ");
} else {
      out.write("\r\n");
      out.write("            <input type=\"submit\" value=\"Inloggen\" name=\"InlogKnop\"/>\r\n");
      out.write("            ");
}
      out.write("\r\n");
      out.write("        </form>    \r\n");
      out.write("\r\n");
      out.write("        <p>  <a href=\"index.jsp\">Terug naar beginpagina</a></p>\r\n");
      out.write("    </body>\r\n");
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
