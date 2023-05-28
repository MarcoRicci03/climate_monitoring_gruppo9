/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classi;

/**
 * Classe per la creazione e gestione di aree d'interesse, collegate a una
 * stazione metereologica.
 *
 *
 * @author marco_ricci
 * @author edoardo_rizzi
 * @author alberto_stagno
 * @author denis_di_napoli
 */
public class JAreaInteresse {

    /**
     * Codice identificativo dell'area d'interesse.
     */
    private Integer id_area;
    /**
     * Codice della stazione metereologica a cui fa appartenenza l'area
     * d'interesse.
     */
    private Integer geoname_id;
    /**
     * Nome dell'area d'interesse.
     */
    private String nome;

    /**
     * Costruttore che imposta a 0 gli attributi della classe.
     */
    public JAreaInteresse() {
        geoname_id = 0;
        nome = "";
    }

    /**
     * Metodo per ottenere il codice identificativo della cittá dove si trova la
     * stazione metereologica.
     *
     * @param id_area Codice identificativo dell'area d'interesse.
     * @param geoname_id Codice della stazione metereologica a cui fa
     * appartenenza l'area d'interesse.
     * @param nome Nome dell'area d'interesse.
     *
     */
    public JAreaInteresse(Integer id_area, Integer geoname_id, String nome) {
        this.id_area = id_area;
        this.geoname_id = geoname_id;
        this.nome = nome;
    }

    /**
     * Metodo che permette di ottenere l'id_area dell'area d'interesse.
     *
     * @return Un'intero che rappresenta l'id_area dell'area d'interesse.
     */
    public Integer getId_area() {
        return id_area;
    }

    /**
     * Metodo per restituire il codice e il nome dell'area.
     *
     * @return Sringa contenente id_area e nome divise da ','.
     */
    @Override
    public String toString() {
        return id_area + "," + nome;
    }

    /**
     * Metodo per restituire codice e nome dell'area per comporre una lista.
     *
     * @return Sringa contenente id_area e nome divise da ' '.
     */
    public String toStringList() {
        return id_area + " " + nome;
    }

    /**
     * Metodo per restiture il nome e il geoname delle aree d'interesse.
     *
     * @return Sringa contenente nome, geoname_id divise e l'id da ','.
     */
    public String toStringInfoStazione() {
        return id_area + "," + nome;
    }

}
