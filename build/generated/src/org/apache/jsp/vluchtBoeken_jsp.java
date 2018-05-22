package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Vlucht boeken</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
Vlucht vlucht = (Vlucht) request.getAttribute("vlucht");
      out.write("\n");
      out.write("        ");
Persoon persoon = (Persoon) session.getAttribute("persoon");
      out.write("\n");
      out.write("        \n");
      out.write("        <h1>Boek hier uw vlucht naar ");
      out.print(vlucht.getAankomstluchthaven().getLuchthavennaam());
      out.write(',');
      out.write(' ');
vlucht.getAankomstluchthaven().getLand();
      out.write("</h1>\n");
      out.write("        \n");
      out.write("        <form>\n");
      out.write("            <p>\n");
      out.write("                <label>Luchthaven van vertrek:</label>\n");
      out.write("                <input type=\"text\" value=\"");
      out.print(vlucht.getVertrekluchthaven().getLuchthavennaam());
      out.write("\"/>\n");
      out.write("            </p>\n");
      out.write("            <p>\n");
      out.write("                <label>Luchthaven van aankomst:</label>\n");
      out.write("                <input type=\"text\" value=\"");
      out.print(vlucht.getAankomstluchthaven().getLuchthavennaam());
      out.write("\"/>\n");
      out.write("            </p>\n");
      out.write("            <p>\n");
      out.write("                <label>Datum van vertrek:</label>\n");
      out.write("                <input type=\"text\" value=\"");
      out.print(vlucht.getVertrektijd().toString());
      out.write("\"/>\n");
      out.write("            </p>\n");
      out.write("            <p>\n");
      out.write("                <label>Datum van aankomst:</label>\n");
      out.write("                <input type=\"text\" value=\"");
      out.print(vlucht.getAankomsttijd().toString());
      out.write("\"/>\n");
      out.write("            </p>\n");
      out.write("            <p>\n");
      out.write("                <label>Naam:</label>\n");
      out.write("                <input type=\"text\" value=\"");
      out.print(persoon.getFamilienaam());
      out.write(' ');
      out.print(persoon.getVoornaam());
      out.write("\"/>\n");
      out.write("            </p>\n");
      out.write("            <p>\n");
      out.write("                <label>Keuze vliegtuigklasse:</label>\n");
      out.write("                \n");
      out.write("            </p>\n");
      out.write("\n");
      out.write("               \n");
      out.write("            \n");
      out.write("            <p>\n");
      out.write("                <input type=\"submit\" name=\"\"/>\n");
      out.write("            </p>\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
