/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classi;

/**
 *
 * @author marco
 */
public class JUser {
    private String username, nome, cognome, id, password, cf, mail;
    private Integer geoname_id;

    public JUser() {
    }
    public JUser(String [] elementi){
        this.id = elementi[0];
        this.nome = elementi[1];
        this.cognome = elementi[2];
        this.username = elementi[3];
        this.mail = elementi[4];
        this.password = elementi[5];
        this.cf = elementi[6];
        this.geoname_id = Integer.parseInt(elementi[7]);
        
    }

    public JUser(String username, String nome, String cognome, String id, String password, String cf, String mail, Integer station) {
        this.username = username;
        this.nome = nome;
        this.cognome = cognome;
        this.id = id;
        this.password = password;
        this.cf = cf;
        this.mail = mail;
        this.geoname_id = geoname_id;
    }

    public String getUsername() {
        return username;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getCf() {
        return cf;
    }

    public String getMail() {
        return mail;
    }

    public Integer getGeoname_id() {
        return geoname_id;
    }
    
    
}
