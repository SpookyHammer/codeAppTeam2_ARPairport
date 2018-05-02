/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;

import hbo5.it.www.beans.Bemanningslid;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author c1045286
 */
public class DABemanningslid {
    private final String url, login, password;

public DABemanningslid (String url, String login, String password, String driver)   throws ClassNotFoundException {
        Class.forName(driver);
        this.url = url;
	this.login = login;
	this.password = password;
    }
public Bemanningslid getBemanningslid() {
        Bemanningslid bemanningslid = null;

        try (
             Connection connection = DriverManager.getConnection(url, login, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM bemanningslid JOIN luchtvaartmaatschappij ON bemanningslid.luchtvaartmaatschappij_id = luchtvaartmaatschappij.id "
                     + "JOIN persoon ON bemanningslid.persoon_id = persoon.id"
                     + "JOIN functie ON bemanningslid.functie_id = functie.id WHERE id = 1");) 
            {
            if (resultSet.next()) {
                bemanningslid = new Bemanningslid();
                bemanningslid.setFunctie_id(0);
                bemanningslid.setLuchtvaartmaatschappij_id(0);
                bemanningslid.setPersoon_id(0);
                // FK PERIODE
                /*Periode periode = new Periode();
                periode.setId(resultSet.getInt("periodeid"));
                periode.setPeriode(resultSet.getString("periode"));
                // PERIODE + AANBOD
                aanbod.setPeriode(periode);*/
                
                
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bemanningslid;
    }
}
