/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;

import hbo5.it.www.beans.Land;
import hbo5.it.www.beans.Luchthaven;
import hbo5.it.www.beans.Luchtvaartmaatschappij;
import hbo5.it.www.beans.Vliegtuig;
import hbo5.it.www.beans.Vliegtuigtype;
import hbo5.it.www.beans.Vlucht;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Set;

/**
 *
 * @author c1043194
 */
public class DAVlucht {
        private final String url, login, password;
    
    public DAVlucht (String url, String login, String password, String driver)   throws ClassNotFoundException {
        Class.forName(driver);
        this.url = url;
	this.login = login;
	this.password = password;
    }
     
     public ArrayList<Vlucht> getAlleBinnenkomendeVluchten(int id){
        ArrayList<Vlucht> lijstAlleVluchten = new ArrayList<>();
        Vlucht vlucht = null;
        
        try(
            Connection connection = DriverManager.getConnection(url, login, password);
            PreparedStatement statement = connection.prepareStatement( "SELECT * "
                    + "FROM vlucht "
                    + "INNER JOIN luchthaven luchthaven1 ON  vlucht.aankomstluchthaven_id = luchthaven1.id "
                    + "INNER JOIN land land1 ON land1.id = luchthaven1.land_id "
                    + "INNER JOIN luchthaven luchthaven2 ON  vlucht.vertrekluchthaven_id = luchthaven2.id " 
                    + "INNER JOIN land land2 ON land2.id = luchthaven2.land_id "
                    + "WHERE vlucht.aankomstluchthaven_id = ? "
                    + "AND vlucht.aankomsttijd >= SYSDATE");)
                
        {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {;
                vlucht = new Vlucht();
                vlucht.setId(resultSet.getInt("id"));
                vlucht.setCode(resultSet.getString("code"));
                vlucht.setVertrektijd(resultSet.getDate("vertrektijd"));
                vlucht.setAankomsttijd(resultSet.getDate("aankomsttijd"));
                vlucht.setVliegtuig_id(resultSet.getInt("vliegtuig_id"));
                
                
                Luchthaven aankomstluchthaven = new Luchthaven();
                aankomstluchthaven.setId(resultSet.getInt(8));
                aankomstluchthaven.setLuchthavennaam(resultSet.getString(9));
                aankomstluchthaven.setStad(resultSet.getString(10));
                aankomstluchthaven.setLand_id(resultSet.getInt(11));
                
                Luchthaven vertrekluchthaven = new Luchthaven();
                vertrekluchthaven.setId(resultSet.getInt(14));
                vertrekluchthaven.setLuchthavennaam(resultSet.getString(15));
                vertrekluchthaven.setStad(resultSet.getString(16));
                vertrekluchthaven.setLand_id(resultSet.getInt(17));      
                
                Land landAankomst = new Land();
                landAankomst.setId(resultSet.getInt(12));
                landAankomst.setLandnaam(resultSet.getString(13));
                
                aankomstluchthaven.setLand(landAankomst);
                vlucht.setAankomstluchthaven(aankomstluchthaven);
                
                Land landVertrek = new Land();
                landVertrek.setId(resultSet.getInt(18));
                landVertrek.setLandnaam(resultSet.getString(19));
                
                vertrekluchthaven.setLand(landVertrek);
                vlucht.setVertrekluchthaven(vertrekluchthaven);
               
                lijstAlleVluchten.add(vlucht);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    return lijstAlleVluchten;
    }       
     public ArrayList<Vlucht> getAlleVertrekkendeVluchten(int id){
        ArrayList<Vlucht> lijstAlleVluchten = new ArrayList<>();
        Vlucht vlucht = null;
        
        try(
            Connection connection = DriverManager.getConnection(url, login, password);
            PreparedStatement statement = connection.prepareStatement( "SELECT * "
                    + "FROM vlucht "
                    + "INNER JOIN luchthaven luchthaven1 ON  vlucht.aankomstluchthaven_id = luchthaven1.id "
                    + "INNER JOIN land land1 ON land1.id = luchthaven1.land_id "
                    + "INNER JOIN luchthaven luchthaven2 ON  vlucht.vertrekluchthaven_id = luchthaven2.id " 
                    + "INNER JOIN land land2 ON land2.id = luchthaven2.land_id "
                    + "WHERE vlucht.vertrekluchthaven_id = ? "
                    + "AND vlucht.vertrektijd >= SYSDATE");)
                
        {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {;
                vlucht = new Vlucht();
                vlucht.setId(resultSet.getInt("id"));
                vlucht.setCode(resultSet.getString("code"));
                vlucht.setVertrektijd(resultSet.getDate("vertrektijd"));
                vlucht.setAankomsttijd(resultSet.getDate("aankomsttijd"));
                vlucht.setVliegtuig_id(resultSet.getInt("vliegtuig_id"));
                
                
                Luchthaven aankomstluchthaven = new Luchthaven();
                aankomstluchthaven.setId(resultSet.getInt(8));
                aankomstluchthaven.setLuchthavennaam(resultSet.getString(9));
                aankomstluchthaven.setStad(resultSet.getString(10));
                aankomstluchthaven.setLand_id(resultSet.getInt(11));
                
                Luchthaven vertrekluchthaven = new Luchthaven();
                vertrekluchthaven.setId(resultSet.getInt(14));
                vertrekluchthaven.setLuchthavennaam(resultSet.getString(15));
                vertrekluchthaven.setStad(resultSet.getString(16));
                vertrekluchthaven.setLand_id(resultSet.getInt(17));      
                
                Land landAankomst = new Land();
                landAankomst.setId(resultSet.getInt(12));
                landAankomst.setLandnaam(resultSet.getString(13));
                
                aankomstluchthaven.setLand(landAankomst);
                vlucht.setAankomstluchthaven(aankomstluchthaven);
                
                Land landVertrek = new Land();
                landVertrek.setId(resultSet.getInt(18));
                landVertrek.setLandnaam(resultSet.getString(19));
                
                vertrekluchthaven.setLand(landVertrek);
                vlucht.setVertrekluchthaven(vertrekluchthaven);
                
                lijstAlleVluchten.add(vlucht);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    return lijstAlleVluchten;
    }

     public Vlucht getVluchtByNumber(String code){
        Vlucht vlucht = null;
        
        try(
            Connection connection = DriverManager.getConnection(url, login, password);
            PreparedStatement statement = connection.prepareStatement( "SELECT * "
                    + "FROM vlucht "
                    + "INNER JOIN luchthaven luchthaven1 ON  vlucht.aankomstluchthaven_id = luchthaven1.id "
                    + "INNER JOIN land land1 ON land1.id = luchthaven1.land_id "
                    + "INNER JOIN luchthaven luchthaven2 ON  vlucht.vertrekluchthaven_id = luchthaven2.id " 
                    + "INNER JOIN land land2 ON land2.id = luchthaven2.land_id "
                    + "INNER JOIN vliegtuig vliegtuig ON Vliegtuig.id = vlucht.VLIEGTUIG_ID "
                    + "INNER JOIN Luchtvaartmaatschappij luchtvaartmaatschappij  ON luchtvaartmaatschappij.id = vliegtuig.LUCHTVAARTMAATSCHAPPIJ_ID "
                    + "INNER JOIN vliegtuigtype vliegtuigtype ON vliegtuigtype.id = vliegtuig.VLIEGTUIGTYPE_ID "
                    + "WHERE vlucht.code LIKE ?");)
                
        {
            statement.setString(1, code);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {;
                vlucht = new Vlucht();
                vlucht.setId(resultSet.getInt("id"));
                vlucht.setCode(resultSet.getString("code"));
                vlucht.setVertrektijd(resultSet.getDate("vertrektijd"));
                vlucht.setAankomsttijd(resultSet.getDate("aankomsttijd"));
                vlucht.setVliegtuig_id(resultSet.getInt("vliegtuig_id"));
                
                
                Luchthaven aankomstluchthaven = new Luchthaven();
                aankomstluchthaven.setId(resultSet.getInt(8));
                aankomstluchthaven.setLuchthavennaam(resultSet.getString(9));
                aankomstluchthaven.setStad(resultSet.getString(10));
                aankomstluchthaven.setLand_id(resultSet.getInt(11));
                
                Luchthaven vertrekluchthaven = new Luchthaven();
                vertrekluchthaven.setId(resultSet.getInt(14));
                vertrekluchthaven.setLuchthavennaam(resultSet.getString(15));
                vertrekluchthaven.setStad(resultSet.getString(16));
                vertrekluchthaven.setLand_id(resultSet.getInt(17));      
                
                Land landAankomst = new Land();
                landAankomst.setId(resultSet.getInt(12));
                landAankomst.setLandnaam(resultSet.getString(13));
                
                aankomstluchthaven.setLand(landAankomst);
                vlucht.setAankomstluchthaven(aankomstluchthaven);
                
                Land landVertrek = new Land();
                landVertrek.setId(resultSet.getInt(18));
                landVertrek.setLandnaam(resultSet.getString(19));
                
                vertrekluchthaven.setLand(landVertrek);
                vlucht.setVertrekluchthaven(vertrekluchthaven);
                                
                Vliegtuig vliegtuig = new Vliegtuig();
                vliegtuig.setId(resultSet.getInt(20));
                vliegtuig.setVliegtuigtype_id(resultSet.getInt(21));
                vliegtuig.setLuchtvaartmaatschappij_id(resultSet.getInt(22));
                
                Luchtvaartmaatschappij lvms = new Luchtvaartmaatschappij();
                lvms.setId(resultSet.getInt(23));
                lvms.setLuchtvaartnaam(resultSet.getString(24));
                vliegtuig.setLuchtvaartmaatschappij(lvms);
                
                Vliegtuigtype vtt = new Vliegtuigtype();
                vtt.setId(resultSet.getInt(25));
                vtt.setTypenaam(resultSet.getString(26));
                vliegtuig.setVliegtuigtype(vtt);
                
                vlucht.setVliegtuig(vliegtuig);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    return vlucht;
    }
     
     
          public ArrayList<Vlucht> getAlleVluchtenByDate(String date){
        ArrayList<Vlucht> lijstAlleVluchten = new ArrayList<>();
        Vlucht vlucht = null;
        
        
       try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("SELECT * "
                        + "FROM vlucht "
                        + "INNER JOIN luchthaven luchthaven1 ON  vlucht.aankomstluchthaven_id = luchthaven1.id "
                        + "INNER JOIN land land1 ON land1.id = luchthaven1.land_id "
                        + "INNER JOIN luchthaven luchthaven2 ON  vlucht.vertrekluchthaven_id = luchthaven2.id "
                        + "INNER JOIN land land2 ON land2.id = luchthaven2.land_id "
                        + "INNER JOIN vliegtuig vliegtuig ON Vliegtuig.id = vlucht.VLIEGTUIG_ID "
                        + "INNER JOIN Luchtvaartmaatschappij luchtvaartmaatschappij  ON luchtvaartmaatschappij.id = vliegtuig.LUCHTVAARTMAATSCHAPPIJ_ID "
                        + "where to_char(vlucht.VERTREKTIJD,'yyyy-mm-dd') like ?");) {
            statement.setString(1, date + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {;
                vlucht = new Vlucht();
                vlucht.setId(resultSet.getInt("id"));
                vlucht.setCode(resultSet.getString("code"));
                vlucht.setVertrektijd(resultSet.getDate("vertrektijd"));
                vlucht.setAankomsttijd(resultSet.getDate("aankomsttijd"));
                vlucht.setVliegtuig_id(resultSet.getInt("vliegtuig_id"));

                Luchthaven aankomstluchthaven = new Luchthaven();
                aankomstluchthaven.setId(resultSet.getInt(8));
                aankomstluchthaven.setLuchthavennaam(resultSet.getString(9));
                aankomstluchthaven.setStad(resultSet.getString(10));
                aankomstluchthaven.setLand_id(resultSet.getInt(11));

                Luchthaven vertrekluchthaven = new Luchthaven();
                vertrekluchthaven.setId(resultSet.getInt(14));
                vertrekluchthaven.setLuchthavennaam(resultSet.getString(15));
                vertrekluchthaven.setStad(resultSet.getString(16));
                vertrekluchthaven.setLand_id(resultSet.getInt(17));

                Land landAankomst = new Land();
                landAankomst.setId(resultSet.getInt(12));
                landAankomst.setLandnaam(resultSet.getString(13));

                aankomstluchthaven.setLand(landAankomst);
                vlucht.setAankomstluchthaven(aankomstluchthaven);

                Land landVertrek = new Land();
                landVertrek.setId(resultSet.getInt(18));
                landVertrek.setLandnaam(resultSet.getString(19));

                vertrekluchthaven.setLand(landVertrek);
                vlucht.setVertrekluchthaven(vertrekluchthaven);

                Vliegtuig vliegtuig = new Vliegtuig();
                vliegtuig.setId(resultSet.getInt(20));
                vliegtuig.setVliegtuigtype_id(resultSet.getInt(21));
                vliegtuig.setLuchtvaartmaatschappij_id(resultSet.getInt(22));

                Luchtvaartmaatschappij lvms = new Luchtvaartmaatschappij();
                lvms.setId(resultSet.getInt(23));
                lvms.setLuchtvaartnaam(resultSet.getString(24));
                vliegtuig.setLuchtvaartmaatschappij(lvms);

                vlucht.setVliegtuig(vliegtuig);

                lijstAlleVluchten.add(vlucht);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lijstAlleVluchten;
    }
        
        public ArrayList<Vlucht> getVluchtenByLuchtvaartmaatschappij(int id){
        ArrayList<Vlucht> lijstAlleVluchten = new ArrayList<>();
        Vlucht vlucht = null;
        
        try(
            Connection connection = DriverManager.getConnection(url, login, password);
            PreparedStatement statement = connection.prepareStatement( "SELECT * "
                    + "FROM vlucht "
                    + "INNER JOIN luchthaven luchthaven1 ON  vlucht.aankomstluchthaven_id = luchthaven1.id "
                    + "INNER JOIN land land1 ON land1.id = luchthaven1.land_id "
                    + "INNER JOIN luchthaven luchthaven2 ON  vlucht.vertrekluchthaven_id = luchthaven2.id " 
                    + "INNER JOIN land land2 ON land2.id = luchthaven2.land_id "
                    + "INNER JOIN vliegtuig vliegtuig ON Vliegtuig.id = vlucht.VLIEGTUIG_ID "
                    + "INNER JOIN Luchtvaartmaatschappij luchtvaartmaatschappij  ON luchtvaartmaatschappij.id = vliegtuig.LUCHTVAARTMAATSCHAPPIJ_ID "
                    + "where luchtvaartmaatschappij.id = ?");)
                
        {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {;
                vlucht = new Vlucht();
                vlucht.setId(resultSet.getInt("id"));
                vlucht.setCode(resultSet.getString("code"));
                vlucht.setVertrektijd(resultSet.getDate("vertrektijd"));
                vlucht.setAankomsttijd(resultSet.getDate("aankomsttijd"));
                vlucht.setVliegtuig_id(resultSet.getInt("vliegtuig_id"));
                
                
                Luchthaven aankomstluchthaven = new Luchthaven();
                aankomstluchthaven.setId(resultSet.getInt(8));
                aankomstluchthaven.setLuchthavennaam(resultSet.getString(9));
                aankomstluchthaven.setStad(resultSet.getString(10));
                aankomstluchthaven.setLand_id(resultSet.getInt(11));
                
                Luchthaven vertrekluchthaven = new Luchthaven();
                vertrekluchthaven.setId(resultSet.getInt(14));
                vertrekluchthaven.setLuchthavennaam(resultSet.getString(15));
                vertrekluchthaven.setStad(resultSet.getString(16));
                vertrekluchthaven.setLand_id(resultSet.getInt(17));      
                
                Land landAankomst = new Land();
                landAankomst.setId(resultSet.getInt(12));
                landAankomst.setLandnaam(resultSet.getString(13));
                
                aankomstluchthaven.setLand(landAankomst);
                vlucht.setAankomstluchthaven(aankomstluchthaven);
                
                Land landVertrek = new Land();
                landVertrek.setId(resultSet.getInt(18));
                landVertrek.setLandnaam(resultSet.getString(19));
                
                vertrekluchthaven.setLand(landVertrek);
                vlucht.setVertrekluchthaven(vertrekluchthaven);
                
                Vliegtuig vliegtuig = new Vliegtuig();
                vliegtuig.setId(resultSet.getInt(20));
                vliegtuig.setVliegtuigtype_id(resultSet.getInt(21));
                vliegtuig.setLuchtvaartmaatschappij_id(resultSet.getInt(22));
                
                Luchtvaartmaatschappij lvms = new Luchtvaartmaatschappij();
                lvms.setId(resultSet.getInt(23));
                lvms.setLuchtvaartnaam(resultSet.getString(24));
                vliegtuig.setLuchtvaartmaatschappij(lvms);
                
                vlucht.setVliegtuig(vliegtuig);
                
                lijstAlleVluchten.add(vlucht);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    return lijstAlleVluchten;
    }
        
                public ArrayList<Vlucht> getVluchtenByBestemming(int id){
        ArrayList<Vlucht> lijstAlleVluchten = new ArrayList<>();
        Vlucht vlucht = null;
        
        try(
            Connection connection = DriverManager.getConnection(url, login, password);
            PreparedStatement statement = connection.prepareStatement( "SELECT * "
                    + "FROM vlucht "
                    + "INNER JOIN luchthaven luchthaven1 ON  vlucht.aankomstluchthaven_id = luchthaven1.id "
                    + "INNER JOIN land land1 ON land1.id = luchthaven1.land_id "
                    + "INNER JOIN luchthaven luchthaven2 ON  vlucht.vertrekluchthaven_id = luchthaven2.id " 
                    + "INNER JOIN land land2 ON land2.id = luchthaven2.land_id "
                    + "INNER JOIN vliegtuig vliegtuig ON Vliegtuig.id = vlucht.VLIEGTUIG_ID "
                    + "INNER JOIN Luchtvaartmaatschappij luchtvaartmaatschappij  ON luchtvaartmaatschappij.id = vliegtuig.LUCHTVAARTMAATSCHAPPIJ_ID "
                    + "where luchthaven.id = ?");)
                
        {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {;
                vlucht = new Vlucht();
                vlucht.setId(resultSet.getInt("id"));
                vlucht.setCode(resultSet.getString("code"));
                vlucht.setVertrektijd(resultSet.getDate("vertrektijd"));
                vlucht.setAankomsttijd(resultSet.getDate("aankomsttijd"));
                vlucht.setVliegtuig_id(resultSet.getInt("vliegtuig_id"));
                
                
                Luchthaven aankomstluchthaven = new Luchthaven();
                aankomstluchthaven.setId(resultSet.getInt(8));
                aankomstluchthaven.setLuchthavennaam(resultSet.getString(9));
                aankomstluchthaven.setStad(resultSet.getString(10));
                aankomstluchthaven.setLand_id(resultSet.getInt(11));
                
                Luchthaven vertrekluchthaven = new Luchthaven();
                vertrekluchthaven.setId(resultSet.getInt(14));
                vertrekluchthaven.setLuchthavennaam(resultSet.getString(15));
                vertrekluchthaven.setStad(resultSet.getString(16));
                vertrekluchthaven.setLand_id(resultSet.getInt(17));      
                
                Land landAankomst = new Land();
                landAankomst.setId(resultSet.getInt(12));
                landAankomst.setLandnaam(resultSet.getString(13));
                
                aankomstluchthaven.setLand(landAankomst);
                vlucht.setAankomstluchthaven(aankomstluchthaven);
                
                Land landVertrek = new Land();
                landVertrek.setId(resultSet.getInt(18));
                landVertrek.setLandnaam(resultSet.getString(19));
                
                vertrekluchthaven.setLand(landVertrek);
                vlucht.setVertrekluchthaven(vertrekluchthaven);
                
                Vliegtuig vliegtuig = new Vliegtuig();
                vliegtuig.setId(resultSet.getInt(20));
                vliegtuig.setVliegtuigtype_id(resultSet.getInt(21));
                vliegtuig.setLuchtvaartmaatschappij_id(resultSet.getInt(22));
                
                Luchtvaartmaatschappij lvms = new Luchtvaartmaatschappij();
                lvms.setId(resultSet.getInt(23));
                lvms.setLuchtvaartnaam(resultSet.getString(24));
                vliegtuig.setLuchtvaartmaatschappij(lvms);
                
                vlucht.setVliegtuig(vliegtuig);
                
                lijstAlleVluchten.add(vlucht);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    return lijstAlleVluchten;
    }
                
    public ArrayList<Vlucht> getAlleVluchtenVanPassagier(int persoonID){
    ArrayList<Vlucht> lijstAlleVluchten = new ArrayList<>();
        Vlucht vlucht = null;
        
        try(
            Connection connection = DriverManager.getConnection(url, login, password);
            PreparedStatement statement = connection.prepareStatement( "SELECT * "
                    + "FROM vlucht "
                    + "INNER JOIN passagier ON vlucht.id = passagier.vlucht_id "
                    + "INNER JOIN luchthaven luchthaven1 ON  vlucht.aankomstluchthaven_id = luchthaven1.id "
                    + "INNER JOIN land land1 ON land1.id = luchthaven1.land_id "
                    + "INNER JOIN luchthaven luchthaven2 ON  vlucht.vertrekluchthaven_id = luchthaven2.id " 
                    + "INNER JOIN land land2 ON land2.id = luchthaven2.land_id "
                    + "WHERE persoon.id = ? "
                    + "ORDER BY vlucht.vertrektijd DESC ");)
                
        {
            statement.setInt(1, persoonID);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {;
                vlucht = new Vlucht();
                vlucht.setId(resultSet.getInt("id"));
                vlucht.setCode(resultSet.getString("code"));
                vlucht.setVertrektijd(resultSet.getDate("vertrektijd"));
                vlucht.setAankomsttijd(resultSet.getDate("aankomsttijd"));
                vlucht.setVliegtuig_id(resultSet.getInt("vliegtuig_id"));
                
                
                Luchthaven aankomstluchthaven = new Luchthaven();
                aankomstluchthaven.setId(resultSet.getInt(8));
                aankomstluchthaven.setLuchthavennaam(resultSet.getString(9));
                aankomstluchthaven.setStad(resultSet.getString(10));
                aankomstluchthaven.setLand_id(resultSet.getInt(11));
                
                Luchthaven vertrekluchthaven = new Luchthaven();
                vertrekluchthaven.setId(resultSet.getInt(14));
                vertrekluchthaven.setLuchthavennaam(resultSet.getString(15));
                vertrekluchthaven.setStad(resultSet.getString(16));
                vertrekluchthaven.setLand_id(resultSet.getInt(17));      
                
                Land landAankomst = new Land();
                landAankomst.setId(resultSet.getInt(12));
                landAankomst.setLandnaam(resultSet.getString(13));
                
                aankomstluchthaven.setLand(landAankomst);
                vlucht.setAankomstluchthaven(aankomstluchthaven);
                
                Land landVertrek = new Land();
                landVertrek.setId(resultSet.getInt(18));
                landVertrek.setLandnaam(resultSet.getString(19));
                
                vertrekluchthaven.setLand(landVertrek);
                vlucht.setVertrekluchthaven(vertrekluchthaven);
               
                lijstAlleVluchten.add(vlucht);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    return lijstAlleVluchten;
    }    
    
}