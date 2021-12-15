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
public class Documento extends Envio {
    private Double grosor;

    public Documento(String codigo, Double peso, Double grosor) {
        super(codigo, peso);
        this.grosor = grosor;
    }

    public Double getGrosor() {
        return grosor;
    }

    public void setGrosor(Double grosor) {
        this.grosor = grosor;
    }

    @Override
    int valor() {
        Double pesoVer = peso/1000;
        Double grosorVer = grosor/10;
        int pago =  (int) (pesoVer*grosorVer*100);
        return pago;
    }
    
    
    
    
}
