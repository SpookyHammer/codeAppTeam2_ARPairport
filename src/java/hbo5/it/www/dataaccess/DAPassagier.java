/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;

import hbo5.it.www.beans.Passagier;
import hbo5.it.www.beans.Persoon;
import hbo5.it.www.beans.Vliegtuigklasse;
import hbo5.it.www.beans.Vlucht;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author c1045286
 */
public class DAPassagier {

    private final String url, login, password;

    public DAPassagier(String url, String login, String password, String driver) throws ClassNotFoundException {
        Class.forName(driver);
        this.url = url;
        this.login = login;
        this.password = password;
    }

    public ArrayList<Passagier> getPassagiersByVlucht(int vluchtid) {
        ArrayList<Passagier> passagiers = new ArrayList<Passagier>();
        Passagier passagier = null;

        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("SELECT * "
                        + "FROM passagier "
                        + "INNER JOIN vliegtuigklasse vliegtuigklasse ON vliegtuigklasse.id = passagier.KLASSE_ID "
                        + "INNER JOIN Vlucht vlucht ON vlucht.id = passagier.vlucht_id "
                        + "INNER JOIN Persoon persoon ON persoon.id = passagier.persoon_id  "
                        + "WHERE vlucht.code = ?");) {
            statement.setInt(1, vluchtid);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                passagier = new Passagier();
                passagier.setId(resultSet.getInt(1));
                passagier.setIngeschreven(resultSet.getInt(2));
                passagier.setIngecheckt(resultSet.getInt(3));
                passagier.setKlasse_id(resultSet.getInt(4));
                passagier.setPlaats(resultSet.getString(5));
                passagier.setVlucht_id(resultSet.getInt(6));
                passagier.setPersoon_id(resultSet.getInt(7));
                
                Vliegtuigklasse klasse = new Vliegtuigklasse();
                klasse.setId(resultSet.getInt(8));
                klasse.setKlassenaam(resultSet.getString(9));
                passagier.setVliegtuigklasse(klasse);
                
                Vlucht vlucht = new Vlucht();
                vlucht.setId(resultSet.getInt(10));
                vlucht.setCode(resultSet.getString(11));
                vlucht.setVertrektijd(resultSet.getDate(12));
                vlucht.setAankomsttijd(resultSet.getDate(13));
                passagier.setVlucht(vlucht);
                
                Persoon persoon = new Persoon();
                persoon.setId(resultSet.getInt(17));
                persoon.setVoornaam(resultSet.getString(18));
                persoon.setFamilienaam(resultSet.getString(19));
                persoon.setStraat(resultSet.getString(20));
                persoon.setHuisnr(resultSet.getString(21));
                persoon.setPostcode(resultSet.getString(22));
                persoon.setWoonplaats(resultSet.getString(23));
                persoon.setLand(resultSet.getString(24));
                persoon.setGeboortedatum(resultSet.getDate(25));
                persoon.setLogin(resultSet.getString(26));
                persoon.setPaswoord(resultSet.getString(27));
                persoon.setSoort(resultSet.getString(28).charAt(0));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return passagiers;
    }
}
