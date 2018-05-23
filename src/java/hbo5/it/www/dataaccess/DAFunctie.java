/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;

import hbo5.it.www.beans.Functie;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author c1042016
 */
public class DAFunctie {
    private final String url, login, password;

    public DAFunctie(String url, String login, String password, String driver) throws ClassNotFoundException {
        Class.forName(driver);
        this.url = url;
        this.login = login;
        this.password = password;
    }
    public ArrayList<Functie> getFuncties() {
        ArrayList<Functie> lijstalleFuncties = new ArrayList<>();
        

        try (
             Connection connection = DriverManager.getConnection(url, login, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM functie ORDER BY id");) 
            {
            while (resultSet.next()) {
                Functie functie = new Functie();
                functie.setId(resultSet.getInt(1));
                functie.setFunctienaam(resultSet.getString(2));
                functie.setOmschrijving(resultSet.getString(3));
                
                lijstalleFuncties.add(functie);
                
                
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return lijstalleFuncties;
    }
}
