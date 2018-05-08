/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www;

import hbo5.it.www.beans.Persoon;
import hbo5.it.www.dataaccess.DAPersoon;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author c1045286
 */
@WebServlet(name = "InlogServlet", urlPatterns = {"/InlogServlet"}, initParams = {
    @WebInitParam(name = "url", value = "jdbc:oracle:thin:@ti-oracledb06.thomasmore.be:1521:XE")
    , @WebInitParam(name = "login", value = "c1043194")
    , @WebInitParam(name = "password", value = "1234")
    , @WebInitParam(name = "driver", value = "oracle.jdbc.driver.OracleDriver")})
public class InlogServlet extends HttpServlet {

    private DAPersoon dapersoon = null;

    @Override
    public void init() throws ServletException {
        try {
            String url = getInitParameter("url");
            String password = getInitParameter("password");
            String login = getInitParameter("login");
            String driver = getInitParameter("driver");
            if (dapersoon == null) {
                dapersoon = new DAPersoon(url, login, password, driver);
            }
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = null;

        if (request.getParameter("InlogKnop") != null) {
            rd = request.getRequestDispatcher("inloggen.jsp");
        }
        if (request.getParameter("LoginKnop") != null) {
//        String Login = request.getParameter("Logintext");
//        String Passwoord = request.getParameter("Passwordtext");
            Persoon persoon = dapersoon.GetPersoon(request.getParameter("Logintext"), request.getParameter("Passwordtext"));
            if (persoon != null) {
                request.setAttribute("persoon", persoon);
                rd = request.getRequestDispatcher("index.jsp");
            } else {
                rd = request.getRequestDispatcher("Fout.jsp");
            }
        }
        if (request.getParameter("UitlogKnop") != null) {
            Persoon persoon = null;
            rd = request.getRequestDispatcher("index.jsp");
        }

        if (request.getParameter("RegistratieKnop") != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            /* Je moet hier wel het formaat nemen van je eigen datum */
            java.util.Date parsed = null;
            if (request.getParameter("geboortedatum") == null) {
                rd = request.getRequestDispatcher("fout.jsp");
            } else {
                try {
                    parsed = sdf.parse(request.getParameter("geboortedatum").toString());
                } catch (ParseException e) {
                    rd = request.getRequestDispatcher("fout.jsp");
                    rd.forward(request, response);
                }

                java.sql.Date datum = new java.sql.Date(parsed.getTime());
                String voornaam = request.getParameter("voornaam");
                if (dapersoon.InsertPersoon(voornaam, request.getParameter("familienaam"), request.getParameter("straat"), request.getParameter("huisnr"),
                        request.getParameter("postcode"), request.getParameter("woonplaats"), request.getParameter("land"), datum, request.getParameter("username"),
                        request.getParameter("paswoord"))) {
                    request.setAttribute("voornaam", voornaam);
                    rd = request.getRequestDispatcher("registratieGeslaagd.jsp");
                } else {
                    rd = request.getRequestDispatcher("fout.jsp");
                }
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
