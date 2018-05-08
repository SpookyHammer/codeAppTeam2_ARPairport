package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import hbo5.it.www.beans.Persoon;

public final class registratie_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>JSP Page</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <h1>Registratie</h1>\r\n");
      out.write("        \r\n");
      out.write("        <form action=\"InlogServlet\">\r\n");
      out.write("            <label>Username: </label> <input type=\"text\" name=\"username\"></input><br/>\r\n");
      out.write("            <label>Paswoord: </label> <input type=\"text\" name=\"username\"></input><br/>\r\n");
      out.write("            <label>Voornaam: </label> <input type=\"text\" name=\"username\"></input><br/>\r\n");
      out.write("            <label>Familienaam: </label> <input type=\"text\" name=\"username\"></input><br/>\r\n");
      out.write("            <label>Straat: </label> <input type=\"text\" name=\"username\"></input><br/>\r\n");
      out.write("            <label>Huisnr: </label> <input type=\"text\" name=\"username\"></input><br/>\r\n");
      out.write("            <label>Postcode: </label> <input type=\"text\" name=\"username\"></input><br/>\r\n");
      out.write("            <label>Woonplaats: </label> <input type=\"text\" name=\"username\"></input><br/>\r\n");
      out.write("            <label>Land: </label> <input type=\"text\" name=\"username\"></input><br/>\r\n");
      out.write("            <label>Geboortedatum: </label> <input type=\"text\" name=\"username\"></input><br/>\r\n");
      out.write("            \r\n");
      out.write("            <input type=\"submit\" value=\"registreren\" Name=\"RegistratieKnop\"></input>\r\n");
      out.write("        </form>\r\n");
      out.write("        \r\n");
      out.write("         <form action=\"InlogServlet\">\r\n");
      out.write("             <!-- Zet dit er bij voor een de naam van de gebruiker en een inlog of uitlog button te hebben : -->\r\n");
      out.write("            ");
Persoon persoon = (Persoon) request.getAttribute("persoon");
            if(persoon != null){
      out.write("\r\n");
      out.write("            <P>\r\n");
      out.write("                <label name=\"naam\">");
      out.print(persoon.getVoornaam() );
      out.write("</label>\r\n");
      out.write("                <label name=\"famillienaam\">");
      out.print(persoon.getFamilienaam() );
      out.write("</label>\r\n");
      out.write("            </p>\r\n");
      out.write("            <input type=\"submit\" value=\"Uitloggen\" name=\"UitlogKnop\"/>\r\n");
      out.write("           ");
} else {
      out.write("\r\n");
      out.write("            <input type=\"submit\" value=\"Inloggen\" name=\"InlogKnop\"/>\r\n");
      out.write("            ");
}
      out.write("\r\n");
      out.write("        </form>               \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("    </body>\r\n");
      out.write("</html>");
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
