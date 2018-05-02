package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Vluchten zoeken</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");
ArrayList<Vlucht> lijstAlleBinnenkomendeVluchten = (ArrayList<Vlucht>) request.getAttribute("lijstAlleBinnenkomendeVluchten");
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        <h1>Zoek hier uw vlucht</h1>\r\n");
      out.write("        \r\n");
      out.write("        <form action=\"ZoekServlet\">\r\n");
      out.write("            <p>\r\n");
      out.write("                <label for=\"keuzeLuchthaven\">Ik wil zoeken op:</label>\r\n");
      out.write("                <select name =\"keuzeLuchthaven\">\r\n");
      out.write("                    <option value=\"0\">---Maak hier je keuze---</option>\r\n");
      out.write("                    <option value=\"vertrek\">Luchthaven van vertrek</option>\r\n");
      out.write("                    <option value=\"aankomst\">Luchthaven van aankomst</option>\r\n");
      out.write("                </select>\r\n");
      out.write("            </p>\r\n");
      out.write("            <p>\r\n");
      out.write("                <label for=\"naamLuchthaven\">Naam luchthaven:</label>\r\n");
      out.write("                <select name =\"naamLuchthaven\">\r\n");
      out.write("                    <option value=\"0\">---Kies hier je luchthaven---</option>\r\n");
      out.write("                    ");
 for (Vlucht vlucht : lijstAlleBinnenkomendeVluchten) {
      out.write("\r\n");
      out.write("                    <option value=\"");
      out.print(vlucht.getAankomstluchthaven_id() );
      out.write('"');
      out.write('>');
      out.print(vlucht.getAankomstluchthaven().getLuchthavennaam());
      out.write(" </option>\r\n");
      out.write("                    \r\n");
      out.write("                    <option value=\"2\">Luchthaven van vertrek</option>\r\n");
      out.write("                    ");
}
      out.write("\r\n");
      out.write("                </select>\r\n");
      out.write("            </p>\r\n");
      out.write("            \r\n");
      out.write("          \r\n");
      out.write("            <input type=\"submit\" value=\"Zoeken\" name=\"ZoekKnop\"/>\r\n");
      out.write("        </form>  \r\n");
      out.write("        \r\n");
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
