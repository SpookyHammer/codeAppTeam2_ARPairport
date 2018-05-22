/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;

import hbo5.it.www.beans.Bemanningslid;
import hbo5.it.www.beans.Functie;
import hbo5.it.www.beans.Luchtvaartmaatschappij;
import hbo5.it.www.beans.Persoon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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
public Bemanningslid getBemanningslid(String id) {
        Bemanningslid bemanningslid = null;

        try (
             Connection connection = DriverManager.getConnection(url, login, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM bemanningslid JOIN luchtvaartmaatschappij ON bemanningslid.luchtvaartmaatschappij_id = luchtvaartmaatschappij.id "
                     + "JOIN persoon ON bemanningslid.persoon_id = persoon.id"
                     + "JOIN functie ON bemanningslid.functie_id = functie.id WHERE id = ?");) 
            {
            if (resultSet.next()) {
                bemanningslid = new Bemanningslid();
                bemanningslid.setId(resultSet.getInt("id"));
                bemanningslid.setFunctie_id(resultSet.getInt("functie_id"));
                bemanningslid.setLuchtvaartmaatschappij_id(resultSet.getInt("luchtvaartmaatschappij_id"));
                bemanningslid.setPersoon_id(resultSet.getInt("persoon_id"));
 
                // FK Functie
                Functie functie = new Functie();
                functie.setId(resultSet.getInt("functie_id"));
                functie.setFunctienaam(resultSet.getString("functienaam"));
                functie.setOmschrijving(resultSet.getString("omschrijving"));
                // bemanningslid + functie
                bemanningslid.setFunctie(functie);
                // FK Luchtvaartmaatschappij
                Luchtvaartmaatschappij luchtvaartmaatschappij = new Luchtvaartmaatschappij();
                luchtvaartmaatschappij.setId(resultSet.getInt("luchtvaartmaatschappij_id"));
                luchtvaartmaatschappij.setLuchtvaartnaam(resultSet.getString("luchtvaartnaam"));
                // bemanningslid + Luchtvaartmaatschappij
                bemanningslid.setLuchtvaartmaatschappij(luchtvaartmaatschappij);
                // FK persoon
                Persoon persoon = new Persoon();
                persoon.setFamilienaam(resultSet.getString("familienaam"));
                persoon.setGeboortedatum(resultSet.getDate("geboortedatum"));
                persoon.setId(resultSet.getInt("persoon_id"));
                persoon.setHuisnr(resultSet.getString("huisnr"));
                persoon.setLand(resultSet.getString("land"));
                persoon.setLogin(resultSet.getString("login"));
                persoon.setPaswoord(resultSet.getString("paswoord"));
                persoon.setPostcode(resultSet.getString("postcode"));
                persoon.setSoort(resultSet.getString("soort").charAt(0));
                persoon.setStraat(resultSet.getString("straat"));
                persoon.setVoornaam(resultSet.getString("voornaam"));
                persoon.setWoonplaats(resultSet.getString("woonplaats"));
                // bemanningslid + Luchtvaartmaatschappij
                bemanningslid.setPersoon(persoon);
                
                
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bemanningslid;
    }


public ArrayList<Bemanningslid> getBemanningsleden() {
    ArrayList<Bemanningslid> lijstalleBemanningsleden = new ArrayList<>();
        Bemanningslid bemanningslid = null;

        try (
             Connection connection = DriverManager.getConnection(url, login, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM bemanningslid JOIN luchtvaartmaatschappij ON bemanningslid.luchtvaartmaatschappij_id = luchtvaartmaatschappij.id "
                     + "JOIN persoon ON bemanningslid.persoon_id = persoon.id "
                     + "JOIN functie ON bemanningslid.functie_id = functie.id");) 
            {
            while (resultSet.next()) {
                bemanningslid = new Bemanningslid();
                bemanningslid.setId(resultSet.getInt("id"));
                bemanningslid.setFunctie_id(resultSet.getInt("functie_id"));
                bemanningslid.setLuchtvaartmaatschappij_id(resultSet.getInt("luchtvaartmaatschappij_id"));
                bemanningslid.setPersoon_id(resultSet.getInt("persoon_id"));
 
                // FK Functie
                Functie functie = new Functie();
                functie.setId(resultSet.getInt("functie_id"));
                functie.setFunctienaam(resultSet.getString("functienaam"));
                functie.setOmschrijving(resultSet.getString("omschrijving"));
                // bemanningslid + functie
                bemanningslid.setFunctie(functie);
                // FK Luchtvaartmaatschappij
                Luchtvaartmaatschappij luchtvaartmaatschappij = new Luchtvaartmaatschappij();
                luchtvaartmaatschappij.setId(resultSet.getInt("luchtvaartmaatschappij_id"));
                luchtvaartmaatschappij.setLuchtvaartnaam(resultSet.getString("luchtvaartnaam"));
                // bemanningslid + Luchtvaartmaatschappij
                bemanningslid.setLuchtvaartmaatschappij(luchtvaartmaatschappij);
                // FK persoon
                Persoon persoon = new Persoon();
                persoon.setFamilienaam(resultSet.getString("familienaam"));
                persoon.setGeboortedatum(resultSet.getDate("geboortedatum"));
                persoon.setId(resultSet.getInt("persoon_id"));
                persoon.setHuisnr(resultSet.getString("huisnr"));
                persoon.setLand(resultSet.getString("land"));
                persoon.setLogin(resultSet.getString("login"));
                persoon.setPaswoord(resultSet.getString("paswoord"));
                persoon.setPostcode(resultSet.getString("postcode"));
                persoon.setSoort(resultSet.getString("soort").charAt(0));
                persoon.setStraat(resultSet.getString("straat"));
                persoon.setVoornaam(resultSet.getString("voornaam"));
                persoon.setWoonplaats(resultSet.getString("woonplaats"));
                // bemanningslid + Luchtvaartmaatschappij
                bemanningslid.setPersoon(persoon);
                
                lijstalleBemanningsleden.add(bemanningslid);
                
                
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return lijstalleBemanningsleden;
    }
}
