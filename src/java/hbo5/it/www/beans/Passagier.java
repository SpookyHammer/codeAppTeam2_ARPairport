/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.beans;

/**
 *
 * @author c1045286
 */
public class Passagier {
    private int id;
    private int ingeschreven;
    private int ingecheckt;
    private int klasse_id;
    private Vliegtuigklasse vliegtuigklasse;
    private String plaats;
    private int vlucht_id;
    private Vlucht vlucht;
    private int persoon_id;
    private Persoon persoon;

    public Passagier() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIngeschreven() {
        return ingeschreven;
    }

    public void setIngeschreven(int ingeschreven) {
        this.ingeschreven = ingeschreven;
    }

    public int getIngecheckt() {
        return ingecheckt;
    }

    public void setIngecheckt(int ingecheckt) {
        this.ingecheckt = ingecheckt;
    }

    public int getKlasse_id() {
        return klasse_id;
    }

    public void setKlasse_id(int klasse_id) {
        this.klasse_id = klasse_id;
    }

    public Vliegtuigklasse getVliegtuigklasse() {
        return vliegtuigklasse;
    }

    public void setVliegtuigklasse(Vliegtuigklasse vliegtuigklasse) {
        this.vliegtuigklasse = vliegtuigklasse;
    }

    public String getPlaats() {
        return plaats;
    }

    public void setPlaats(String plaats) {
        this.plaats = plaats;
    }

    public int getVlucht_id() {
        return vlucht_id;
    }

    public void setVlucht_id(int vlucht_id) {
        this.vlucht_id = vlucht_id;
    }

    public Vlucht getVlucht() {
        return vlucht;
    }

    public void setVlucht(Vlucht vlucht) {
        this.vlucht = vlucht;
    }

    public int getPersoon_id() {
        return persoon_id;
    }

    public void setPersoon_id(int persoon_id) {
        this.persoon_id = persoon_id;
    }

    public Persoon getPersoon() {
        return persoon;
    }

    public void setPersoon(Persoon persoon) {
        this.persoon = persoon;
    }
    
}
