/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;

import hbo5.it.www.beans.Land;
import hbo5.it.www.beans.Luchthaven;
import hbo5.it.www.beans.Vlucht;
import java.sql.Connection;
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
                    + "INNER JOIN land1 ON land.id = luchthaven1.land_id "
                    + "INNER JOIN luchthaven luchthaven2 ON  vlucht.vertrekluchthaven_id = luchthaven2.id " 
                    + "INNER JOIN land2 ON land.id = luchthaven2.land_id "
                    + "WHERE vlucht.aankomstluchthaven_id = ?");)
                
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
                    + "INNER JOIN land1 ON land.id = luchthaven1.land_id "
                    + "INNER JOIN luchthaven luchthaven2 ON  vlucht.vertrekluchthaven_id = luchthaven2.id " 
                    + "INNER JOIN land2 ON land.id = luchthaven2.land_id "
                    + "WHERE vlucht.vertrekluchthaven_id = ?");)
                
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
                
               
                lijstAlleVluchten.add(vlucht);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    return lijstAlleVluchten;
    }
     
}
