package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import hbo5.it.www.beans.Persoon;

public final class adminbeheer_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form action=\"AdminServlet\">\n");
      out.write("            <input type=\"submit\" value=\"Beheren luchthavens\" name=\"OpenBeheerluchthavens\"/>\n");
      out.write("            <input type=\"submit\" value=\"Beheren luchtvaartmaatschappijen\" name=\"OpenBeheerluchtvaartmaatschappijen\"/>\n");
      out.write("            <input type=\"submit\" value=\"Beheren vliegtuigen\" name=\"OpenBeheervliegtuigen\"/>\n");
      out.write("            <input type=\"submit\" value=\"Beheren hangars\" name=\"OpenBeheerhangars\"/>\n");
      out.write("            <input type=\"submit\" value=\"Beheren bemanning\" name=\"OpenBeheerbemanning\"/>\n");
      out.write("            <input type=\"submit\" value=\"Beheren vluchtbemanning\" name=\"OpenBeheervluchtbemanning\"/>\n");
      out.write("            <input type=\"submit\" value=\"Beheren vliegtuigen in hangars\" name=\"OpenBeheervliegtuigeninhangars\"/>\n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("        <form action=\"InlogServlet\">\n");
      out.write("             <!-- Zet dit er bij voor een de naam van de gebruiker en een inlog of uitlog button te hebben : -->\n");
      out.write("            \n");
      out.write("            ");
Persoon persoon = (Persoon) session.getAttribute("persoon");
            if(persoon != null){
      out.write("\n");
      out.write("            <P>\n");
      out.write("                <label name=\"naam\">");
      out.print(persoon.getVoornaam() );
      out.write("</label>\n");
      out.write("                <label name=\"famillienaam\">");
      out.print(persoon.getFamilienaam() );
      out.write("</label>\n");
      out.write("            </p>\n");
      out.write("            <input type=\"submit\" value=\"Uitloggen\" name=\"UitlogKnop\"/>\n");
      out.write("           ");
} else {
      out.write("\n");
      out.write("            <input type=\"submit\" value=\"Inloggen\" name=\"InlogKnop\"/>\n");
      out.write("            ");
}
      out.write("\n");
      out.write("        </form> \n");
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
