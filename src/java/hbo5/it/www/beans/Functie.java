/*
Team: 2
Groepsleden: Cools Jasper, Gostek Kaân, Leysen Eline, Winkelmans Quinten

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.beans;

/**
 *
 * @author c1042016
 */
public class Functie {
    private int id;
    private String functienaam;
    private String omschrijving;

    public Functie() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFunctienaam() {
        return functienaam;
    }

    public void setFunctienaam(String functienaam) {
        this.functienaam = functienaam;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }
}
