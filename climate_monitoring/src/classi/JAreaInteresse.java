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

    public Integer getId_area(){
        return id_area;
    }
    
    public JAreaInteresse(Integer id_area, Integer geoname_id, String nome) {
        this.id_area = id_area;
        this.geoname_id = geoname_id;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return geoname_id + "," + nome;
    }
    
    public String toStringList(){
        return id_area + " " + nome;
    }
    
    
}
