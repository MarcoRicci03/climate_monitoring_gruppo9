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
}
