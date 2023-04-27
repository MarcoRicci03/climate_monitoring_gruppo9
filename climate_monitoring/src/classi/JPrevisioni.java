/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classi;

import java.util.Date;

/**
 *
 * @author marco
 */
public class JPrevisioni {

    private Integer id_area;
    private Date data;
    private Integer vVento; //Velocità del vento (km/h), suddivisa in fasce
    private Integer pUmidita; //% di Umidità, suddivisa in fasce
    private Integer pressione; //In hPa, suddivisa in fasce
    private Integer temperatura; //In °C, suddivisa in fasce
    private Integer aGhiacciai; //Altitudine dei ghiacciai in m, suddivisa in fasce
    private Integer mGhiacciai; //Massa dei ghiacciai in kg, suddivisisa in fasce

    public JPrevisioni() {
        this.id_area = 0;
        this.data = new Date();
        this.vVento = 0;
        this.pUmidita = 0;
        this.pressione = 0;
        this.temperatura = 0;
        this.aGhiacciai = 0;
        this.mGhiacciai = 0;
    }

    public JPrevisioni(Integer id_area, Date data, Integer vVento, Integer pUmidita, Integer pressione, Integer temperatura, Integer aGhiacciai, Integer mGhiacciai) {
        this.id_area = id_area;
        this.data = data;
        this.vVento = vVento;
        this.pUmidita = pUmidita;
        this.pressione = pressione;
        this.temperatura = temperatura;
        this.aGhiacciai = aGhiacciai;
        this.mGhiacciai = mGhiacciai;
    }

}
