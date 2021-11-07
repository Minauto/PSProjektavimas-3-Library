package com.library.web.libraryweb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // map to db table. Default table name is the name of entity class
public class Vartotojas implements Comparable<Vartotojas>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // JPA autogenerates value of id
    private int id;

    private String vardas;
    private String pavarde;
    private String telefonoNumeris;
    private String email;
    private String adresas;
    private String slaptazodis;

    protected Vartotojas() {}

    public Vartotojas(String vardas, String pavarde,String telefonoNumeris, String email,String adresas, String slaptazodis) {
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.telefonoNumeris = telefonoNumeris;
        this.email = email;
        this.adresas = adresas;
        this.slaptazodis = slaptazodis;
    }

    public Vartotojas(int id, String vardas, String pavarde,String telefonoNumeris, String email,String adresas, String slaptazodis) {
        super();
        if(id < 0)
            throw new NullPointerException();
        this.id = id;
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.telefonoNumeris = telefonoNumeris;
        this.email = email;
        this.adresas = adresas;
        this.slaptazodis = slaptazodis;
    }

    @Override
    public String toString() {
        return "Vartotojas [id=" + id + ", vardas=" + vardas + " pavarde=" + pavarde + "telefonoNumeris=" + telefonoNumeris + "email=" + email + "adresas=" + adresas + "slaptazodis=" + slaptazodis + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vartotojas other = (Vartotojas) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public int compareTo(Vartotojas o) {
        return Integer.compare(this.id, o.getId());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id < 0) {
            System.out.println("ERROR Vartotojas.setId() trying to set wrong value for id=" + id + ", value must be >=0");
            throw new NullPointerException();
        }
        this.id = id;
    }

    public String getVardas() {
        return vardas;
    }
    public void setVardas(String vardas) {
        this.vardas = vardas;
    }
    public String getPavarde() {
        return pavarde;
    }
    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }
    public String getTelefonoNumeris() {
        return telefonoNumeris;
    }
    public void setTelefonoNumeris(String telefonoNumeris) {
        this.telefonoNumeris = telefonoNumeris;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAdresas() {
        return adresas;
    }
    public void setAdresas(String adresas) {
        this.adresas = adresas;
    }
    public String getSlaptazodis() {
        return slaptazodis;
    }
    public void setSlaptazodis(String slaptazodis) {
        this.slaptazodis = slaptazodis;
    }

}
