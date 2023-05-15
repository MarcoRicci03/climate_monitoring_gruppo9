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

    public JCoordinate(String txt) {
        String[] v = txt.split(",");
        lat = Float.parseFloat(v[0]);
        lon = Float.parseFloat(v[1]);
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

    public double distanzaDa(JCoordinate altro) {
        double dLat = Math.toRadians(altro.lat - lat);
        double dLon = Math.toRadians(altro.lon - lon);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat)) * Math.cos(Math.toRadians(altro.lat))
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = 6371 * c;
        return distance;
    }

    public static boolean sonoCoordinate(String txt) {
        if (txt.contains(",")) {
            String[] v = txt.split(",");
            if (v.length == 2) {
                try {
                    Float f1 = Float.parseFloat(v[0]);
                    Float f2 = Float.parseFloat(v[1]);
                } catch (NumberFormatException pe) {
                    return false;
                }
            } else {
                return false;
            }

        } else {
            return false;
        }
        return true;
    }

}
