/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classi;

/**
 *
 * @author marco
 */
public class JAreaInteresse {
    private Integer id_area;
    private Integer geoname_id;
    private String nome; //nome della cittá
    
    public JAreaInteresse(){
        geoname_id = 0;
        nome = "";
    }

    public JAreaInteresse(Integer geoname_id, String nome) {
        this.geoname_id = geoname_id;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "geoname_id=" + geoname_id + ", nome=" + nome;
    }
    
    
}
