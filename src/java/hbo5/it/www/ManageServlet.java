/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www;

import hbo5.it.www.beans.Passagier;
import hbo5.it.www.beans.Persoon;
import hbo5.it.www.beans.Vliegtuigklasse;
import hbo5.it.www.beans.Vlucht;
import hbo5.it.www.dataaccess.DAPassagier;
import hbo5.it.www.dataaccess.DAVliegtuigklasse;
import hbo5.it.www.dataaccess.DAVlucht;
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
 * @author Eline
 */
@WebServlet(name = "ManageServlet", urlPatterns = {"/ManageServlet"}, initParams = {
    @WebInitParam(name = "url", value = "jdbc:oracle:thin:@ti-oracledb06.thomasmore.be:1521:XE")
    , @WebInitParam(name = "login", value = "c1043194")
    , @WebInitParam(name = "password", value = "1234")
    , @WebInitParam(name = "driver", value = "oracle.jdbc.driver.OracleDriver")})
public class ManageServlet extends HttpServlet {

    private DAPassagier dapassagier = null;
    private DAVlucht davlucht = null;
    private DAVliegtuigklasse davliegtuigklasse = null;

    @Override
    public void init() throws ServletException {
        try {
            String url = getInitParameter("url");
            String password = getInitParameter("password");
            String login = getInitParameter("login");
            String driver = getInitParameter("driver");
            if (dapassagier == null) {
                dapassagier = new DAPassagier(url, login, password, driver);
            }
            if (davlucht == null) {
                davlucht = new DAVlucht(url, login, password, driver);
            }
            if (davliegtuigklasse == null) {
                davliegtuigklasse = new DAVliegtuigklasse(url, login, password, driver);
            }
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = null;
        HttpSession session = request.getSession();

        if (request.getParameter("knopVluchtBoeken") != null) {
            String vluchtCode = request.getParameter("knopVluchtBoeken");
            Vlucht vlucht = davlucht.getVluchtByNumber(vluchtCode);
            ArrayList<Vliegtuigklasse> lijstVliegtuigklasses = davliegtuigklasse.getAlleVliegtuigklasses();
            if (vlucht != null) {
                request.setAttribute("vlucht", vlucht);
                request.setAttribute("lijstVliegtuigklasses", lijstVliegtuigklasses);
                rd = request.getRequestDispatcher("vluchtBoeken.jsp");
            }
        }
        if (request.getParameter("knopPassagierslijst") != null) {
            String vluchtCode = request.getParameter("Vluchtnr");
            ArrayList<Passagier> lijstPassagieren = dapassagier.getPassagiersByVlucht(vluchtCode);
            if (lijstPassagieren != null) {
                request.setAttribute("lijstPassagieren", lijstPassagieren);
                rd = request.getRequestDispatcher("passagierslijst.jsp");
            }
        }
        if (request.getParameter("MijnVluchten") != null) {
            //Persoon persoon = (Persoon) session.getAttribute("persoon");
            //Vlucht vlucht = davlucht.getAlleVluchtenVanPassagier()
        }
        if (request.getParameter("knopPassagierslijstZoeken") != null) {
            String vluchtCode = request.getParameter("knopPassagierslijstZoeken");
            ArrayList<Passagier> lijstPassagieren = dapassagier.getPassagiersByVlucht(vluchtCode);
            if (lijstPassagieren != null) {
                request.setAttribute("lijstPassagieren", lijstPassagieren);
                rd = request.getRequestDispatcher("passagierslijst.jsp");
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
