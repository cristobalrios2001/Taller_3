/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller_3;

/**
 *
 * @author crist
 */
public class Ciudad {
    private String nombre;
    private int ganancia;
    private int cantEnviados;
    private int cantRecibidos;

    public Ciudad(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getGanancia() {
        return ganancia;
    }

    public void setGanancia(int ganancia) {
        this.ganancia = ganancia;
    }

    public int getCantEnviados() {
        return cantEnviados;
    }

    public void setCantEnviados(int cantEnviados) {
        this.cantEnviados = cantEnviados;
    }

    public int getCantRecibidos() {
        return cantRecibidos;
    }

    public void setCantRecibidos(int cantRecibidos) {
        this.cantRecibidos = cantRecibidos;
    }
    
    
}
