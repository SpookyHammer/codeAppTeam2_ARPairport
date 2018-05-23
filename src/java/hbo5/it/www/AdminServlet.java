/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www;

import hbo5.it.www.beans.Bemanningslid;
import hbo5.it.www.beans.Functie;
import hbo5.it.www.beans.Luchtvaartmaatschappij;
import hbo5.it.www.dataaccess.DABemanningslid;
import hbo5.it.www.dataaccess.DAFunctie;
import hbo5.it.www.dataaccess.DALuchtvaartmaatschappij;
import hbo5.it.www.dataaccess.DAPersoon;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author c1045286
 */
@WebServlet(name = "AdminServlet", urlPatterns = {"/AdminServlet"}, initParams = {
    @WebInitParam(name = "url", value = "jdbc:oracle:thin:@ti-oracledb06.thomasmore.be:1521:XE")
    , @WebInitParam(name = "login", value = "c1043194")
    , @WebInitParam(name = "password", value = "1234")
    , @WebInitParam(name = "driver", value = "oracle.jdbc.driver.OracleDriver")})
public class AdminServlet extends HttpServlet {

    private DABemanningslid dabemanningslid = null;
    private DALuchtvaartmaatschappij daluchtvaartmaatschappij = null;
    private DAFunctie dafunctie = null;

    @Override
    public void init() throws ServletException {
        try {
            String url = getInitParameter("url");
            String password = getInitParameter("password");
            String login = getInitParameter("login");
            String driver = getInitParameter("driver");
            if (dabemanningslid == null) {
                dabemanningslid = new DABemanningslid(url, login, password, driver);
            }
            if (daluchtvaartmaatschappij == null) {
                daluchtvaartmaatschappij = new DALuchtvaartmaatschappij(url, login, password, driver);
            }
            if (dafunctie == null) {
                dafunctie = new DAFunctie(url, login, password, driver);
            }
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        }
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher rd = null;
        HttpSession session = request.getSession();
        
        if (request.getParameter("OpenBeheerbemanning") != null) {
            ArrayList<Bemanningslid> lijstalleBemanningsleden = dabemanningslid.getBemanningsleden();
            request.setAttribute("lijstalleBemanningsleden", lijstalleBemanningsleden);

            rd = request.getRequestDispatcher("beheerBemanning.jsp");
        }
        if(request.getParameter("AanpasKnop") != null)
        {
            ArrayList<Luchtvaartmaatschappij> lijstAlleLuchtvaartmaatschappijen = daluchtvaartmaatschappij.getAlleLuchtvaartmaatschappijen();
            request.setAttribute("lijstAlleLuchtvaartmaatschappijen", lijstAlleLuchtvaartmaatschappijen);
            ArrayList<Functie> lijstAlleFuncties = dafunctie.getFuncties();
            request.setAttribute("lijstAlleFuncties", lijstAlleFuncties);
            dabemanningslid.updateBemanningslid(request.getParameter("Id"), request.getParameter("functies"), request.getParameter("maatschappij"));
            ArrayList<Bemanningslid> lijstalleBemanningsleden = dabemanningslid.getBemanningsleden();
            request.setAttribute("lijstalleBemanningsleden", lijstalleBemanningsleden);

            rd = request.getRequestDispatcher("beheerBemanning.jsp");
            
        }
        
        if(request.getParameter("actie") != null)
        {
            if(request.getParameter("actie").equals("aanpassen") )
            {
                Bemanningslid bemanningslid = dabemanningslid.getBemanningslid(request.getParameter("Id"));
                request.setAttribute("bemanningslid", bemanningslid);
        
                rd = request.getRequestDispatcher("aanpassenBemanning.jsp");
            }
            if(request.getParameter("actie") == "verwijderen" )
            {
                dabemanningslid.DeleteBemanningslid(request.getParameter("Id"));
                //Check of hij nog ergens aan verbonden is.
        
                ArrayList<Bemanningslid> lijstalleBemanningsleden = dabemanningslid.getBemanningsleden();
                request.setAttribute("lijstalleBemanningsleden", lijstalleBemanningsleden);
                rd = request.getRequestDispatcher("beheerBemanning.jsp");
            }
        }
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
