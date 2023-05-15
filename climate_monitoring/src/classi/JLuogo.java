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
    private String country;
    private JCoordinate coordinate;

    public JLuogo() {
        geoname_id = 0;
        nome = "";
        country_code = "";
        coordinate = new JCoordinate();
    }

    public JLuogo(Integer geoname_id, String nome, String country_code, String country, JCoordinate coordinate) {
        this.geoname_id = geoname_id;
        this.nome = nome;
        this.country_code = country_code;
        this.country = country;
        this.coordinate = coordinate;
    }

    public JLuogo(String fromCSV) {
        String[] elements = fromCSV.split(";");
        geoname_id = Integer.valueOf(elements[0]);
        nome = elements[1];
        country_code = elements[2];
        country = elements[3];
        coordinate = new JCoordinate(Float.valueOf(elements[4].split(",")[0]), Float.valueOf(elements[4].split(",")[1]));
    }

    @Override
    public String toString() {
        return "geoname_id=" + geoname_id + ", nome=" + nome + ", country_code=" + country_code + ", coordinate=" + coordinate;
    }

    public Integer getGeoname_id() {
        return geoname_id;
    }

    public String getNome() {
        return nome;
    }

    public String getCountry_code() {
        return country_code;
    }

    public JCoordinate getCoordinate() {
        return coordinate;
    }

}
