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
public class Encomienda extends Envio {
    private Double largo;
    private Double ancho;
    private Double profundidad;

    public Encomienda(String codigo, Double peso, Double largo, Double ancho, Double profundidad) {
        super(codigo, peso);
        this.largo = largo;
        this.ancho = ancho;
        this.profundidad = profundidad;
    }

    public Double getLargo() {
        return largo;
    }

    public void setLargo(Double largo) {
        this.largo = largo;
    }

    public Double getAncho() {
        return ancho;
    }

    public void setAncho(Double ancho) {
        this.ancho = ancho;
    }

    public Double getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(Double profundidad) {
        this.profundidad = profundidad;
    }
    
    

    @Override
    int valor() {
        Double pesoVer = peso/100;
        Double largoVer = largo/100;
        Double anchoVer = ancho/100;
        Double profundidadVer = profundidad/1000;        
        int pago = (int) (pesoVer*largoVer*anchoVer*profundidadVer*50);
        return pago;
    }
    
    
}
