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
import java.util.Arrays;
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
            ArrayList<Passagier> lijstPassagiers = dapassagier.getPassagiersByVlucht(vluchtCode);
            ArrayList<String> lijstPlaatsen = new ArrayList<String>();
            lijstPlaatsen.addAll(Arrays.asList("A01","A02","A03","A04","A05","A06","A07","A08","A09","A10","A11","A12",
                    "B01","B02","B03","B04","B05","B06","B07","B08","B09","B10","B11","B12",
                    "C01","C02","C03","C04","C05","C06","C07","C08","C09","C10","C11","C12",
                    "D01","D02","D03","D04","D05","D06","D07","D08","D09","D10","D11","D12",
                    "E01","E02","E03","E04","E05","E06","E07","E08","E09","E10","E11","E12",
                    "F01","F02","F03","F04","F05","F06","F07","F08","F09","F10","F11","F12",
                    "G01","G02","G03","G04","G05","G06","G07","G08","G09","G10","G11","G12",
                    "H01","H02","H03","H04","H05","H06","H07","H08","H09","H10","H11","H12",
                    "I01","I02","I03","I04","I05","I06","I07","I08","I09","I10","I11","I12",
                    "J01","J02","J03","J04","J05","J06","J07","J08","J09","J10","J11","J12",
                    "K01","K02","K03","K04","K05","K06","K07","K08","K09","K10","K11","K12"));
            if (vlucht != null) {
                request.setAttribute("vlucht", vlucht);
                request.setAttribute("lijstVliegtuigklasses", lijstVliegtuigklasses);
                request.setAttribute("lijstPassagiers", lijstPassagiers);
                request.setAttribute("lijstPlaatsen", lijstPlaatsen);
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
            Persoon persoon = (Persoon) session.getAttribute("persoon");
            int id = persoon.getId();
            ArrayList<Vlucht> lijstVluchten = davlucht.getAlleVluchtenVanPassagier(id);
            request.setAttribute("lijstVluchten", lijstVluchten);
            rd = request.getRequestDispatcher("geboekteVluchten.jsp");
        }
        if (request.getParameter("knopPassagierslijstZoeken") != null) {
            String vluchtCode = request.getParameter("knopPassagierslijstZoeken");
            ArrayList<Passagier> lijstPassagieren = dapassagier.getPassagiersByVlucht(vluchtCode);
            if (lijstPassagieren != null) {
                request.setAttribute("lijstPassagieren", lijstPassagieren);
                rd = request.getRequestDispatcher("passagierslijst.jsp");
            }
        }
        if (request.getParameter("registreerGeboekteVlucht") != null) {
            Persoon persoon = (Persoon) session.getAttribute("persoon");
            //nog niet volledig
            
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
