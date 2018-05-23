package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import hbo5.it.www.beans.Vlucht;
import java.util.ArrayList;

public final class geboekteVluchten_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Mijn vluchten</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");
ArrayList<Vlucht> lijstVluchten = (ArrayList<Vlucht>) request.getAttribute("lijstVluchten");
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        <h1>Mijn vluchten</h1>\r\n");
      out.write("        \r\n");
      out.write("        <table border=\"1\" cellpadding=\"3\">\r\n");
      out.write("            <thead>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>Vluchtnummer:</td>\r\n");
      out.write("                    <td>Vertrek:</td>\r\n");
      out.write("                    <td>Aankomst:</td>\r\n");
      out.write("                    <td>Luchtvaartmaatschappij:</td>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </thead>\r\n");
      out.write("            <tbody>\r\n");
      out.write("                ");
if (lijstVluchten != null) {
                    for (Vlucht vlucht : lijstVluchten) 
                    {
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td> ");
      out.print(vlucht.getCode());
      out.write("</td>\r\n");
      out.write("                        <td> ");
      out.print(vlucht.getVertrekluchthaven().getLuchthavennaam());
      out.write(" <br/> ");
      out.print(vlucht.getAankomsttijd().toString());
      out.write(" </td>\r\n");
      out.write("                        <td> ");
      out.print(vlucht.getAankomstluchthaven().getLuchthavennaam());
      out.write(" <br/> ");
      out.print(vlucht.getVertrektijd().toString());
      out.write(" </td>\r\n");
      out.write("                        <td> ");
      out.print(vlucht.getVliegtuig().getLuchtvaartmaatschappij().getLuchtvaartnaam());
      out.write(" </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    ");
}}
      out.write("\r\n");
      out.write("            </tbody>\r\n");
      out.write("        </table>\r\n");
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
