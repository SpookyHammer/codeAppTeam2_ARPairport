/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;

import hbo5.it.www.beans.Vliegtuigtype;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author c1043194
 */
public class DAVliegtuigtype {
    private final String url, login, password;
    
    public DAVliegtuigtype (String url, String login, String password, String driver)   throws ClassNotFoundException {
        Class.forName(driver);
        this.url = url;
	this.login = login;
	this.password = password;
    }
    
//    public Vliegtuigtype getVliegtuigtype(){
//        Vliegtuigtype vliegtuigtype = null;
//        
//        try(
//            Connection connection = DriverManager.getConnection(url, login, password);
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(
//                    "SELECT * "
//                    + "FROM vliegtuigtype ");) 
//        
//        {
//            if (resultSet.next()) {;
//// 
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    return vliegtuigtype;
//    }
}
