/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;

/**
 *
 * @author c1043194
 */
public class DALand {
        private final String url, login, password;
    
    public DALand (String url, String login, String password, String driver)   throws ClassNotFoundException {
        Class.forName(driver);
        this.url = url;
	this.login = login;
	this.password = password;
    }
}
