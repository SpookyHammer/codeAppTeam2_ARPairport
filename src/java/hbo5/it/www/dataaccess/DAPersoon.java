/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;

import hbo5.it.www.beans.Persoon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;

/**
 *
 * @author c1042016
 */
public class DAPersoon {

    private final String url, login, password;

    public DAPersoon(String url, String login, String password, String driver) throws ClassNotFoundException {
        Class.forName(driver);
        this.url = url;
        this.login = login;
        this.password = password;
    }
    
     public Persoon GetPersoon(String gb, String pw )
    {
        Persoon persoon = null;
        
        try(
            Connection connection = DriverManager.getConnection(url, login, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM persoon WHERE persoon.login = ? AND persoon.paswoord = ?");)
            {
                statement.setString(1, gb);
                statement.setString(2, pw);
                ResultSet resultSet = statement.executeQuery();
                if(resultSet.next()){
                    persoon = new Persoon();
                    persoon.setFamilienaam(resultSet.getString("familienaam"));
                    persoon.setGeboortedatum(resultSet.getDate("geboortedatum"));
                    persoon.setId(resultSet.getInt("id"));
                    persoon.setHuisnr(resultSet.getString("huisnr"));
                    persoon.setLand(resultSet.getString("land"));
                    persoon.setLogin(resultSet.getString("login"));
                    persoon.setPaswoord(resultSet.getString("paswoord"));
                    persoon.setPostcode(resultSet.getString("postcode"));
                    persoon.setSoort(resultSet.getString("soort").charAt(0));
                    persoon.setStraat(resultSet.getString("straat"));
                    persoon.setVoornaam(resultSet.getString("voornaam"));
                    persoon.setWoonplaats(resultSet.getString("woonplaats"));
            }
    } 
        catch (Exception e) { e.printStackTrace();}
        return persoon;
    }
     
     public boolean InsertPersoon(String voornaam, String familienaam, String straat, String huisnr, String postcode, String woonplaats, String land, Date geboortedatum, String login1, String passwoord) {
        boolean resultaat = true;
        try (Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("insert into persoon values (persoon_seq.nextval,?,?,?,?,?,?,?,?,?,?,'P')")) {
            statement.setString(1, voornaam);
            statement.setString(2, familienaam);
            statement.setString(3, straat);
            statement.setString(4, huisnr);
            statement.setString(5, postcode);
            statement.setString(6, woonplaats);
            statement.setString(7, land);
            statement.setDate(8, geboortedatum);
            statement.setString(9, login1);
            statement.setString(10, passwoord);
            statement.executeUpdate();
        } catch (Exception e) {
            resultaat = false;
            e.printStackTrace();
        }

        return resultaat;
    }
}
