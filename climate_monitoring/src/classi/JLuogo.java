/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classi;

/**
 *
 * @author marco
 */
public class JLuogo {

    private Integer geoname_id;
    private String nome;
    private String country_code;
    private JCoordinate coordinate;

    public JLuogo() {
        geoname_id = 0;
        nome = "";
        country_code = "";
        coordinate = new JCoordinate();
    }

    public JLuogo(Integer geoname_id, String nome, String country_code, JCoordinate coordinate) {
        this.geoname_id = geoname_id;
        this.nome = nome;
        this.country_code = country_code;
        this.coordinate = coordinate;
    }

    @Override
    public String toString() {
        return "JLuogo{" + "geoname_id=" + geoname_id + ", nome=" + nome + ", country_code=" + country_code + ", coordinate=" + coordinate + '}';
    }

}
