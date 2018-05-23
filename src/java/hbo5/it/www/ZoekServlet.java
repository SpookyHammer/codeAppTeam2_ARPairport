package hbo5.it.www;

/*
Team: 2
Groepsleden: Cools Jasper, Gostek Kaân, Leysen Eline, Winkelmans Quinten


 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import hbo5.it.www.beans.Luchthaven;
import hbo5.it.www.beans.Luchtvaartmaatschappij;
import hbo5.it.www.beans.Vlucht;
import hbo5.it.www.dataaccess.DALuchthaven;
import hbo5.it.www.dataaccess.DALuchtvaartmaatschappij;
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

/**
 *
 * @author c1043194
 */
@WebServlet(urlPatterns = {"/ZoekServlet"}, initParams = {
    @WebInitParam(name = "url", value = "jdbc:oracle:thin:@ti-oracledb06.thomasmore.be:1521:XE")
    , @WebInitParam(name = "login", value = "c1043194")
    , @WebInitParam(name = "password", value = "1234")
    , @WebInitParam(name = "driver", value = "oracle.jdbc.driver.OracleDriver")})
public class ZoekServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private DAVlucht davlucht = null;
    private DALuchthaven daluchthaven = null;
    private DALuchtvaartmaatschappij daluchtvaartmaatschappij = null;

    @Override
    public void init() throws ServletException {
        try {
            String url = getInitParameter("url");
            String password = getInitParameter("password");
            String login = getInitParameter("login");
            String driver = getInitParameter("driver");
            if (davlucht == null) {
                davlucht = new DAVlucht(url, login, password, driver);
            }
            if (daluchthaven == null) {
                daluchthaven = new DALuchthaven(url, login, password, driver);
            }
            if (daluchtvaartmaatschappij == null) {
                daluchtvaartmaatschappij = new DALuchtvaartmaatschappij(url, login, password, driver);
            }
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = null;

           if (request.getParameter("OpenZoekpagina") != null) {
            ArrayList<Luchthaven> lijstAlleLuchthavens = daluchthaven.getAlleLuchthavens();
            ArrayList<Luchtvaartmaatschappij> lijstAlleLuchtvaartmaatschappijen = daluchtvaartmaatschappij.getAlleLuchtvaartmaatschappijen();
            request.setAttribute("lijstAlleLuchthavens", lijstAlleLuchthavens);
            request.setAttribute("lijstAlleLuchtvaartmaatschappijen", lijstAlleLuchtvaartmaatschappijen);
            rd = request.getRequestDispatcher("vluchtenZoeken.jsp");
        }

        if (request.getParameter("ZoekKnop") != null) {
            if (request.getParameter("naamLuchthaven") != null) {
                int luchthavenID = Integer.parseInt(request.getParameter("naamLuchthaven"));
                String keuzeLuchthaven = request.getParameter("keuzeLuchthaven");

                if (request.getParameter("keuzeLuchthaven").equals("aankomst")) {
                    ArrayList<Vlucht> lijstAlleBinnenkomendeVluchten = davlucht.getAlleBinnenkomendeVluchten(luchthavenID);

                    if (lijstAlleBinnenkomendeVluchten.size() > 0) {
                        request.setAttribute("lijstAlleBinnenkomendeVluchten", lijstAlleBinnenkomendeVluchten);
                        rd = request.getRequestDispatcher("overzichtVluchten.jsp");
                    } else {
                        String foutmelding = "Geen vluchten gevonden.";
                        request.setAttribute("foutmelding", foutmelding);
                        rd = request.getRequestDispatcher("fout.jsp");
                    }

                } else if (request.getParameter("keuzeLuchthaven").equals("vertrek")) {
                    ArrayList<Vlucht> lijstAlleVertrekkendeVluchten = davlucht.getAlleVertrekkendeVluchten(luchthavenID);

                    if (lijstAlleVertrekkendeVluchten.size() > 0) {
                        request.setAttribute("lijstAlleVertrekkendeVluchten", lijstAlleVertrekkendeVluchten);
                        rd = request.getRequestDispatcher("overzichtVluchten.jsp");
                    } else {
                        String foutmelding = "Geen vluchten gevonden.";
                        request.setAttribute("foutmelding", foutmelding);
                        rd = request.getRequestDispatcher("fout.jsp");
                    }

                } else if (request.getParameter("keuzeLuchthaven").equals("maatschappij")) {
                    int id = Integer.parseInt(request.getParameter("naamMaatschappij"));
                    ArrayList<Vlucht> lijstAlleVluchtenLuchtvaartmaatschappij = davlucht.getVluchtenByLuchtvaartmaatschappij(id);
                    if (lijstAlleVluchtenLuchtvaartmaatschappij.size() > 0) {
                        request.setAttribute("lijstAlleVluchtenLuchtvaartmaatschappij", lijstAlleVluchtenLuchtvaartmaatschappij);
                        rd = request.getRequestDispatcher("overzichtVluchten.jsp");
                    } else {
                        String foutmelding = "Geen vluchten gevonden.";
                        request.setAttribute("foutmelding", foutmelding);
                        rd = request.getRequestDispatcher("fout.jsp");
                    }
                }
            }
        } else if (request.getParameter("ZoekCodeKnop") != null) {
            if (request.getParameter("code") != null) {
                String vluchtnummer = request.getParameter("code");
                Vlucht vlucht = davlucht.getVluchtByNumber(vluchtnummer);
                if (vlucht != null) {
                    request.setAttribute("vlucht", vlucht);
                    // moet later veranderd worden in detail pagina
                    rd = request.getRequestDispatcher("detailVlucht.jsp");
                } else {
                    String foutmelding = "Vluchtnummer is niet valide.";
                    request.setAttribute("foutmelding", foutmelding);
                    rd = request.getRequestDispatcher("fout.jsp");
                }
            }

        } else if (request.getParameter("ZoekDatumKnop") != null) {
            if (request.getParameter("datum") != null) {
                String datumString = request.getParameter("datum");
                ArrayList<Vlucht> vluchtenDatum = davlucht.getAlleVluchtenByDate(datumString);
                if (vluchtenDatum != null) {
                    request.setAttribute("vluchtenDatum", vluchtenDatum);
                    rd = request.getRequestDispatcher("overzichtVluchten.jsp");
                } else {
                    String foutmelding = "Geen vluchten geboekt op die datum.";
                    request.setAttribute("foutmelding", foutmelding);
                    rd = request.getRequestDispatcher("fout.jsp");
                }
            } else {
                String foutmelding = "Ongeldige zoekactie.";
                request.setAttribute("foutmelding", foutmelding);
                rd = request.getRequestDispatcher("fout.jsp");
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
