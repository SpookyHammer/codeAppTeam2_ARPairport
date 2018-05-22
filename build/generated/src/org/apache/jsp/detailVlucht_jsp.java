package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import hbo5.it.www.beans.Vlucht;

public final class detailVlucht_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Detail pagina</title>\n");
      out.write("        <style>\n");
      out.write("            tr{\n");
      out.write("                padding: 10px;\n");
      out.write("            }\n");
      out.write("            td{\n");
      out.write("                padding-right: 20px;\n");
      out.write("                padding-bottom: 5px;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
 Vlucht vlucht = (Vlucht)request.getAttribute("vlucht"); 
      out.write("\n");
      out.write("        <h1>Vlucht Detail</h1>\n");
      out.write("        <table>\n");
      out.write("            <tr>\n");
      out.write("                <td>Vlucht code:</td>\n");
      out.write("                <td>");
      out.print(vlucht.getCode() );
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>Vertrek gegevens:</td>\n");
      out.write("                <td>\n");
      out.write("                    <table>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>vertrek datum en tijd</td>\n");
      out.write("                            <td>");
      out.print(vlucht.getVertrektijd());
      out.write("</td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Vertrek Luchthaven</td>\n");
      out.write("                            <td>");
      out.print(vlucht.getVertrekluchthaven().getLuchthavennaam());
      out.write("</td>\n");
      out.write("                            <td>(");
      out.print(vlucht.getVertrekluchthaven().getStad());
      out.write(" - ");
      out.print(vlucht.getVertrekluchthaven().getLand().getLandnaam());
      out.write(")</td>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>Aankomst gegevens:</td>\n");
      out.write("                <td>\n");
      out.write("                    <table>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Aankomst datum en tijd:</td>\n");
      out.write("                            <td>");
      out.print(vlucht.getAankomsttijd());
      out.write("</td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Aankomst Luchthaven</td>\n");
      out.write("                            <td>");
      out.print(vlucht.getAankomstluchthaven().getLuchthavennaam());
      out.write("</td> \n");
      out.write("                            <td>(");
      out.print(vlucht.getAankomstluchthaven().getStad());
      out.write(" - ");
      out.print(vlucht.getAankomstluchthaven().getLand().getLandnaam());
      out.write(")</td>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("        <h1>Vliegtuig</h1>\n");
      out.write("        <table>\n");
      out.write("            <tr>\n");
      out.write("                <td>Luchtvaartmaatschappij</td>\n");
      out.write("                <td>");
      out.print(vlucht.getVliegtuig().getLuchtvaartmaatschappij().getLuchtvaartnaam() );
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>Type vliegtuig</td>\n");
      out.write("                <td>");
      out.print(vlucht.getVliegtuig().getVliegtuigtype().getTypenaam() );
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
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
