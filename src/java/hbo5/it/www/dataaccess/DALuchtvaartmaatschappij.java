/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;

import hbo5.it.www.beans.Luchtvaartmaatschappij;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author c1043194
 */
public class DALuchtvaartmaatschappij {
        private final String url, login, password;
    
    public DALuchtvaartmaatschappij (String url, String login, String password, String driver)   throws ClassNotFoundException {
        Class.forName(driver);
        this.url = url;
	this.login = login;
	this.password = password;
    }
     public ArrayList<Luchtvaartmaatschappij> getAlleLuchtvaartmaatschappijen(){
        ArrayList<Luchtvaartmaatschappij> lijstAlleLuchtvaartmaatschappijen = new ArrayList<>();
        
        try(
            Connection connection = DriverManager.getConnection(url, login, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT * "
                    + "FROM luchtvaartmaatschappij "
                    + "ORDER BY id");) 
        
        {
            while (resultSet.next()) {
                Luchtvaartmaatschappij luchtvaartmaatschappij = new Luchtvaartmaatschappij();
                luchtvaartmaatschappij.setId(resultSet.getInt(1));
                luchtvaartmaatschappij.setLuchtvaartnaam(resultSet.getString(2));
                lijstAlleLuchtvaartmaatschappijen.add(luchtvaartmaatschappij);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    return lijstAlleLuchtvaartmaatschappijen;
    }
}

