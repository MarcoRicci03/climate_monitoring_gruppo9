package classi;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author marco
 */
public class JCoordinate {

    private Float lat;
    private Float lon;

    public JCoordinate() {
        lat = 0.0f;
        lon = 0.0f;
    }

    public JCoordinate(Float lat, Float lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public Float getLat() {
        return lat;
    }

    public Float getLon() {
        return lon;
    }

    @Override
    public String toString() {
        return "lat=" + lat + ", lon=" + lon;
    }

}
