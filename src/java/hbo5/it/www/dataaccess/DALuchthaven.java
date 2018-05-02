/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;

import hbo5.it.www.beans.Land;
import hbo5.it.www.beans.Luchthaven;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author c1043194
 */
public class DALuchthaven {
        private final String url, login, password;
    
    public DALuchthaven (String url, String login, String password, String driver)   throws ClassNotFoundException {
        Class.forName(driver);
        this.url = url;
	this.login = login;
	this.password = password;
    }
    public ArrayList<Luchthaven> getAlleLuchthavens(){
        ArrayList<Luchthaven> lijstAlleLuchthavens = new ArrayList<>();
        Luchthaven luchthaven = null;
        
        try(
            Connection connection = DriverManager.getConnection(url, login, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT * "
                    + "FROM luchthaven "
                    + "INNER JOIN land ON luchthaven.land_id  = land.id "
                    + "ORDER BY luchthavennaam");) 
        
        {
            while (resultSet.next()) {
                luchthaven = new Luchthaven();
                luchthaven.setId(resultSet.getInt(1));
                luchthaven.setLuchthavennaam(resultSet.getString(2));
                luchthaven.setStad(resultSet.getString(3));
                luchthaven.setLand_id(resultSet.getInt(4));
                
                Land land = new Land();
                land.setId(resultSet.getInt(5));
                land.setLandnaam(resultSet.getString(6));

                luchthaven.setLand(land);
                lijstAlleLuchthavens.add(luchthaven);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    return lijstAlleLuchthavens;
    }
    
}
