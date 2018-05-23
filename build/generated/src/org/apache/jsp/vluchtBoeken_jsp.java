package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import hbo5.it.www.beans.Passagier;
import hbo5.it.www.beans.Vliegtuigklasse;
import java.util.ArrayList;
import hbo5.it.www.beans.Persoon;
import hbo5.it.www.beans.Vlucht;

public final class vluchtBoeken_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Vlucht boeken</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");
Vlucht vlucht = (Vlucht) request.getAttribute("vlucht");
      out.write("\r\n");
      out.write("        ");
Persoon persoon = (Persoon) session.getAttribute("persoon");
      out.write("\r\n");
      out.write("        ");
ArrayList<Vliegtuigklasse> lijstVliegtuigklasses = (ArrayList<Vliegtuigklasse>) request.getAttribute("lijstVliegtuigklasses");
      out.write("\r\n");
      out.write("        ");
ArrayList<Passagier> lijstPassagiers = (ArrayList<Passagier>) request.getAttribute("lijstPassagiers");
      out.write("\r\n");
      out.write("        ");
ArrayList<String> lijstPlaatsen = (ArrayList<String>) request.getAttribute("lijstPlaatsen");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <h1>Boek hier uw vlucht naar ");
      out.print(vlucht.getAankomstluchthaven().getLuchthavennaam());
      out.write(',');
      out.write(' ');
vlucht.getAankomstluchthaven().getLand().getLandnaam();
      out.write("</h1>\r\n");
      out.write("\r\n");
      out.write("        <form>\r\n");
      out.write("            <input type=\"hidden\" value=\"");
      out.print(vlucht.getCode());
      out.write("\"/>\r\n");
      out.write("            <p>\r\n");
      out.write("                <label>Luchthaven van vertrek:</label>\r\n");
      out.write("                <input type=\"text\" value=\"");
      out.print(vlucht.getVertrekluchthaven().getLuchthavennaam());
      out.write("\" readonly/>\r\n");
      out.write("            </p>\r\n");
      out.write("            <p>\r\n");
      out.write("                <label>Luchthaven van aankomst:</label>\r\n");
      out.write("                <input type=\"text\" value=\"");
      out.print(vlucht.getAankomstluchthaven().getLuchthavennaam());
      out.write("\" readonly/>\r\n");
      out.write("            </p>\r\n");
      out.write("            <p>\r\n");
      out.write("                <label>Datum van vertrek:</label>\r\n");
      out.write("                <input type=\"text\" value=\"");
      out.print(vlucht.getVertrektijd().toString());
      out.write("\" readonly/>\r\n");
      out.write("            </p>\r\n");
      out.write("            <p>\r\n");
      out.write("                <label>Datum van aankomst:</label>\r\n");
      out.write("                <input type=\"text\" value=\"");
      out.print(vlucht.getAankomsttijd().toString());
      out.write("\" readonly/>\r\n");
      out.write("            </p>\r\n");
      out.write("            <p>\r\n");
      out.write("                <label>Naam:</label>\r\n");
      out.write("                <input type=\"text\" value=\"");
      out.print(persoon.getFamilienaam());
      out.write(' ');
      out.print(persoon.getVoornaam());
      out.write("\" readonly/>\r\n");
      out.write("            </p>\r\n");
      out.write("            <p>\r\n");
      out.write("                <label name =\"vliegtuigklasse\">Keuze vliegtuigklasse:</label>\r\n");
      out.write("                <select name =\"vliegtuigklasse\">\r\n");
      out.write("                    <option value=\"0\">---Kies hier uw klasse---</option>\r\n");
      out.write("                    ");
 for (Vliegtuigklasse vliegtuigklasse : lijstVliegtuigklasses) {
      out.write("\r\n");
      out.write("                    <option value=\"");
      out.print(vliegtuigklasse.getId());
      out.write('"');
      out.write('>');
      out.print(vliegtuigklasse.getKlassenaam());
      out.write(" </option>\r\n");
      out.write("                    ");
}
      out.write("\r\n");
      out.write("                </select>\r\n");
      out.write("            </p>\r\n");
      out.write("            <p>\r\n");
      out.write("                <label>Selecteer uw zitplaats</label>\r\n");
      out.write("                ");
for (Passagier passagier : lijstPassagiers) {
                    for (int i = 0; i < lijstPlaatsen.size(); i++) {
                        if (passagier.getPlaats().equals(lijstPlaatsen.get(i))) {
                                lijstPlaatsen.remove(i);   
                                }
                        }                  
                }
      out.write("\r\n");
      out.write("                <select name=\"zitplaats\">\r\n");
      out.write("                    <option value=\"0\">---Kies hier uw zitplaats---</option>\r\n");
      out.write("                    ");
 for (String plaats : lijstPlaatsen) {
      out.write("\r\n");
      out.write("                    <option value=\"");
      out.print(plaats);
      out.write('"');
      out.write('>');
      out.print(plaats);
      out.write("</option>\r\n");
      out.write("                ");
}
      out.write("\r\n");
      out.write("                </select>\r\n");
      out.write("            </p>\r\n");
      out.write("            \r\n");
      out.write("            <p>\r\n");
      out.write("                <input type=\"submit\" name=\"registreerGeboekteVlucht\" value=\"Boek deze vlucht\"/>\r\n");
      out.write("            </p>\r\n");
      out.write("        </form>\r\n");
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
