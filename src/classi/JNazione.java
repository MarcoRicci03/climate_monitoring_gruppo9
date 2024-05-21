/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classi;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 *
 * @author marco
 */
public class JNazione implements Serializable {
    @SerializedName("nome_nazione")
    private String nome_nazione;
    @SerializedName("country_code")
    private String country_code;

    public JNazione() {
        this.nome_nazione = "";
        this.country_code = "";
    }
    public JNazione(String nome, String country_code) {
        this.nome_nazione = nome;
        this.country_code = country_code;
    }

    public String getNome_nazione() {
        return nome_nazione;
    }

    public String getCountry_code() {
        return country_code;
    }
}