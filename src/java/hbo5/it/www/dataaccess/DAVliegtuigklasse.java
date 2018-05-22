/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;

import hbo5.it.www.beans.Land;
import hbo5.it.www.beans.Luchthaven;
import hbo5.it.www.beans.Vliegtuigklasse;
import hbo5.it.www.beans.Vlucht;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author c1042016
 */
public class DAVliegtuigklasse {

    private final String url, login, password;

    public DAVliegtuigklasse(String url, String login, String password, String driver) throws ClassNotFoundException {
        Class.forName(driver);
        this.url = url;
        this.login = login;
        this.password = password;
    }
    
    public ArrayList<Vliegtuigklasse> getAlleVliegtuigklasses(){
        ArrayList<Vliegtuigklasse> lijstAlleVliegtuigklasses = new ArrayList<>();
        Vliegtuigklasse vliegtuigklasse = null;
        
        try(
            Connection connection = DriverManager.getConnection(url, login, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT * "
                    + "FROM vliegtuigklasse ");) 
        
        {
            while (resultSet.next()) {
                vliegtuigklasse = new Vliegtuigklasse();
                vliegtuigklasse.setId(resultSet.getInt(1));
                vliegtuigklasse.setKlassenaam(resultSet.getString(2));
  
                lijstAlleVliegtuigklasses.add(vliegtuigklasse);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    return lijstAlleVliegtuigklasses;
    }       
}
