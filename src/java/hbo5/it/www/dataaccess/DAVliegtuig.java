/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;

import hbo5.it.www.beans.Vliegtuig;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author c1043194
 */
public class DAVliegtuig {

    private final String url, login, password;

    public DAVliegtuig(String url, String login, String password, String driver) throws ClassNotFoundException {
        Class.forName(driver);
        this.url = url;
        this.login = login;
        this.password = password;
    }

    public boolean insertVliegtuig(int id, int typeid, int maatschappijid) {
        boolean resultaat = true;

        try (Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("insert into vliegtuig values (vliegtuig_seq.nextval,?,?,?)");) {
            statement.setInt(1, id);
            statement.setInt(2, typeid);
            statement.setInt(3, maatschappijid);
            statement.executeUpdate();
        } catch (Exception e) {
            resultaat = false;
            e.printStackTrace();
        }
        return resultaat;
    }

    public boolean deleteVliegtuig(int id) {
        boolean resultaat = true;

        try (Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("delete from vliegtuig where id = ?");) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            resultaat = false;
            e.printStackTrace();
        }
        return resultaat;
    }
    
        public boolean updateVliegtuig(int id, int typeid, int maatschappijid) {
        boolean resultaat = true;

        try (Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("update vliegtuig set vliegtuigtype_id =?, luchtvaartmaatschappij_id = ? where id = ?");) {
            statement.setInt(1, typeid);
            statement.setInt(2, maatschappijid);
            statement.setInt(3, id);
            statement.executeUpdate();
        } catch (Exception e) {
            resultaat = false;
            e.printStackTrace();
        }
        return resultaat;
    }
        
        public ArrayList<Vliegtuig> getAllVliegtuigen() {
        ArrayList<Vliegtuig> lijstAlleVliegtuigen = new ArrayList<>();
        Vliegtuig vliegtuig = null;
        
        
       try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("SELECT * "
                + "FROM vliegtuig "
                + "INNER JOIN Luchtvaartmaatschappij luchtvaartmaatschappij  ON luchtvaartmaatschappij.id = LUCHTVAARTMAATSCHAPPIJ_ID "
                + "INNER JOIN Vliegtuigtype vliegtuigtype ON vliegtuigtype.id = vliegtuig.vliegtuigtype_id "
                );) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {;
                vliegtuig = new Vliegtuig();
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lijstAlleVliegtuigen;
        }
}
